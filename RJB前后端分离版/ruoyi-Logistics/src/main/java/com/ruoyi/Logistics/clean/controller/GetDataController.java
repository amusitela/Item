package com.ruoyi.Logistics.clean.controller;

import com.ruoyi.Logistics.utils.getdata.GetHDFS;
import com.ruoyi.Logistics.utils.getdata.GetMysql;
import com.ruoyi.Logistics.utils.getdata.GetTxt;
import com.ruoyi.Logistics.utils.getdata.GetXlsx;
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

    @GetMapping("/mysql")
    @ResponseBody
    public AjaxResult GetMysql(String url,String username,String password,String source_table,String target_table) throws IOException, SQLException {
        try {
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

    @GetMapping("/hdfs")
    @ResponseBody
    public AjaxResult GetHdfs(String hdfsInputFile,String localOutputFile,String uri) {
        try {
            GetHDFS.getHdfs(hdfsInputFile, localOutputFile, uri);
            AjaxResult ajax = AjaxResult.success();
            return ajax;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("录入失败:" + e.getMessage());
            AjaxResult ajax = AjaxResult.error();
            return ajax;
        }
    }

}
