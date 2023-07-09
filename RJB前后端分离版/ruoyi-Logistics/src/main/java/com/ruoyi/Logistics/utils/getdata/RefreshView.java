package com.ruoyi.Logistics.utils.getdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class RefreshView {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Create();
    }


public static void Create() throws ClassNotFoundException, SQLException {
        String driver = "dm.jdbc.driver.DmDriver";
        String url = "jdbc:dm://localhost:5236";
        String username = "RJB";
        String password = "123456";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            String sql="drop view if exists port_throughput_view;";
            String sql1=
                    "        CREATE VIEW port_throughput_view\n" +
                    "        AS\n" +
                    "        select user_work.提单号,作业港口,\"货重（吨）\",\"箱尺寸（TEU）\",操作,启运地,目的地,到达时间,始发时间,user_work.集装箱箱号,货物名称\n" +
                    "        from user_work join user_物流信息 on user_work.提单号=user_物流信息.提单号\n" +
                    "        order by 作业港口;";
                stmt.executeUpdate(sql.toString());
                stmt.executeUpdate(sql1.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                    stmt.close();
                    conn.close();
            }
   }
}
