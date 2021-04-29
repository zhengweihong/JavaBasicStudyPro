package P01_20210426XYWX80.Q04;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author : ZWH 2021/4/29
 * @version : 1.0
 */
public class Database2Txt {
    public static void main(String[] args) {
        new Database2Txt().database2Txt("/Users/zwh/WorkSpace/IDEAWorkspace/JavaBasicStudyPro/JavaBasicGrammar/src/main/resources/a.txt");
    }

    public void database2Txt(String filename) {
        String driverName = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "rpzqmysql";
        String url = "jdbc:mysql://localhost:3306/test_db?useSSL=false";

        String sql = "SELECT * FROM item";
        ArrayList<HashMap<String,Object>> rslist = null;
        Connection conn = null;
        Statement statement = null;
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            rslist = new ArrayList<HashMap<String,Object>>();
            while (rs.next()) {
                HashMap<String,Object> map = new HashMap<String,Object>();
                map.put("number",rs.getString("number"));
                map.put("price",rs.getString("price"));
                rslist.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        OutputStream os = null;
        try {
            os = new FileOutputStream(filename);
            for (HashMap<String, Object> map : rslist) {
                os.write(map.get("number").toString().getBytes());
                os.write(" ".getBytes());
                os.write(map.get("price").toString().getBytes());
                os.write("\n".getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
