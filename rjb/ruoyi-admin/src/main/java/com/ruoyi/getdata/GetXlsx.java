package com.ruoyi.getdata;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @User: Mr.Yang
 * @Date: 2023/6/3
 */
public class GetXlsx {

    public static void main(String[] args) {
        String filepath="C:\\Users\\18132\\Desktop\\data.csv";
        excelFind(filepath);
    }

    public static void excelFind(String filepath) {
        try {
            //初始化
            String driver = "dm.jdbc.driver.DmDriver";

            String url = "jdbc:dm://localhost:5236";

            String username = "RJB";

            String password = "123456";

            Connection conn = null;

            Statement stmt = null;
            String[] column ={" user_work","user_物流信息"," user_集装箱","user_客户信息","user_物流公司"};

            StringBuffer sql, sql2 = null;

            Class.forName(driver);

            conn = DriverManager.getConnection(url, username, password);

            stmt = conn.createStatement();

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(filepath));
            //获取工作簿下sheet的个数
            int sheetNum = xssfWorkbook.getNumberOfSheets();

            //System.out.println("总数页码："+sheetNum);

            //遍历页码：
            for(int i = 0;i<sheetNum;i++) {

                //System.out.println("读取第"+(i+1)+"个sheet");

                //sheet的索引下标是从0开始的，得到该页码的对象
                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);

                String Name = sheet.getSheetName();
                //获取总共的行数
                int maxRow = sheet.getLastRowNum();

                String name[] = new String[100];

                sql = new StringBuffer();

                // System.out.println("表名称: " + sheet.getSheetName());
                //合并作业表
                if (Name.equals("装货表") || Name.equals("卸货表")) {

                    sql.append("insert into user_work" + "(");

                    //对每一行进行遍历
                    for (int row = 0; row <= maxRow; row++) {

                        sql2 = new StringBuffer();

                        //getRow(row_num)获取该行的对象，再.getLastCellNum()获取该行共有几列
                        //此处与sheet不同的是，该索引下标是从1开始的
                        int maxRol = sheet.getRow(row).getLastCellNum();
                        // System.out.println("--------第" + row + "行的数据如下--------");
                        //遍历列数
                        for (int rol = 0; rol < maxRol; rol++) {

                            if (row == 0) {

                                name[rol] = sheet.getRow(row).getCell(rol).toString();

                                name[rol].replaceAll("\\s+", "");
                                if(name[rol].contains("（")) {
                                    sql.append("\"" + name[rol] + "\"");
                                }else{
                                    sql.append(name[rol]);
                                }
                                if (rol < maxRol ) sql.append(",");

                            } else {

                                String cell = sheet.getRow(row).getCell(rol).toString();

                                sql2.append("'" + cell + "'");

                                if (rol < maxRol) sql2.append(",");

                            }
                            //sheets.getRow(1).getCell(1);获取元素值
                            //System.out.print(sheet.getRow(row).getCell(rol) + "  ");

                        }

                        if (row == 0) {sql.append("操作) values(");}

                        else {
                            String flags = "1";
                            if(Name.equals("卸货表")){flags="0";}

                            sql2.append(flags + ")");

                            String res = sql.toString() +sql2.toString();

                            System.out.println(res);
                            stmt.executeUpdate(res);
                        }
                    }
                }
                  else {
                    sql.append("insert into user_" + Name + "(");

                    //对每一行进行遍历
                    for (int row = 0; row <= maxRow; row++) {
                        sql2 = new StringBuffer();

                        //getRow(row_num)获取该行的对象，再.getLastCellNum()获取该行共有几列
                        //此处与sheet不同的是，该索引下标是从1开始的
                        int maxRol = sheet.getRow(row).getLastCellNum();

                        // System.out.println("--------第" + row + "行的数据如下--------");
                        //遍历列数
                        for (int rol = 0; rol < maxRol; rol++) {

                            if (row == 0) {

                                name[rol] = sheet.getRow(row).getCell(rol).toString();

                                name[rol].replaceAll("\\s+", "");
                                if(name[rol].contains("（")) {
                                    sql.append("\"" + name[rol] + "\"");
                                }else{
                                    sql.append(name[rol]);
                                }

                                if (rol < maxRol - 1) sql.append(",");

                            } else {

                                String cell = sheet.getRow(row).getCell(rol).toString();

                                sql2.append("'" + cell + "'");

                                if (rol < maxRol - 1) sql2.append(",");

                            }
                            //sheets.getRow(1).getCell(1);获取元素值
                            //System.out.print(sheet.getRow(row).getCell(rol) + "  ");

                        }

                        if (row == 0) sql.append(") values(");

                        else {

                            sql2.append(")");

                            String res = sql.toString() + sql2.toString();

                            System.out.println(res);
                            stmt.executeUpdate(res);
                        }
                    }
                }
            }
            stmt.close();
            conn.close();
        } catch (IOException e) {

            e.printStackTrace();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
