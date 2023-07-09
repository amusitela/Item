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
import com.ruoyi.system.domain.TranLoading;
import com.ruoyi.system.service.ITranLoadingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 装货表Controller
 * 
 * @author 111
 * @date 2023-07-06
 */
@RestController
@RequestMapping("/system/loading")
public class TranLoadingController extends BaseController
{
    @Autowired
    private ITranLoadingService tranLoadingService;

    /**
     * 查询装货表列表
     */
    @PreAuthorize("@ss.hasPermi('system:loading:list')")
    @GetMapping("/list")
    public TableDataInfo list(TranLoading tranLoading)
    {
        startPage();
        List<TranLoading> list = tranLoadingService.selectTranLoadingList(tranLoading);
        return getDataTable(list);
    }

    /**
     * 导出装货表列表
     */
    @PreAuthorize("@ss.hasPermi('system:loading:export')")
    @Log(title = "装货表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TranLoading tranLoading)
    {
        List<TranLoading> list = tranLoadingService.selectTranLoadingList(tranLoading);
        ExcelUtil<TranLoading> util = new ExcelUtil<TranLoading>(TranLoading.class);
        util.exportExcel(response, list, "装货表数据");
    }

    /**
     * 获取装货表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:loading:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tranLoadingService.selectTranLoadingById(id));
    }

    /**
     * 新增装货表
     */
    @PreAuthorize("@ss.hasPermi('system:loading:add')")
    @Log(title = "装货表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TranLoading tranLoading)
    {
        return toAjax(tranLoadingService.insertTranLoading(tranLoading));
    }

    /**
     * 修改装货表
     */
    @PreAuthorize("@ss.hasPermi('system:loading:edit')")
    @Log(title = "装货表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TranLoading tranLoading)
    {
        return toAjax(tranLoadingService.updateTranLoading(tranLoading));
    }

    /**
     * 删除装货表
     */
    @PreAuthorize("@ss.hasPermi('system:loading:remove')")
    @Log(title = "装货表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tranLoadingService.deleteTranLoadingByIds(ids));
    }
}
