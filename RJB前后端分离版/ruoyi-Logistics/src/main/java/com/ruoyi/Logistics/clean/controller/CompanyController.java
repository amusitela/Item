package com.ruoyi.Logistics.clean.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Logistics.clean.domain.UserCompany;
import com.ruoyi.Logistics.clean.service.IUserCompanyService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.Logistics.clean.domain.Company;
import com.ruoyi.Logistics.clean.service.ICompanyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * companyController
 * 
 * @author lyw
 * @date 2023-07-07
 */
@RestController
@RequestMapping("/clean/company")
public class CompanyController extends BaseController
{
    @Autowired
    private ICompanyService companyService;

    @Autowired
    private IUserCompanyService userCompanyService;


    /**
     *清洗Company的重复数据
     *
     * */
    @GetMapping("/cleancompany")
    @ResponseBody
    public AjaxResult cleanCompany(){
        AjaxResult ajax = new AjaxResult();
        try {
            companyService.cleanCompany();
            userCompanyService.getCompany();
            ajax = AjaxResult.success();
            return ajax;
        } catch (Exception e) {
            e.printStackTrace();
            ajax= AjaxResult.error();
            return ajax;
        }

    }

    /**
     * 查询company列表
     */
    @PreAuthorize("@ss.hasPermi('clean:company:list')")
    @GetMapping("/list")
    public TableDataInfo list(Company company)
    {
        startPage();
        List<Company> list = companyService.selectCompanyList(company);
        return getDataTable(list);
    }

    /**
     * 导出company列表
     */
    @PreAuthorize("@ss.hasPermi('clean:company:export')")
    @Log(title = "company", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Company company)
    {
        List<Company> list = companyService.selectCompanyList(company);
        ExcelUtil<Company> util = new ExcelUtil<Company>(Company.class);
        util.exportExcel(response, list, "company数据");
    }

    /**
     * 获取company详细信息
     */
    @PreAuthorize("@ss.hasPermi('clean:company:query')")
    @GetMapping(value = "/{companyNum}")
    public AjaxResult getInfo(@PathVariable("companyNum") Integer companyNum)
    {
        return success(companyService.selectCompanyByCompanyNum(companyNum));
    }

    /**
     * 新增company
     */
    @PreAuthorize("@ss.hasPermi('clean:company:add')")
    @Log(title = "company", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Company company)
    {
        return toAjax(companyService.insertCompany(company));
    }

    /**
     * 修改company
     */
    @PreAuthorize("@ss.hasPermi('clean:company:edit')")
    @Log(title = "company", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Company company)
    {
        return toAjax(companyService.updateCompany(company));
    }

    /**
     * 删除company
     */
    @PreAuthorize("@ss.hasPermi('clean:company:remove')")
    @Log(title = "company", businessType = BusinessType.DELETE)
	@DeleteMapping("/{companyNums}")
    public AjaxResult remove(@PathVariable String companyNums)
    {
        return toAjax(companyService.deleteCompanyByCompanyNums(companyNums));
    }
}
