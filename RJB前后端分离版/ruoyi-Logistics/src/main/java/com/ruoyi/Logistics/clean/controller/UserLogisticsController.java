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
import com.ruoyi.Logistics.clean.domain.UserLogistics;
import com.ruoyi.Logistics.clean.service.IUserLogisticsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userLogisticsController
 * 
 * @author lyw
 * @date 2023-07-07
 */
@RestController
@RequestMapping("/clean/insertLogistics")
public class UserLogisticsController extends BaseController
{
    @Autowired
    private IUserLogisticsService userLogisticsService;

    /**
     * 查询获取Logistics正确数据
     * 获取过的数据将在temp表中删除
     */
    @GetMapping("/insert")
    @ResponseBody
    public TableDataInfo GetLogistics()
    {
        List<UserLogistics> list = userLogisticsService.GetLogistics();
        return getDataTable(list);
    }

    /**
     * 查询userLogistics列表
     */
    @PreAuthorize("@ss.hasPermi('clean:insertLogistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserLogistics userLogistics)
    {
        startPage();
        List<UserLogistics> list = userLogisticsService.selectUserLogisticsList(userLogistics);
        return getDataTable(list);
    }

    /**
     * 导出userLogistics列表
     */
    @PreAuthorize("@ss.hasPermi('clean:insertLogistics:export')")
    @Log(title = "userLogistics", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserLogistics userLogistics)
    {
        List<UserLogistics> list = userLogisticsService.selectUserLogisticsList(userLogistics);
        ExcelUtil<UserLogistics> util = new ExcelUtil<UserLogistics>(UserLogistics.class);
        util.exportExcel(response, list, "userLogistics数据");
    }

    /**
     * 获取userLogistics详细信息
     */
    @PreAuthorize("@ss.hasPermi('clean:insertLogistics:query')")
    @GetMapping(value = "/{tNum}")
    public AjaxResult getInfo(@PathVariable("tNum") String tNum)
    {
        return success(userLogisticsService.selectUserLogisticsByTNum(tNum));
    }

    /**
     * 新增userLogistics
     */
    @PreAuthorize("@ss.hasPermi('clean:insertLogistics:add')")
    @Log(title = "userLogistics", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserLogistics userLogistics)
    {
        return toAjax(userLogisticsService.insertUserLogistics(userLogistics));
    }

    /**
     * 修改userLogistics
     */
    @PreAuthorize("@ss.hasPermi('clean:insertLogistics:edit')")
    @Log(title = "userLogistics", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserLogistics userLogistics)
    {
        return toAjax(userLogisticsService.updateUserLogistics(userLogistics));
    }

    /**
     * 删除userLogistics
     */
    @PreAuthorize("@ss.hasPermi('clean:insertLogistics:remove')")
    @Log(title = "userLogistics", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tNums}")
    public AjaxResult remove(@PathVariable String tNums)
    {
        return toAjax(userLogisticsService.deleteUserLogisticsByTNums(tNums));
    }
}
