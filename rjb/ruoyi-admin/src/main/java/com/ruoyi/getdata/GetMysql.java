package com.ruoyi.getdata;

import java.sql.*;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class GetMysql {
    // MySQL JDBC 接口
    private String driver = "com.mysql.jdbc.Driver";
    // MySQL 数据库 URL
    private String url = "jdbc:mysql://localhost:3306/db_name";
    // 数据库用户
    private String user = "root";
    // 数据库密码
    private String password = "123456";

    /**
     * 连接 MySQL 数据库
     */
    public Connection getConnection() {
        Connection con = null;
        try {
            // 加载 MySQL JDBC 驱动
            Class.forName(driver);
            // 获取数据库连接
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 执行查询语句
     */
    public ResultSet executeQuery(String sql) {
        Connection con = getConnection();
        ResultSet rs = null;
        try {
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 执行更新操作，包括插入、更新、删除等
     */
    public int executeUpdate(String sql) {
        Connection con = getConnection();
        int result = 0;
        try {
            Statement stmt = con.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            result = -1;
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
