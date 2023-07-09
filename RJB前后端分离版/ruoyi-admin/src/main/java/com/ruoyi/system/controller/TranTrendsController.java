package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TranTrends;
import com.ruoyi.system.service.ITranTrendsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 集装箱动态Controller
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
@RestController
@RequestMapping("/system/trends")
public class TranTrendsController extends BaseController
{
    @Autowired
    private ITranTrendsService tranTrendsService;

    /**
     * 查询集装箱动态列表
     */
    @PreAuthorize("@ss.hasPermi('system:trends:list')")
    @GetMapping("/list")
    public TableDataInfo list(TranTrends tranTrends)
    {
        startPage();
        List<TranTrends> list = tranTrendsService.selectTranTrendsList(tranTrends);
        return getDataTable(list);
    }

    /**
     * 导出集装箱动态列表
     */
    @PreAuthorize("@ss.hasPermi('system:trends:export')")
    @Log(title = "集装箱动态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TranTrends tranTrends)
    {
        List<TranTrends> list = tranTrendsService.selectTranTrendsList(tranTrends);
        ExcelUtil<TranTrends> util = new ExcelUtil<TranTrends>(TranTrends.class);
        util.exportExcel(response, list, "集装箱动态数据");
    }

    /**
     * 获取集装箱动态详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:trends:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tranTrendsService.selectTranTrendsById(id));
    }

    /**
     * 新增集装箱动态
     */
    @PreAuthorize("@ss.hasPermi('system:trends:add')")
    @Log(title = "集装箱动态", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TranTrends tranTrends)
    {
        return toAjax(tranTrendsService.insertTranTrends(tranTrends));
    }

    /**
     * 修改集装箱动态
     */
    @PreAuthorize("@ss.hasPermi('system:trends:edit')")
    @Log(title = "集装箱动态", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TranTrends tranTrends)
    {
        return toAjax(tranTrendsService.updateTranTrends(tranTrends));
    }

    /**
     * 删除集装箱动态
     */
    @PreAuthorize("@ss.hasPermi('system:trends:remove')")
    @Log(title = "集装箱动态", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tranTrendsService.deleteTranTrendsByIds(ids));
    }
}
