package P01_Language.P01_BasicGrammar.C04_Equals_Hashcode_;

/**
 * @author : ZWH 2021/4/26
 * @version : 1.0
 */
public class Equals_Hashcode {
    public static void main(String[] args) {
        String s1 = new String("1");//强制创建新的对象
        String s2 = new String("1");
        String s3 = "1";//字符串常量池，属于方法区

        //equals()：只能比较引用对象
        //重写前（和==相同）比较栈中引用地址
        //重写后一般比较对象属性，String类重写了equals方法，比较了引用对象中的值
        System.out.println( s1.equals(s2) );//true
        System.out.println( s1.equals(s3) );//true

        //hashCode()：提高在散列结构中的查找效率
        //不用遍历，将集合分成若干存储区域，计算哈希码，根据哈希码分组快速定位
        //所以先比hashCode再用equals
    }
}
