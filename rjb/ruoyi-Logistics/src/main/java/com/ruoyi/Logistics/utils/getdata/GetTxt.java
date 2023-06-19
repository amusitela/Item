package com.ruoyi.Logistics.utils.getdata;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("all")
public class GetTxt {


    /**
     * @param args
     */

    public static void main(String[] args) throws IOException, SQLException {
        String filepath="C:\\Users\\18132\\Desktop\\装货表.txt";
        txtToDB(filepath);
    }
    public static void txtToDB(String filepath) throws IOException, SQLException {

        String driver = "dm.jdbc.driver.DmDriver";
        String url = "jdbc:dm://localhost:5236";
        String username = "RJBR";
        String password = "123456";
        Connection conn = null;
        Statement stmt = null;
        File file = new File(filepath);
        StringBuffer sql = null;
        BufferedReader reader = null;
        String line = null;
        String[] str = null, name = null;
        int cnt = 0;

        String[] user_wk= {"船公司","船名称","作业开始时间","作业结束时间","始发时间","到达时间","作业港口","提单号","集装箱箱号","箱尺寸（TEU）","启运地","目的地"};
        String[] user_xx= {"提单号","货主名称","货主代码","物流公司（货代）","集装箱箱号","货物名称","货重（吨）"};
        String[] user_jzx= {"堆存港口","集装箱箱号","箱尺寸（TEU）","提单号","堆场位置","操作","操作日期"};
        String[] user_kh= {"客户名称","客户编号","手机号","省市区"};
        String[] user_wl= {"公司名称","客户编号","联系人","电话","省市区"};
        String[] column ={"temp_work","temp_物流信息"," temp_集装箱动态","temp_客户信息","temp_物流公司"};
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
                    name = line.split(",");
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
                    cnt++;
                    continue;
                }

                str = line.split("\'"+','+"\'");
                if (str.length == 1) continue;
                sql.append("insert into "+ b +"(");
                for (int j = 0; j < name.length; j++) {
                        sql.append(name[j]);
                    if (j < name.length -1) sql.append(",");
                }
                if(b=="temp_work") {
                    sql.append(",操作,异常) values(");
                }
                else{
                    sql.append(",异常) values(");
                }
                for (int i = 0; i < str.length; i++) {
                    String s = str[i];
                    if (s.length() >= 5 && s.charAt(4) == '-') {
                        sql.append("datetime");
                    }
                    if(i==0) {
                        sql.append(s +'\'');
                    }
                    else if(i== str.length-1){
                        sql.append('\''+s);
                    }
                    else {
                        sql.append('\''+s +'\'');
                    }
                    if (i < name.length - 1) sql.append(",");
                }
                //z装货为一，卸货为0
                if(b=="temp_work"&&filepath.contains("装货表")){
                    sql.append(",1 , 0 )");
                }
                else if(b=="temp_work"&&filepath.contains("卸货表")) {
                    sql.append(",0 , 0 )");
                }
                else {
                    sql.append(",0 )");
                }
                System.out.println(sql);
                stmt.executeUpdate(sql.toString());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    stmt.close();
                    conn.close();
                } catch (IOException e) {
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
        if (!arr1[i].contains(arr2[i])) {
            return false;
        }
    }
    return  true;
}
}