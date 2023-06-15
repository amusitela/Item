package com.ruoyi.Logistics.clean.controller;

import java.util.List;
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
import com.ruoyi.Logistics.clean.domain.UserWork;
import com.ruoyi.Logistics.clean.service.IUserWorkService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * workController
 * 
 * @author lyw
 * @date 2023-06-14
 */
@Controller
@RequestMapping("/clean/inserts")
public class UserWorkController extends BaseController
{
    private String prefix = "clean/inserts";

    @Autowired
    private IUserWorkService userWorkService;

    @RequiresPermissions("clean:inserts:view")
    @GetMapping()
    public String inserts()
    {
        return prefix + "/inserts";
    }

    /**
     * 获取work列表
     */
    @GetMapping("/test")
    @ResponseBody
    public List<UserWork> GetWork()
    {
        List<UserWork> list = userWorkService.selectTempWorkList(new UserWork());
        for (UserWork user: list
             ) {
            int i = userWorkService.insertUserWork(user);
        }
        List<UserWork> userWorks = userWorkService.selectUserWorkList(new UserWork());
        return userWorks;
    }

    /**
     * 查询work列表
     */
    @RequiresPermissions("clean:inserts:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserWork userWork)
    {
        startPage();
        List<UserWork> list = userWorkService.selectUserWorkList(userWork);
        return getDataTable(list);
    }

    /**
     * 导出work列表
     */
    @RequiresPermissions("clean:inserts:export")
    @Log(title = "work", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserWork userWork)
    {
        List<UserWork> list = userWorkService.selectUserWorkList(userWork);
        ExcelUtil<UserWork> util = new ExcelUtil<UserWork>(UserWork.class);
        return util.exportExcel(list, "work数据");
    }

    /**
     * 新增work
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存work
     */
    @RequiresPermissions("clean:inserts:add")
    @Log(title = "work", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserWork userWork)
    {
        return toAjax(userWorkService.insertUserWork(userWork));
    }

    /**
     * 修改work
     */
    @RequiresPermissions("clean:inserts:edit")
    @GetMapping("/edit/{num}")
    public String edit(@PathVariable("num") Integer num, ModelMap mmap)
    {
        UserWork userWork = userWorkService.selectUserWorkByNum(num);
        mmap.put("userWork", userWork);
        return prefix + "/edit";
    }

    /**
     * 修改保存work
     */
    @RequiresPermissions("clean:inserts:edit")
    @Log(title = "work", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserWork userWork)
    {
        return toAjax(userWorkService.updateUserWork(userWork));
    }

    /**
     * 删除work
     */
    @RequiresPermissions("clean:inserts:remove")
    @Log(title = "work", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(userWorkService.deleteUserWorkByNums(ids));
    }
}
