package com.ruoyi.Logistics.clean.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.Logistics.clean.domain.UserContainer;
import com.ruoyi.Logistics.clean.service.IUserContainerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userContainerController
 * 
 * @author lyw
 * @date 2023-06-14
 */
@Controller
@RequestMapping("/clean/insertContainer")
public class UserContainerController extends BaseController
{
    private String prefix = "clean/insertContainer";

    @Autowired
    private IUserContainerService userContainerService;

    @RequiresPermissions("clean:insertContainer:view")
    @GetMapping()
    public String insertContainer()
    {
        return prefix + "/insertContainer";
    }

    @GetMapping("/test")
    @ResponseBody
    public List<UserContainer> getContainer()
    {
        List<UserContainer> list = userContainerService.selectTempContainerList(new UserContainer());
        for (UserContainer user : list
             ) {
            int i = userContainerService.insertUserContainer(user);
        }
        List<UserContainer> userContainers = userContainerService.selectUserContainerList(new UserContainer());
        return userContainers;
    }

    /**
     * 查询userContainer列表
     */
    @RequiresPermissions("clean:insertContainer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserContainer userContainer)
    {
        startPage();
        List<UserContainer> list = userContainerService.selectUserContainerList(userContainer);
        return getDataTable(list);
    }

    /**
     * 导出userContainer列表
     */
    @RequiresPermissions("clean:insertContainer:export")
    @Log(title = "userContainer", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserContainer userContainer)
    {
        List<UserContainer> list = userContainerService.selectUserContainerList(userContainer);
        ExcelUtil<UserContainer> util = new ExcelUtil<UserContainer>(UserContainer.class);
        return util.exportExcel(list, "userContainer数据");
    }

    /**
     * 新增userContainer
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存userContainer
     */
    @RequiresPermissions("clean:insertContainer:add")
    @Log(title = "userContainer", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserContainer userContainer)
    {
        return toAjax(userContainerService.insertUserContainer(userContainer));
    }

    /**
     * 修改userContainer
     */
    @RequiresPermissions("clean:insertContainer:edit")
    @GetMapping("/edit/{num}")
    public String edit(@PathVariable("num") Integer num, ModelMap mmap)
    {
        UserContainer userContainer = userContainerService.selectUserContainerByNum(num);
        mmap.put("userContainer", userContainer);
        return prefix + "/edit";
    }

    /**
     * 修改保存userContainer
     */
    @RequiresPermissions("clean:insertContainer:edit")
    @Log(title = "userContainer", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserContainer userContainer)
    {
        return toAjax(userContainerService.updateUserContainer(userContainer));
    }

    /**
     * 删除userContainer
     */
    @RequiresPermissions("clean:insertContainer:remove")
    @Log(title = "userContainer", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userContainerService.deleteUserContainerByNums(ids));
    }
}
