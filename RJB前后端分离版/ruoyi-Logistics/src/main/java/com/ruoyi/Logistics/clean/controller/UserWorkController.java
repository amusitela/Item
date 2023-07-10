package com.ruoyi.Logistics.clean.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.Logistics.clean.domain.UserWork;
import com.ruoyi.Logistics.clean.service.IUserWorkService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userWorkController
 * 
 * @author lyw
 * @date 2023-07-07
 */
@RestController
@RequestMapping("/clean/insertsWork")
public class UserWorkController extends BaseController
{
    @Autowired
    private IUserWorkService userWorkService;

    /**
     * 获取过的数据将在temp表中删除
     * 获取work的正确数据
     */

    @GetMapping("/insert")
    @ResponseBody
    public TableDataInfo GetWork()
    {
        List<UserWork> userWorks = userWorkService.GetWork();
        return getDataTable(userWorks);
    }

    /**
     * 查询userWork列表
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsWork:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserWork userWork)
    {
        startPage();
        List<UserWork> list = userWorkService.selectUserWorkList(userWork);
        return getDataTable(list);
    }

    /**
     * 导出userWork列表
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsWork:export')")
    @Log(title = "userWork", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserWork userWork)
    {
        List<UserWork> list = userWorkService.selectUserWorkList(userWork);
        ExcelUtil<UserWork> util = new ExcelUtil<UserWork>(UserWork.class);
        util.exportExcel(response, list, "userWork数据");
    }

    /**
     * 获取userWork详细信息
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsWork:query')")
    @GetMapping(value = "/{num}")
    public AjaxResult getInfo(@PathVariable("num") Integer num)
    {
        return success(userWorkService.selectUserWorkByNum(num));
    }

    /**
     * 新增userWork
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsWork:add')")
    @Log(title = "userWork", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserWork userWork)
    {
        return toAjax(userWorkService.insertUserWork(userWork));
    }

    /**
     * 修改userWork
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsWork:edit')")
    @Log(title = "userWork", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserWork userWork)
    {
        return toAjax(userWorkService.updateUserWork(userWork));
    }

    /**
     * 删除userWork
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsWork:remove')")
    @Log(title = "userWork", businessType = BusinessType.DELETE)
	@DeleteMapping("/{nums}")
    public AjaxResult remove(@PathVariable String nums)
    {
        return toAjax(userWorkService.deleteUserWorkByNums(nums));
    }
}
