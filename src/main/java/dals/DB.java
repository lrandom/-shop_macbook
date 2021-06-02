package dals;

import models.Category;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    public static final String MYSQL_URI_CONNECT = "jdbc:mysql://localhost:3306/";
    public static final String DB_NAME = "shop_macbook";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "koodinh";
    protected Connection connection;
    protected String tableName = "";
    protected DB db = null;

    public DB() {
        try {
            if (this.connection == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection(MYSQL_URI_CONNECT + "" + DB_NAME, DB_USER, DB_PASS);
                Statement stm = this.connection.createStatement();
                stm.executeQuery("SET NAMES 'UTF8'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void closeConnect() {
        this.connection = null;
    }

    public void setTableName(String tableNameParam) {
        this.tableName = tableNameParam;
    }

}
