package com.ruoyi.sql;

import java.io.BufferedReader;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.IOException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;


public class GetTxt {


    /**
     * @param args
     */

    public static void main(String[] args) throws IOException, SQLException {
        txtToDB();
    }
    public static void txtToDB() throws IOException, SQLException {

        // TODO Auto-generated method stub

        String driver = "dm.jdbc.driver.DmDriver";

        String url = "jdbc:dm://localhost:5236";

        String username = "RJB";

        String password = "123456";

        Connection conn = null;

        Statement stmt = null;

        File file = new File("D:\\test.txt");

        StringBuffer sql = null;

        BufferedReader reader = null;

        String line = null;

        String[] str = null, name = null;

        int cnt = 0;

        String[] user_wk= {"船公司","船名称","作业开始时间","作业结束时间","始发时间","到达时间","作业港口","提单号","集装箱箱号","箱尺寸","启运地","目的地"};
        String[] user_xx= {"提单号","货主名称","货主代码","物流公司","集装箱箱号","货物名称","货重"};
        String[] user_jzx= {"堆存港口","集装箱箱号","箱尺寸","提单号","堆场位置","操作","操作日期",};
        String[] user_kh= {"客户名称","客户编号","手机号","省市区"};
        String[] user_wl= {"公司名称","客户编号","联系人","电话","省市区"};
        String[] column ={"user_work","user_物流信息"," user_集装箱动态","user_客户信息","user_物流公司"};
        String b=null;
        try {

            Class.forName(driver);

            conn = DriverManager.getConnection(url, username, password);

            reader = new BufferedReader(new FileReader(file));

            stmt = conn.createStatement();
            int flags1 = 0;
            while ((line = reader.readLine()) != null) {
                sql = new StringBuffer();
                if (cnt == 0) {
                    name = line.split("\\s+");
//                    for (int i = 0; i < name.length; i++) {
////                        if(name[i]!=user_wl[i]){
////                           // flags1 = false;
////                            break;
////                        }
//                        System.out.println(name[i]+" "+user_wl[i]);
//                    }

                    if(GetTxt.compareName(name,user_wk)){
                        b=column[0];
                    }
                      else if(GetTxt.compareName(name,user_xx)){
                        b=column[1];
                    } else if(GetTxt.compareName(name,user_jzx)){
                        b=column[2];
                    } else if(GetTxt.compareName(name,user_kh)){
                        b=column[3];
                    } else if(GetTxt.compareName(name,user_wl)){
                        b=column[4];
                    }

//                    sql.append("create table if not exists 物流 (");


//
//                    //sql.append(")");
//
//                    stmt.executeUpdate(sql.toString());

                    cnt++;

                    continue;
                }

                str = line.split("\\s+");

                if (str.length == 1) continue;

                sql.append("insert into "+ b +"(");

                for (int j = 0; j < name.length; j++) {

                    sql.append(name[j]);

                    if (j < name.length - 1) sql.append(",");

                }

                sql.append(") values(");

                for (int i = 0; i < str.length; i++) {

                    String s = str[i];

                    if (s.length() >= 5 && s.charAt(4) == '-') {
                        s = s + str[i + 1];
                        i++;
                    }

                    sql.append("'" + s + "'");

                    if (i < name.length - 1) sql.append(",");

                }

                sql.append(")");

                //System.out.println(sql);

                stmt.executeUpdate(sql.toString());
            }

        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } catch (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } catch (SQLException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } finally {

            if (reader != null) {

                try {

                    reader.close();
                    stmt.close();

                } catch (IOException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                }

            }

        }

    }

public static boolean compareName(String[] arr1, String[] arr2) {
    if (arr1.length != arr2.length) {
        return false;
    }
    for (int i = 0; i < arr1.length; i++) {
        if (!arr1[i].equals(arr2[i])) {
            return false;
        }
    }
    return  true;
}
}