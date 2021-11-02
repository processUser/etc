package org.iptime.mypj;

import java.sql.*;

public class DbUtils {
    public static Connection getCon() throws SQLException, ClassNotFoundException {
        final String URL = "jdbc:mysql://mypj.iptime.org:3306/test01";
        final String USERNAME = "test01";
        final String PASSWORD = "test01";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("접속 성공!");
        return con;
    }

    public static void close(Connection con, PreparedStatement ps){
        close(con,ps,null);
    }
    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
