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
import com.ruoyi.system.domain.Kehu;
import com.ruoyi.system.service.IKehuService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 111Controller
 * 
 * @author ruoyi
 * @date 2023-06-13
 */
@RestController
@RequestMapping("/system/kehu")
public class KehuController extends BaseController
{
    @Autowired
    private IKehuService kehuService;

    /**
     * 查询111列表
     */
    @PreAuthorize("@ss.hasPermi('system:kehu:list')")
    @GetMapping("/list")
    public TableDataInfo list(Kehu kehu)
    {
        startPage();
        List<Kehu> list = kehuService.selectKehuList(kehu);
        return getDataTable(list);
    }

    /**
     * 导出111列表
     */
    @PreAuthorize("@ss.hasPermi('system:kehu:export')")
    @Log(title = "111", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Kehu kehu)
    {
        List<Kehu> list = kehuService.selectKehuList(kehu);
        ExcelUtil<Kehu> util = new ExcelUtil<Kehu>(Kehu.class);
        util.exportExcel(response, list, "111数据");
    }

    /**
     * 获取111详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:kehu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(kehuService.selectKehuById(id));
    }

    /**
     * 新增111
     */
    @PreAuthorize("@ss.hasPermi('system:kehu:add')")
    @Log(title = "111", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Kehu kehu)
    {
        return toAjax(kehuService.insertKehu(kehu));
    }

    /**
     * 修改111
     */
    @PreAuthorize("@ss.hasPermi('system:kehu:edit')")
    @Log(title = "111", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Kehu kehu)
    {
        return toAjax(kehuService.updateKehu(kehu));
    }

    /**
     * 删除111
     */
    @PreAuthorize("@ss.hasPermi('system:kehu:remove')")
    @Log(title = "111", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(kehuService.deleteKehuByIds(ids));
    }
}
