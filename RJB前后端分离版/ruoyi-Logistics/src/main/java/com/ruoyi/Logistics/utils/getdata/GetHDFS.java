package com.ruoyi.Logistics.utils.getdata;

import com.ruoyi.Logistics.utils.getdata.GetTxt;
import org.apache.commons.collections4.Get;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataInputStream;

import java.io.*;
import java.sql.SQLException;

public class GetHDFS {

    public static void getHdfs( String hdfsInputFile,String localOutputFile,String uri) {
        try {
            // 创建Hadoop配置对象
            Configuration conf = new Configuration();
            // 设置HDFS文件系统的URI
            conf.set("fs.defaultFS", uri);
            // 创建HDFS文件系统对象
            FileSystem fs = FileSystem.get(conf);

            // 读取HDFS中的TXT文件
            BufferedReader br = new BufferedReader(new InputStreamReader(fs.open(new Path(hdfsInputFile)), getCharset(hdfsInputFile)));
            // 创建本地输出文件的写入器
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(localOutputFile), getCharset(hdfsInputFile)));

            String line;
            while ((line = br.readLine()) != null) {
                // 将读取的内容写入本地输出文件
                bw.write(line);
                bw.newLine();
            }

            GetTxt.txtToDB(localOutputFile);

            // 关闭读写器
            br.close();
            bw.close();

            System.out.println("HDFS TXT file has been successfully read and saved to a local file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        }
        return code;
    }



}