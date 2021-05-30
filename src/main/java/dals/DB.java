package dals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public abstract class DB {
    public static final String MYSQL_URI_CONNECT = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "shop_macbook";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "koodinh";
    protected Connection connection;

    public DB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(MYSQL_URI_CONNECT + "/" + DB_NAME, DB_USER, DB_PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnect() {
        this.connection = null;
    }

    public abstract ResultSet getList();

    public abstract boolean update();

    public abstract boolean delete();

    public abstract boolean insert();
}
