package P00_NeedClassify;

/**
 * @author : ZWH 6/1/21
 * @version : 1.0
 */
public class CompressString {
    public static void main(String[] args) {
        System.out.println(compressString("aabcccccaaa"));//输出：a2b1c5a3
        System.out.println(compressString("abbccd"));//输出：abbccd。 abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长
    }

    public static String compressString(String str) {
        if (str == null || str.length() == 0) return str;

        int len = str.length();
        StringBuffer strCompress = new StringBuffer();
        char temp = str.charAt(0);
        int count = 1;
        for (int i = 1; i < len; i++) {
            if (temp == str.charAt(i))
                count++;
            else {
                strCompress.append(temp);
                strCompress.append(count);
                temp = str.charAt(i);
                count = 1;
            }
        }
        strCompress.append(temp);
        strCompress.append(count);

        if (strCompress.length() >= str.length())
            return str;
        return strCompress.toString();
    }

}
