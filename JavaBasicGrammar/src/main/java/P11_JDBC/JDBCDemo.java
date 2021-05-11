package P11_JDBC;

import java.sql.*;

/**
 * @author : ZWH 2021/5/10
 * @version : 1.0
 */
public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test_db?useSSL=false",
                "root",
                "rpzqmysql");
        //MySQL在高版本需要指明是否进行SSL连接
        System.out.println(conn);//com.mysql.cj.jdbc.ConnectionImpl@1df82230

        String sql = "select * from yjdept";
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(sql);

        while(rs.next()) {
            int aInt = rs.getInt(1);//index from 1
            String dname = rs.getString("dname");
            System.out.println(aInt+"   "+dname);
        }

        rs.close();
        stat.close();
        conn.close();
    }
}
