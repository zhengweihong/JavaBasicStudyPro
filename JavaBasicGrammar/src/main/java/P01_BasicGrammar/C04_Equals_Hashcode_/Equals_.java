package P01_BasicGrammar.C04_Equals_Hashcode_;

/**
 * @author : ZWH 2021/4/26
 * @version : 1.0
 */
public class Equals_ {
    public static void main(String[] args) {
        //基本数据类型：==比较值（作为常量，存在方法区的常量池里HashSet）
        //引用类型：==比较栈中引用地址
        int a = 1;
        int b = 1;
        System.out.println( a==b );//true

        String s1 = new String("1");//强制创建新的对象
        String s2 = new String("1");
        System.out.println( s1==s2 );//false
        String s3 = "1";//字符串常量池，属于方法区
        String s4 = "1";
        System.out.println( s3==s4 );//true

        System.out.println( s1==s4 );//false
        //String类重写了equals方法，比较了引用对象中的值
        System.out.println( s1.equals(s2) );//true
        System.out.println( s1.equals(s3) );//true


        //包装类除了Float、Double都实现了常量池
        Integer c = 1;
        Integer d = 1;
        System.out.println( c==d );//true
        Integer e = new Integer(1);
        System.out.println( c==e );//false

        Integer c1 = 128;
        Integer d1 = 128;
        System.out.println( c1==d1 );//false
        //Integer常量池的范围是[-128,127]，128在堆中创建新对象保存

        //Integer自动拆箱
        System.out.println( a==c );//true
        int a1 = 128;
        System.out.println( a1==c1 );//true
    }
}
