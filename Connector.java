package ADF2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Connector {
    public Connection conn;
    private static Connector instance;
    private Connector(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String URL = "jdbc:mysql://localhost:3306/T1808M";
            conn = DriverManager.getConnection(URL, "nguyenthao","minhquan1525");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Connector getInstance(){
        if (instance == null){
            instance = new Connector();
        }
        return instance;
    }
    public ResultSet getQuery(String sql) throws Exception{
        Statement statement = conn.createStatement();
        return statement.executeQuery(sql);
    }
    public int updateQuery(String sql) throws Exception {
        Statement statement = conn.createStatement();
        return statement.executeUpdate(sql);
    }
}
