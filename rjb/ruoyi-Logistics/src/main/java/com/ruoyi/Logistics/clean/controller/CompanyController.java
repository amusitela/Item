package com.ruoyi.Logistics.clean.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.Logistics.clean.domain.Company;
import com.ruoyi.Logistics.clean.service.ICompanyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * companyController
 * 
 * @author lyw
 * @date 2023-06-13
 */
@Controller
@RequestMapping("/clean/company")
public class CompanyController extends BaseController
{
    private String prefix = "clean/company";

    @Autowired
    private ICompanyService companyService;

    /**
     *清洗Company的重复数据
     *
     * */
    @GetMapping("/cleancompany")
    @ResponseBody
    public List<Company> cleanCompany(){

        //录入temp数据库的内容
        List<Company> companies = companyService.selectCompanyList(new Company());
        //用于去重使用，利用了map自带的方法
        Map<String, Integer> companymapper = new HashMap<>();
        Company company = null;
        //控制台输出
        for (int i = 0; i < companies.size(); i ++ ) System.out.println(companies.get(i));
        //去重的具体思路
        for (int i = 0; i < companies.size(); i ++ ) {
            company = companies.get(i);
            System.out.println(company);
            if (companymapper.get(company.getCompanyName()) == null) {
                companymapper.put(company.getCompanyName(), 1);
            }
            else {
                company.setError(1);
            }
            System.out.println(company.getError());
            //更新标记异常数据
            if (company.getError() == 1) companyService.updateCompany(company);
        }

        return companyService.selectCompanyList(new Company());
    }

    @RequiresPermissions("clean:company:view")
    @GetMapping()
    public String company()
    {
        return prefix + "/company";
    }

    /**
     * 查询company列表
     */
    @RequiresPermissions("clean:company:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Company company)
    {
        startPage();
        List<Company> list = companyService.selectCompanyList(company);
        return getDataTable(list);
    }

    /**
     * 导出company列表
     */
    @RequiresPermissions("clean:company:export")
    @Log(title = "company", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Company company)
    {
        List<Company> list = companyService.selectCompanyList(company);
        ExcelUtil<Company> util = new ExcelUtil<Company>(Company.class);
        return util.exportExcel(list, "company数据");
    }

    /**
     * 新增company
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存company
     */
    @RequiresPermissions("clean:company:add")
    @Log(title = "company", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Company company)
    {
        return toAjax(companyService.insertCompany(company));
    }

    /**
     * 修改company
     */
    @RequiresPermissions("clean:company:edit")
    @GetMapping("/edit/{num}")
    public String edit(@PathVariable("num") Integer num, ModelMap mmap)
    {
        Company company = companyService.selectCompanyByNum(num);
        mmap.put("company", company);
        return prefix + "/edit";
    }

    /**
     * 修改保存company
     */
    @RequiresPermissions("clean:company:edit")
    @Log(title = "company", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Company company)
    {
        return toAjax(companyService.updateCompany(company));
    }

    /**
     * 删除company
     */
    @RequiresPermissions("clean:company:remove")
    @Log(title = "company", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(companyService.deleteCompanyByNums(ids));
    }
}
