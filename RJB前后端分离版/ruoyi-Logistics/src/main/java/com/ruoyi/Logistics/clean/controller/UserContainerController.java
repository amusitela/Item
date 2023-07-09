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
import com.ruoyi.Logistics.clean.domain.UserContainer;
import com.ruoyi.Logistics.clean.service.IUserContainerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userContainerController
 * 
 * @author lyw
 * @date 2023-07-07
 */
@RestController
@RequestMapping("/clean/insertContainer")
public class UserContainerController extends BaseController
{
    @Autowired
    private IUserContainerService userContainerService;

    /**
     * 查询TempContainer正确的数据列表
     * 获取过的数据将在temp表中删除
     */
    @GetMapping("/test")
    @ResponseBody
    public TableDataInfo getContainer()
    {
        List<UserContainer> list = userContainerService.getContainer();
        return getDataTable(list);
    }

    /**
     * 查询userContainer列表
     */
    @PreAuthorize("@ss.hasPermi('clean:insertContainer:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserContainer userContainer)
    {
        startPage();
        List<UserContainer> list = userContainerService.selectUserContainerList(userContainer);
        return getDataTable(list);
    }

    /**
     * 导出userContainer列表
     */
    @PreAuthorize("@ss.hasPermi('clean:insertContainer:export')")
    @Log(title = "userContainer", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserContainer userContainer)
    {
        List<UserContainer> list = userContainerService.selectUserContainerList(userContainer);
        ExcelUtil<UserContainer> util = new ExcelUtil<UserContainer>(UserContainer.class);
        util.exportExcel(response, list, "userContainer数据");
    }

    /**
     * 获取userContainer详细信息
     */
    @PreAuthorize("@ss.hasPermi('clean:insertContainer:query')")
    @GetMapping(value = "/{num}")
    public AjaxResult getInfo(@PathVariable("num") Integer num)
    {
        return success(userContainerService.selectUserContainerByNum(num));
    }

    /**
     * 新增userContainer
     */
    @PreAuthorize("@ss.hasPermi('clean:insertContainer:add')")
    @Log(title = "userContainer", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserContainer userContainer)
    {
        return toAjax(userContainerService.insertUserContainer(userContainer));
    }

    /**
     * 修改userContainer
     */
    @PreAuthorize("@ss.hasPermi('clean:insertContainer:edit')")
    @Log(title = "userContainer", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserContainer userContainer)
    {
        return toAjax(userContainerService.updateUserContainer(userContainer));
    }

    /**
     * 删除userContainer
     */
    @PreAuthorize("@ss.hasPermi('clean:insertContainer:remove')")
    @Log(title = "userContainer", businessType = BusinessType.DELETE)
	@DeleteMapping("/{nums}")
    public AjaxResult remove(@PathVariable String nums)
    {
        return toAjax(userContainerService.deleteUserContainerByNums(nums));
    }
}
