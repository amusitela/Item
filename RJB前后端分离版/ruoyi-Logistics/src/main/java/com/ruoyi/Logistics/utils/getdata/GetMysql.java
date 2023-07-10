package com.ruoyi.Logistics.utils.getdata;

import com.ruoyi.common.annotation.DataSource;

import java.sql.*;
import java.util.Arrays;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class GetMysql {

    public static void DataTransfer(String url,String username,String password,String source_table,String target_table) {

        String[] user_wk= {"船公司","船名称","作业开始时间","作业结束时间","始发时间","到达时间","作业港口","提单号","集装箱箱号","箱尺寸（TEU）","启运地","目的地"};
        String[] user_xx= {"提单号","货主名称","货主代码","物流公司（货代）","集装箱箱号","货物名称","货重（吨）"};
        String[] user_jzx= {"堆存港口","集装箱箱号","箱尺寸（TEU）","提单号","堆场位置","操作","操作日期"};
        String[] user_kh= {"客户名称","客户编号","手机号","省市区"};
        String[] user_wl= {"公司名称","客户编号","联系人","电话","省市区"};
        String[] table={"装货","卸货","物流信息","集装箱动态","客户信息","物流公司"};

        Connection sourceConn = null;
        Connection targetConn = null;
        Statement sourceStmt = null;
        Statement targetStmt = null;
        ResultSet rs = null;

        try {
            // 连接到源数据库
            String sourceUrl = url;
            String sourceUsername = username;
            String sourcePassword = password;
            String driver1 = "com.mysql.cj.jdbc.Driver";

            Class.forName(driver1);
            sourceConn = DriverManager.getConnection(sourceUrl, sourceUsername, sourcePassword);
            System.out.println("Connected to source database!");

            // 连接到目标数据库
            String driver = "dm.jdbc.driver.DmDriver";
            String targetUrl = "jdbc:dm://localhost:5236";
            String targetUsername = "RJB";
            String targetPassword = "123456";

            Class.forName(driver);
            targetConn = DriverManager.getConnection(targetUrl, targetUsername, targetPassword);
            System.out.println("Connected to target database!");

            // 查询源数据库的数据
            sourceStmt = sourceConn.createStatement();
            String sql = "SELECT * FROM " + source_table;
            rs = sourceStmt.executeQuery(sql);

            // 将数据插入到目标数据库
            targetStmt = targetConn.createStatement();
            while (rs.next()) {
                String insertSql=null;
                String a="(";

                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                // 创建一个数组来存储一行的数据
                Object[] rowData = new Object[columnCount];

                // 遍历每一列，并将值存储到数组中
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i-1] = rs.getObject(i);
                    String b =rowData[i-1].toString();
                    System.out.println(b);
                    if(b!=null){
                        if(b.matches("^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$")){
                            a+="datetime";
                        }else if(b.matches("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$")){
                            a+="datetime";
                            b=b.replace("T"," ");
                            a+="'"+b+"',";
                            continue;
                        }
                        a+="'"+rowData[i-1].toString()+"',";

                    }
                }
                // System.out.print(a);

                if(source_table.contains(table[0])){
                    // 构建插入语句，并执行
                    insertSql = "INSERT INTO "+target_table+" (作业号,船公司,船名称,作业开始时间,作业结束时间,始发时间,到达时间,作业港口,提单号,集装箱箱号,\"箱尺寸（TEU）\",启运地,目的地,操作,异常) VALUES "+a+"1,0)";
                }else if (source_table.contains(table[1])){

                    insertSql = "INSERT INTO "+target_table+" (作业号,船公司,船名称,作业开始时间,作业结束时间,始发时间,到达时间,作业港口,提单号,集装箱箱号,\"箱尺寸（TEU）\",启运地,目的地,操作,异常) VALUES "+a+"0,0)";

                }else if (source_table.contains(table[2])){

                    insertSql = "INSERT INTO "+target_table+" (提单号,货主名称,货主代码,\"物流公司（货代）\",集装箱箱号,货物名称,\"货重（吨）\",异常) VALUES "+a+"0)";

                }else if (source_table.contains(table[3])){

                    insertSql = "INSERT INTO "+target_table+" (流水号,堆存港口,集装箱箱号,\"箱尺寸（TEU）\",提单号,堆场位置,操作,操作日期,异常) VALUES "+a+"0)";

                }else if (source_table.contains(table[4])){

                    insertSql = "INSERT INTO "+target_table+" (客户名称,客户编号,手机号,省市区,异常) VALUES "+a+"0)";

                }else if (source_table.contains(table[5])){

                    insertSql = "INSERT INTO "+target_table+" (公司号,公司名称,客户编号,联系人,电话,省市区,异常) VALUES "+a+"0)";

                }else{
                    System.out.println("表名错误");
                }


//                    System.out.println(insertSql);
                targetStmt.executeUpdate(insertSql);
            }

            System.out.println("Data transferred successfully!");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接和结果集
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (sourceStmt != null) {
                try {
                    sourceStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (targetStmt != null) {
                try {
                    targetStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            // 关闭连接
            if (sourceConn != null) {
                try {
                    sourceConn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (targetConn != null) {
                try {
                    targetConn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
