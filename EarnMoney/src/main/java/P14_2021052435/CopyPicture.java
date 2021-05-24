package P14_2021052435;

import java.io.*;

/**
 * @author : ZWH 2021/5/24
 * @version : 1.0
 */
public class CopyPicture {
    public static void main(String[] args) {
        String fileName1 = "EarnMoney/src/main/java/P14_2021052435/图片1.png";
        String fileName2 = "EarnMoney/src/main/java/P14_2021052435/图片2.png";

        try (
            InputStream is = new FileInputStream(fileName1);
            OutputStream os = new FileOutputStream(fileName2)
        ) {
            int length = 0;
            byte[] buffer = new byte[1024];
            while ((length = is.read(buffer)) != -1) {
                os.write(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}