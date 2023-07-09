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
import com.ruoyi.system.domain.TranUnload;
import com.ruoyi.system.service.ITranUnloadService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 卸货表Controller
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
@RestController
@RequestMapping("/system/unload")
public class TranUnloadController extends BaseController
{
    @Autowired
    private ITranUnloadService tranUnloadService;

    /**
     * 查询卸货表列表
     */
    @PreAuthorize("@ss.hasPermi('system:unload:list')")
    @GetMapping("/list")
    public TableDataInfo list(TranUnload tranUnload)
    {
        startPage();
        List<TranUnload> list = tranUnloadService.selectTranUnloadList(tranUnload);
        return getDataTable(list);
    }

    /**
     * 导出卸货表列表
     */
    @PreAuthorize("@ss.hasPermi('system:unload:export')")
    @Log(title = "卸货表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TranUnload tranUnload)
    {
        List<TranUnload> list = tranUnloadService.selectTranUnloadList(tranUnload);
        ExcelUtil<TranUnload> util = new ExcelUtil<TranUnload>(TranUnload.class);
        util.exportExcel(response, list, "卸货表数据");
    }

    /**
     * 获取卸货表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:unload:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tranUnloadService.selectTranUnloadById(id));
    }

    /**
     * 新增卸货表
     */
    @PreAuthorize("@ss.hasPermi('system:unload:add')")
    @Log(title = "卸货表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TranUnload tranUnload)
    {
        return toAjax(tranUnloadService.insertTranUnload(tranUnload));
    }

    /**
     * 修改卸货表
     */
    @PreAuthorize("@ss.hasPermi('system:unload:edit')")
    @Log(title = "卸货表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TranUnload tranUnload)
    {
        return toAjax(tranUnloadService.updateTranUnload(tranUnload));
    }

    /**
     * 删除卸货表
     */
    @PreAuthorize("@ss.hasPermi('system:unload:remove')")
    @Log(title = "卸货表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tranUnloadService.deleteTranUnloadByIds(ids));
    }
}
