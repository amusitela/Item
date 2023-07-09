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
import com.ruoyi.system.domain.TranInfo;
import com.ruoyi.system.service.ITranInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物流信息Controller
 * 
 * @author 111
 * @date 2023-07-06
 */
@RestController
@RequestMapping("/system/info")
public class TranInfoController extends BaseController
{
    @Autowired
    private ITranInfoService tranInfoService;

    /**
     * 查询物流信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(TranInfo tranInfo)
    {
        startPage();
        List<TranInfo> list = tranInfoService.selectTranInfoList(tranInfo);
        return getDataTable(list);
    }

    /**
     * 导出物流信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:info:export')")
    @Log(title = "物流信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TranInfo tranInfo)
    {
        List<TranInfo> list = tranInfoService.selectTranInfoList(tranInfo);
        ExcelUtil<TranInfo> util = new ExcelUtil<TranInfo>(TranInfo.class);
        util.exportExcel(response, list, "物流信息数据");
    }

    /**
     * 获取物流信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(tranInfoService.selectTranInfoById(id));
    }

    /**
     * 新增物流信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:add')")
    @Log(title = "物流信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TranInfo tranInfo)
    {
        return toAjax(tranInfoService.insertTranInfo(tranInfo));
    }

    /**
     * 修改物流信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:edit')")
    @Log(title = "物流信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TranInfo tranInfo)
    {
        return toAjax(tranInfoService.updateTranInfo(tranInfo));
    }

    /**
     * 删除物流信息
     */
    @PreAuthorize("@ss.hasPermi('system:info:remove')")
    @Log(title = "物流信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(tranInfoService.deleteTranInfoByIds(ids));
    }
}
