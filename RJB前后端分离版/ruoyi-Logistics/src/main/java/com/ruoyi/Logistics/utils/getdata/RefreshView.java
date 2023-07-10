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
            String sql2 = "drop view if exists result;";
            String sql3 = "create view result as \n" +
                    "select a.提单号,b.货物名称,a.作业开始时间,a.作业结束时间,a.始发时间,a.到达时间,a.操作,\n" +
                    "case\n" +
                    "when a.操作=1 then greatest(0, TIMESTAMPDIFF(second,a.作业开始时间,a.始发时间))\n" +
                    "else 0\n" +
                    "end as 入库堆存时间,\n" +
                    "case\n" +
                    " when a.操作=0 then greatest(0, TIMESTAMPDIFF(second,a.到达时间,a.作业结束时间))\n" +
                    "else 0\n" +
                    "end as 出库堆存时间\n" +
                    "from user_work a,user_物流信息 b\n" +
                    "where a.提单号=b.提单号\n" +
                    "order by b.货物名称, a.提单号,a.操作 desc;";
                stmt.executeUpdate(sql.toString());
                stmt.executeUpdate(sql1.toString());
                stmt.executeUpdate(sql2.toString());
                stmt.executeUpdate(sql3.toString());

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
