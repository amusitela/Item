package com.ruoyi.Logistics.clean.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.Logistics.clean.domain.UserLogistics;
import com.ruoyi.Logistics.clean.service.IUserLogisticsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userLogisticsController
 * 
 * @author lyw
 * @date 2023-06-14
 */
@Controller
@RequestMapping("/clean/insertLogistics")
public class UserLogisticsController extends BaseController
{
    private String prefix = "clean/insertLogistics";

    @Autowired
    private IUserLogisticsService userLogisticsService;

    @RequiresPermissions("clean:insertLogistics:view")
    @GetMapping()
    public String insertLogistics()
    {
        return prefix + "/insertLogistics";
    }

    /**
     * 查询获取Logistics正确数据
     */
    @GetMapping("/test")
    @ResponseBody
    public List<UserLogistics> GetLogistics()
    {
        List<UserLogistics> list = userLogisticsService.selectTempLogisticsList(new UserLogistics());
        for (UserLogistics user: list
             ) {
            int i = userLogisticsService.insertUserLogistics(user);
        }
        List<UserLogistics> userLogistics = userLogisticsService.selectUserLogisticsList(new UserLogistics());
        return userLogistics;
    }


    /**
     * 查询userLogistics列表
     */
    @RequiresPermissions("clean:insertLogistics:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserLogistics userLogistics)
    {
        startPage();
        List<UserLogistics> list = userLogisticsService.selectUserLogisticsList(userLogistics);
        return getDataTable(list);
    }

    /**
     * 导出userLogistics列表
     */
    @RequiresPermissions("clean:insertLogistics:export")
    @Log(title = "userLogistics", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserLogistics userLogistics)
    {
        List<UserLogistics> list = userLogisticsService.selectUserLogisticsList(userLogistics);
        ExcelUtil<UserLogistics> util = new ExcelUtil<UserLogistics>(UserLogistics.class);
        return util.exportExcel(list, "userLogistics数据");
    }

    /**
     * 新增userLogistics
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存userLogistics
     */
    @RequiresPermissions("clean:insertLogistics:add")
    @Log(title = "userLogistics", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserLogistics userLogistics)
    {
        return toAjax(userLogisticsService.insertUserLogistics(userLogistics));
    }

    /**
     * 修改userLogistics
     */
    @RequiresPermissions("clean:insertLogistics:edit")
    @GetMapping("/edit/{tNum}")
    public String edit(@PathVariable("tNum") String tNum, ModelMap mmap)
    {
        UserLogistics userLogistics = userLogisticsService.selectUserLogisticsByTNum(tNum);
        mmap.put("userLogistics", userLogistics);
        return prefix + "/edit";
    }

    /**
     * 修改保存userLogistics
     */
    @RequiresPermissions("clean:insertLogistics:edit")
    @Log(title = "userLogistics", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserLogistics userLogistics)
    {
        return toAjax(userLogisticsService.updateUserLogistics(userLogistics));
    }

    /**
     * 删除userLogistics
     */
    @RequiresPermissions("clean:insertLogistics:remove")
    @Log(title = "userLogistics", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userLogisticsService.deleteUserLogisticsByTNums(ids));
    }
}
