package P12_Visitor.ASM;

import org.objectweb.asm.*;

import java.io.*;

import static org.objectweb.asm.Opcodes.*;

/**
 * @author : ZWH
 * @date : 2024/02/16
 * @Description : ASM，解析已有class文件-打印，用代码在内存里生成class文件-使用或输出
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        ClassReader cr = new ClassReader("java.lang.Object");
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("P12_Visitor/ASM/Test.class")
        );
        ClassPrinter cp = new ClassPrinter();
        // accept内部类似模版，调用ClassPrinter内重写的方法
        cr.accept(cp, 0);


        // 开始写一个空文件
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_5, ACC_PUBLIC + ACC_ABSTRACT + ACC_INTERFACE,
                "pkg/Comparable", null, "java/lang/Object", null);
        cw.visitField(ACC_PUBLIC + ACC_FINAL + ACC_STATIC,
                "LESS", "I", null, -1).visitEnd();
        cw.visitMethod(ACC_PUBLIC + ACC_ABSTRACT,
                "compareTo", "(Ljava/lang/Object;)I", null, null).visitEnd();
        cw.visitEnd();
        // 使用或输出
        byte[] b = cw.toByteArray();
        ClassLoaderImpl classLoader = new ClassLoaderImpl();
        Class aClass = classLoader.defineClass("pkg.Comparable", b);
        System.out.println(aClass.getMethods()[0].getName());
        printBytesToFile(b, "Comparable.class");


        // Read读取 Read接收Write（执行了Write各种visit） Write输出
        ClassReader classReader = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("P12_Visitor/ASM/Test.class")
        );
        ClassWriter classWriter = new ClassWriter(0);
        classReader.accept(classWriter, 0);
        byte[] b2 = classWriter.toByteArray();
        printBytesToFile(b2, "Test.class");
        // Read读取 new出自定义Visitor时传入Write形成链-Visitor-Write Read接收Visitor Write输出
        ClassReader reader = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("P12_Visitor/ASM/Test.class")
        );
        ClassWriter writer = new ClassWriter(0);
        ClassVisitor visitor = new ClassVisitor(ASM4, writer) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        // TestProxy类应该写一份，但是没写
                        visitMethodInsn(INVOKESTATIC, "TestProxy", "before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };
        reader.accept(visitor, 0);
        byte[] b3 = writer.toByteArray();
        printBytesToFile(b3, "TestAddProxy.class");
    }

    private static void printBytesToFile(byte[] b, String fileName) throws IOException {
        String path = (String) System.getProperties().get("user.dir");
        File file = new File(path + "/com/DesignPattern/P12_Visitor/ASM/");
        file.mkdirs();
        FileOutputStream fos = new FileOutputStream(new File(path + "/com/DesignPattern/P12_Visitor/ASM/" + fileName));
        fos.write(b);
        fos.flush();
        fos.close();
    }
}

class ClassLoaderImpl extends ClassLoader {
    public Class defineClass(String name, byte[] b) {
        return defineClass(name, b, 0, b.length);
    }
}
