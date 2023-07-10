package com.ruoyi.Logistics.clean.controller;

import com.ruoyi.Logistics.utils.getdata.*;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.file.FileUploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
@Controller
@RequestMapping("/getdata")
public class GetDataController {

    @PostMapping("/wenben")
    @ResponseBody
    public AjaxResult GetWenben(MultipartFile file) throws IOException, SQLException {
        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath();
        String filename = filePath+FileUploadUtils.upload(filePath, file);
        String replace = filename.replace("upload/profile/", "");
        filename=replace;

       if(filename.contains(".txt")){
           GetTxt.txtToDB(filename);
           System.out.println("成功录入~");
           AjaxResult ajax = AjaxResult.success();
           return ajax;
       }else if(filename.contains(".xlsx")||filename.contains(".csv")||filename.contains(".xls")){
           GetXlsx.excelFind(filename);
           System.out.println("成功录入~");
           AjaxResult ajax = AjaxResult.success();
           return ajax;
        }else{
           System.out.println("请注意格式~");
       }
        AjaxResult ajax = AjaxResult.error();
        return ajax;
    }

    @PostMapping("/mysql")
    @ResponseBody
    public AjaxResult GetMysql(@RequestBody Object o) throws IOException, SQLException {
        try {
            String s = o.toString();
//            System.out.println(s);
            s=s.replace("{","");
            s=s.replace("}","");
            String[] para = new String[5];
            String[] name=new String[5];
//            {"url", "username", "password", "source_table", "target_table"};
            para=s.split(",");
            for (int i = 0; i < 5; i++) {
                String[] split = para[i].split("=");
                name[i]=split[1];
            }
            String url =name[0];
            String username =name[1];
            String password =name[2];
            String source_table =name[3];
            String target_table =name[4];
            GetMysql.DataTransfer(url, username, password, source_table, target_table);
            AjaxResult ajax = AjaxResult.success();
            return ajax;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("录入失败:" + e.getMessage());
            AjaxResult ajax = AjaxResult.error();
            return ajax;
        }
    }

    @PostMapping("/hdfs")
    @ResponseBody
    public AjaxResult GetHdfs(@RequestBody Object o) {
        try {
            String s = o.toString();
            s=s.replace("{","");
            s=s.replace("}","");
            String[] para = new String[3];
            String[] name=new String[3];
//            {"url", "username", "password", "source_table", "target_table"};
            para=s.split(",");
            for (int i = 0; i < 3; i++) {
                String[] split = para[i].split("=");
                name[i]=split[1];
            }
            String hdfsInputFile =name[0];
            String localOutputFile =name[1];
            String uri =name[2];
            String hdfs = GetHDFS.getHdfs(hdfsInputFile, localOutputFile, uri);
            lrwj(hdfs);
            AjaxResult ajax = AjaxResult.success();
            return ajax;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("录入失败:" + e.getMessage());
            AjaxResult ajax = AjaxResult.error();
            return ajax;
        }
    }

    @PostMapping("/minio")
    @ResponseBody
    public AjaxResult GetMinio(@RequestBody Object o) {
        try {
            String s = o.toString();
            s=s.replace("{","");
            s=s.replace("}","");
            String[] para = new String[6];
            String[] name=new String[6];
//            {"url", "username", "password", "source_table", "target_table"};
            para=s.split(",");
            for (int i = 0; i < 6; i++) {
                String[] split = para[i].split("=");
                name[i]=split[1];
            }
            String endpoint =name[0];
            String access_key =name[1];
            String secret_key =name[2];
            String bucket_name =name[3];
            String object_name =name[4];
            String filepath =name[5];
            String minio = GetMinio.getMinio(endpoint, access_key, secret_key, bucket_name, object_name, filepath);
            lrwj(minio);
            AjaxResult ajax = AjaxResult.success();
            return ajax;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("录入失败:" + e.getMessage());
            AjaxResult ajax = AjaxResult.error();
            return ajax;
        }
    }

    public static void lrwj(String filename) throws IOException, SQLException {
        if(filename.contains(".txt")){
            GetTxt.txtToDB(filename);
            System.out.println("成功录入~");
        }else if(filename.contains(".xlsx")||filename.contains(".csv")||filename.contains(".xls")){
            GetXlsx.excelFind(filename);
            System.out.println("成功录入~");
        }else{
            System.out.println("请注意格式~");
        }
    }
}
