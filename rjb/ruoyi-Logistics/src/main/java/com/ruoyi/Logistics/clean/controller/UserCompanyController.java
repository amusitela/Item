package com.ruoyi.Logistics.clean.controller;

import java.util.List;

import com.ruoyi.Logistics.clean.domain.Company;
import com.ruoyi.Logistics.clean.service.ICompanyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.checkerframework.checker.units.qual.A;
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
import com.ruoyi.Logistics.clean.domain.UserCompany;
import com.ruoyi.Logistics.clean.service.IUserCompanyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userCompanyController
 * 
 * @author lyw
 * @date 2023-06-17
 */
@Controller
@RequestMapping("/clean/insertCompany")
public class UserCompanyController extends BaseController
{
    private String prefix = "clean/insertCompany";

    @Autowired
    private IUserCompanyService userCompanyService;

    @Autowired
    private ICompanyService companyService;

    @RequiresPermissions("clean:insertCompany:view")
    @GetMapping()
    public String insertCompany()
    {
        return prefix + "/insertCompany";
    }

    /**
     * 获取TempCompany正确的数据列表
     * 获取过的数据将在temp表中删除
     */
    @GetMapping("/test")
    @ResponseBody
    public List<UserCompany> GetData()
    {
        List<UserCompany> userCompanies = userCompanyService.selectTempCompanyList(new UserCompany());
        for (UserCompany user:userCompanies
        ) {
            //插入时也需要考虑到去重
            if(userCompanyService.selectUserCompanyList(user) == null){
                int i = userCompanyService.insertUserCompany(user);
                int i1 = companyService.deleteCompanyByNum(user.getCompanyNum());
            }else{
                Company company = new Company();
                company.setNum(user.getCompanyNum());
                company.setCompanyName(user.getCompanyName());
                company.setCustomerName(user.getCustomerNum());
                company.setPersonName(user.getPersonName());
                company.setPhone(user.getPhone());
                company.setPhone(user.getPlace());
                company.setError(1);
                int i = companyService.updateCompany(company);
            }

        }
        List<UserCompany> ans = userCompanyService.selectUserCompanyList(new UserCompany());
        return ans;
    }



    /**
     * 查询userCompany列表
     */
    @RequiresPermissions("clean:insertCompany:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserCompany userCompany)
    {
        startPage();
        List<UserCompany> list = userCompanyService.selectUserCompanyList(userCompany);
        return getDataTable(list);
    }

    /**
     * 导出userCompany列表
     */
    @RequiresPermissions("clean:insertCompany:export")
    @Log(title = "userCompany", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserCompany userCompany)
    {
        List<UserCompany> list = userCompanyService.selectUserCompanyList(userCompany);
        ExcelUtil<UserCompany> util = new ExcelUtil<UserCompany>(UserCompany.class);
        return util.exportExcel(list, "userCompany数据");
    }

    /**
     * 新增userCompany
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存userCompany
     */
    @RequiresPermissions("clean:insertCompany:add")
    @Log(title = "userCompany", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserCompany userCompany)
    {
        return toAjax(userCompanyService.insertUserCompany(userCompany));
    }

    /**
     * 修改userCompany
     */
    @RequiresPermissions("clean:insertCompany:edit")
    @GetMapping("/edit/{companyNum}")
    public String edit(@PathVariable("companyNum") Integer companyNum, ModelMap mmap)
    {
        UserCompany userCompany = userCompanyService.selectUserCompanyByCompanyNum(companyNum);
        mmap.put("userCompany", userCompany);
        return prefix + "/edit";
    }

    /**
     * 修改保存userCompany
     */
    @RequiresPermissions("clean:insertCompany:edit")
    @Log(title = "userCompany", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserCompany userCompany)
    {
        return toAjax(userCompanyService.updateUserCompany(userCompany));
    }

    /**
     * 删除userCompany
     */
    @RequiresPermissions("clean:insertCompany:remove")
    @Log(title = "userCompany", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userCompanyService.deleteUserCompanyByCompanyNums(ids));
    }
}
