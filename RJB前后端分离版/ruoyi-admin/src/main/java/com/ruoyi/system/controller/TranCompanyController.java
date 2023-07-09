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
import com.ruoyi.system.domain.TranCompany;
import com.ruoyi.system.service.ITranCompanyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公司表Controller
 * 
 * @author 111
 * @date 2023-07-06
 */
@RestController
@RequestMapping("/system/company")
public class TranCompanyController extends BaseController
{
    @Autowired
    private ITranCompanyService tranCompanyService;

    /**
     * 查询公司表列表
     */
    @PreAuthorize("@ss.hasPermi('system:company:list')")
    @GetMapping("/list")
    public TableDataInfo list(TranCompany tranCompany)
    {
        startPage();
        List<TranCompany> list = tranCompanyService.selectTranCompanyList(tranCompany);
        return getDataTable(list);
    }

    /**
     * 导出公司表列表
     */
    @PreAuthorize("@ss.hasPermi('system:company:export')")
    @Log(title = "公司表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TranCompany tranCompany)
    {
        List<TranCompany> list = tranCompanyService.selectTranCompanyList(tranCompany);
        ExcelUtil<TranCompany> util = new ExcelUtil<TranCompany>(TranCompany.class);
        util.exportExcel(response, list, "公司表数据");
    }

    /**
     * 获取公司表详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:company:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(tranCompanyService.selectTranCompanyById(id));
    }

    /**
     * 新增公司表
     */
    @PreAuthorize("@ss.hasPermi('system:company:add')")
    @Log(title = "公司表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TranCompany tranCompany)
    {
        return toAjax(tranCompanyService.insertTranCompany(tranCompany));
    }

    /**
     * 修改公司表
     */
    @PreAuthorize("@ss.hasPermi('system:company:edit')")
    @Log(title = "公司表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TranCompany tranCompany)
    {
        return toAjax(tranCompanyService.updateTranCompany(tranCompany));
    }

    /**
     * 删除公司表
     */
    @PreAuthorize("@ss.hasPermi('system:company:remove')")
    @Log(title = "公司表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tranCompanyService.deleteTranCompanyByIds(ids));
    }
}
