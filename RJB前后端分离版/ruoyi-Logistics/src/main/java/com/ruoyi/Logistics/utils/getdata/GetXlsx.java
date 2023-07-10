package com.ruoyi.Logistics.utils.getdata;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @User: Mr.Yang
 * @Date: 2023/6/3
 */
@SuppressWarnings("all")
public class GetXlsx {

    public static void main(String[] args) {
        String filepath="C:\\Users\\18132\\Desktop\\集装箱动态2021.xlsx";
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
            String[] user_wk = {"船公司", "船名称", "作业开始时间", "作业结束时间", "始发时间", "到达时间", "作业港口", "提单号", "集装箱箱号", "箱尺寸（TEU）", "启运地", "目的地"};
            String[] user_xx = {"提单号", "货主名称", "货主代码", "物流公司（货代）", "集装箱箱号", "货物名称", "货重（吨）"};
            String[] user_jzx = {"堆存港口", "集装箱箱号", "箱尺寸（TEU）", "提单号", "堆场位置", "操作", "操作日期"};
            String[] user_kh = {"客户名称", "客户编号", "手机号", "省市区"};
            String[] user_wl = {"公司名称", "客户编号", "联系人", "电话", "省市区"};
            String[] column = {"temp_work","temp_物流信息","temp_集装箱动态","temp_客户信息","temp_物流公司"};
            String b = null;
            StringBuffer sql, sql2 = null;
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();
            XSSFWorkbook xssfWorkbook = null;

            if(filepath.contains(".csv")){
                try {
                    // 创建工作簿和工作表
                    Workbook workbook = new SXSSFWorkbook();
                    Sheet sheet = workbook.createSheet("Sheet1");

                    // 读取CSV文件并逐行处理
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath),getCharset(filepath)));
                    String line;
                    int rowNum = 0;
                    int cnt = 0;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",");

                        // 创建行对象
                        Row row = sheet.createRow(rowNum++);

                        // 在每行中创建单元格并填充数据
                        for (int i = 0; i < data.length; i++) {
                            Cell cell = row.createCell(i);
                            cell.setCellValue(data[i]);
                        }
                    }

                    String replace = filepath.replace(".csv", ".xlsx");
                    // 写入到XLSX文件
                    FileOutputStream outputStream = new FileOutputStream(replace);
                    workbook.write(outputStream);
                    workbook.close();
                    outputStream.close();

                    xssfWorkbook = new XSSFWorkbook(new FileInputStream(replace));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                xssfWorkbook=new XSSFWorkbook(new FileInputStream(filepath));
            }

            //获取工作簿下sheet的个数
            int sheetNum = xssfWorkbook.getNumberOfSheets();
            //System.out.println("总数页码："+sheetNum);
            //遍历页码：
            for(int i = 0;i<sheetNum;i++) {

                //System.out.println("读取第"+(i+1)+"个sheet");
                //sheet的索引下标是从0开始的，得到该页码的对象
                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
                //获取总共的行数
                int maxRow = sheet.getLastRowNum();
                sql = new StringBuffer();

                int rw = 0;
                int tmpRol = sheet.getRow(rw).getLastCellNum();
                int maxRol = sheet.getRow(rw).getLastCellNum();
                String name[] = new String[maxRol];
                for (int rl = 0; rl < tmpRol; rl ++ ) {
                    name[rl] = sheet.getRow(rw).getCell(rl).toString();
                    String s = name[rl].replaceAll("\\s+", "");
                    name[rl]=s;
                    //System.out.print(name[rl]+" ");
                }
                System.out.println();
                if (compareName(name, user_wk)) {
                    b = column[0];
                } else if (compareName(name, user_xx)) {
                    b = column[1];
                } else if (compareName(name, user_jzx)) {
                    b = column[2];
                } else if (compareName(name, user_kh)) {
                    b = column[3];
                } else if (compareName(name, user_wl)) {
                    b = column[4];
                }

                String Name = sheet.getSheetName();
                // System.out.println("表名称: " + sheet.getSheetName());
                //合并作业表
                if (b == "temp_work") {
                    sql.append("insert into temp_work" + "(");
                    //对每一行进行遍历
                    for (int row = 0; row <= maxRow; row++) {
                        sql2 = new StringBuffer();
                        //getRow(row_num)获取该行的对象，再.getLastCellNum()获取该行共有几列
                        //此处与sheet不同的是，该索引下标是从1开始的

                        // System.out.println("--------第" + row + "行的数据如下--------");
                        //遍历列数
                        for (int rol = 0; rol < maxRol; rol++) {
                            if (row == 0) {
                                name[rol] = sheet.getRow(row).getCell(rol).toString();
                                String s = name[rol].replaceAll("\\s+", "");
                                name[rol]=s;
                                if(name[rol].contains("（")) {
                                    sql.append("\"" + name[rol] + "\"");
                                }else{
                                    sql.append(name[rol]);
                                }
                                if (rol < maxRol ) sql.append(",");
                            } else {
                                String cell = sheet.getRow(row).getCell(rol).toString();
                                //System.out.println(cell);
                                String replace = cell.replace("\'", "");
                                if (replace.matches("^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$")) {
                                    sql2.append("datetime");
                                }
                                if(cell.contains("\'")){
                                    sql2.append(cell);
                                }else{
                                    sql2.append("'"+cell+"'");
                                }
                                if (rol < maxRol) sql2.append(",");
                            }

                        }
                        if (row == 0) {sql.append("操作, 异常 ) values(");}
                        else {
                            String flags = "1";
                            if(Name.equals("卸货表")||filepath.equals("卸货表")){flags="0";}
                            sql2.append(flags + ", 0)");
                            String res = sql.toString() +sql2.toString();
                            System.out.println(res);
                            stmt.executeUpdate(res);
                        }
                    }
                }
                else {
                    sql.append("insert into " + b + "(");
                    //对每一行进行遍历
                    for (int row = 0; row <= maxRow; row++) {
                        sql2 = new StringBuffer();
                        //getRow(row_num)获取该行的对象，再.getLastCellNum()获取该行共有几列
                        //此处与sheet不同的是，该索引下标是从1开始的
                        // System.out.println("--------第" + row + "行的数据如下--------");
                        //遍历列数
                        for (int rol = 0; rol < maxRol; rol++) {
                            if (row == 0) {
                                name[rol] = sheet.getRow(row).getCell(rol).toString();
                                String s = name[rol].replaceAll("\"", "");
                                name[rol]=s;

                                if(name[rol].contains("（")) {
                                    sql.append("\"" + name[rol] + "\"");
                                }else{
                                    sql.append(name[rol]);
                                }
                                if (rol < maxRol - 1) sql.append(",");

                            } else {
                                String cell = sheet.getRow(row).getCell(rol).toString();
                                String replace = cell.replace("\'", "");
                                if (replace.matches("^\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}$") || replace.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                                    sql2.append("datetime");
                                }
                                if(cell.contains("\'")){
                                    sql2.append(cell);
                                }else{
                                    sql2.append("'"+cell+"'");
                                }
                                if (rol < maxRol - 1) sql2.append(",");
                            }
                            //sheets.getRow(1).getCell(1);获取元素值
                            //System.out.print(sheet.getRow(row).getCell(rol) + "  ");
                        }
                        if (row == 0) sql.append(",异常) values(");
                        else {
                            sql2.append(",0)");
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

    public static String getCharset(String fileName) throws IOException {

        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        int p = (bin.read() << 8) + bin.read();

        String code = null;

        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
                break;
        }
        return code;
    }
}
