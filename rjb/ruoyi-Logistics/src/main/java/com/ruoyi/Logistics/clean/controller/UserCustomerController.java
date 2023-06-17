package com.ruoyi.Logistics.clean.controller;

import java.util.List;

import com.ruoyi.Logistics.clean.domain.UserLogistics;
import com.ruoyi.Logistics.clean.service.ICustomerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.Logistics.clean.domain.UserCustomer;
import com.ruoyi.Logistics.clean.service.IUserCustomerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userCustomerController
 * 
 * @author lyw
 * @date 2023-06-14
 */
@Controller
@RequestMapping("/clean/insertsCustomer")
public class UserCustomerController extends BaseController
{
    private String prefix = "clean/insertsCustomer";

    @Autowired
    private IUserCustomerService userCustomerService;

    @Autowired
    private ICustomerService customerService;

    @RequiresPermissions("clean:insertsCustomer:view")
    @GetMapping()
    public String insertsCustomer()
    {
        return prefix + "/insertsCustomer";
    }

    /**
     * 查询userCustomer列表
     */
    @RequiresPermissions("clean:insertsCustomer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserCustomer userCustomer)
    {
        startPage();
        List<UserCustomer> list = userCustomerService.selectUserCustomerList(userCustomer);
        return getDataTable(list);
    }


    /**
     * 查询获取TempCustomer正确数据的列表
     *获取过的数据将在temp表中删除
     */
    @GetMapping("/test")
    @ResponseBody
    public List<UserCustomer> GetCustomer()
    {
        List<UserCustomer> list = userCustomerService.selectTempCustomerList(new UserCustomer());
        for (UserCustomer user: list
             ) {
            int i = userCustomerService.insertUserCustomer(user);
            int i1 = customerService.deleteCustomerByNum(user.getNum());
        }
        List<UserCustomer> userCustomers = userCustomerService.selectUserCustomerList(new UserCustomer());
        return userCustomers;
    }

    /**
     * 导出userCustomer列表
     */
    @RequiresPermissions("clean:insertsCustomer:export")
    @Log(title = "userCustomer", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserCustomer userCustomer)
    {
        List<UserCustomer> list = userCustomerService.selectUserCustomerList(userCustomer);
        ExcelUtil<UserCustomer> util = new ExcelUtil<UserCustomer>(UserCustomer.class);
        return util.exportExcel(list, "userCustomer数据");
    }

    /**
     * 新增userCustomer
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存userCustomer
     */
    @RequiresPermissions("clean:insertsCustomer:add")
    @Log(title = "userCustomer", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserCustomer userCustomer)
    {
        return toAjax(userCustomerService.insertUserCustomer(userCustomer));
    }

    /**
     * 修改userCustomer
     */
    @RequiresPermissions("clean:insertsCustomer:edit")
    @GetMapping("/edit/{num}")
    public String edit(@PathVariable("num") String num, ModelMap mmap)
    {
        UserCustomer userCustomer = userCustomerService.selectUserCustomerByNum(num);
        mmap.put("userCustomer", userCustomer);
        return prefix + "/edit";
    }

    /**
     * 修改保存userCustomer
     */
    @RequiresPermissions("clean:insertsCustomer:edit")
    @Log(title = "userCustomer", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserCustomer userCustomer)
    {
        return toAjax(userCustomerService.updateUserCustomer(userCustomer));
    }

    /**
     * 删除userCustomer
     */
    @RequiresPermissions("clean:insertsCustomer:remove")
    @Log(title = "userCustomer", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userCustomerService.deleteUserCustomerByNums(ids));
    }
}
