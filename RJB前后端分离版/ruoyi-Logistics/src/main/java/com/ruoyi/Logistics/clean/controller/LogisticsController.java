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
import com.ruoyi.Logistics.clean.domain.Logistics;
import com.ruoyi.Logistics.clean.service.ILogisticsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * LogisticsController
 * 
 * @author lyw
 * @date 2023-07-07
 */
@RestController
@RequestMapping("/clean/Logistics")
public class LogisticsController extends BaseController
{
    @Autowired
    private ILogisticsService logisticsService;

    /**
     * 查询清理Logistics列表
     */
    //@RequiresPermissions("clean:Logistics:list")
    @GetMapping("/logisticsclean")
    @ResponseBody
    public  TableDataInfo LogisticsClean()
    {
        List<Logistics> list = logisticsService.LogisticsClean();
        return getDataTable(list);
    }


    /**
     * 查询Logistics列表
     */
    @PreAuthorize("@ss.hasPermi('clean:Logistics:list')")
    @GetMapping("/list")
    public TableDataInfo list(Logistics logistics)
    {
        startPage();
        List<Logistics> list = logisticsService.selectLogisticsList(logistics);
        return getDataTable(list);
    }

    /**
     * 导出Logistics列表
     */
    @PreAuthorize("@ss.hasPermi('clean:Logistics:export')")
    @Log(title = "Logistics", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Logistics logistics)
    {
        List<Logistics> list = logisticsService.selectLogisticsList(logistics);
        ExcelUtil<Logistics> util = new ExcelUtil<Logistics>(Logistics.class);
        util.exportExcel(response, list, "Logistics数据");
    }

    /**
     * 获取Logistics详细信息
     */
    @PreAuthorize("@ss.hasPermi('clean:Logistics:query')")
    @GetMapping(value = "/{tNum}")
    public AjaxResult getInfo(@PathVariable("tNum") String tNum)
    {
        return success(logisticsService.selectLogisticsByTNum(tNum));
    }

    /**
     * 新增Logistics
     */
    @PreAuthorize("@ss.hasPermi('clean:Logistics:add')")
    @Log(title = "Logistics", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Logistics logistics)
    {
        return toAjax(logisticsService.insertLogistics(logistics));
    }

    /**
     * 修改Logistics
     */
    @PreAuthorize("@ss.hasPermi('clean:Logistics:edit')")
    @Log(title = "Logistics", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Logistics logistics)
    {
        return toAjax(logisticsService.updateLogistics(logistics));
    }

    /**
     * 删除Logistics
     */
    @PreAuthorize("@ss.hasPermi('clean:Logistics:remove')")
    @Log(title = "Logistics", businessType = BusinessType.DELETE)
	@DeleteMapping("/{tNums}")
    public AjaxResult remove(@PathVariable String tNums)
    {
        return toAjax(logisticsService.deleteLogisticsByTNums(tNums));
    }
}
