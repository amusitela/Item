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
import com.ruoyi.Logistics.clean.domain.UserCompany;
import com.ruoyi.Logistics.clean.service.IUserCompanyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userCompanyController
 * 
 * @author lyw
 * @date 2023-07-07
 */
@RestController
@RequestMapping("/clean/insertCompany")
public class UserCompanyController extends BaseController
{
    @Autowired
    private IUserCompanyService userCompanyService;

    /**
     * 获取TempCompany正确的数据列表
     * 获取过的数据将在temp表中删除
     */
    @GetMapping("/insert")
    @ResponseBody
    public TableDataInfo getCompany()
    {
        List<UserCompany> list = userCompanyService.getCompany();
        return getDataTable(list);
    }

    /**
     * 查询userCompany列表
     */
    @PreAuthorize("@ss.hasPermi('clean:insertCompany:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserCompany userCompany)
    {
        startPage();
        List<UserCompany> list = userCompanyService.selectUserCompanyList(userCompany);
        return getDataTable(list);
    }

    /**
     * 导出userCompany列表
     */
    @PreAuthorize("@ss.hasPermi('clean:insertCompany:export')")
    @Log(title = "userCompany", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserCompany userCompany)
    {
        List<UserCompany> list = userCompanyService.selectUserCompanyList(userCompany);
        ExcelUtil<UserCompany> util = new ExcelUtil<UserCompany>(UserCompany.class);
        util.exportExcel(response, list, "userCompany数据");
    }

    /**
     * 获取userCompany详细信息
     */
    @PreAuthorize("@ss.hasPermi('clean:insertCompany:query')")
    @GetMapping(value = "/{companyNum}")
    public AjaxResult getInfo(@PathVariable("companyNum") Integer companyNum)
    {
        return success(userCompanyService.selectUserCompanyByCompanyNum(companyNum));
    }

    /**
     * 新增userCompany
     */
    @PreAuthorize("@ss.hasPermi('clean:insertCompany:add')")
    @Log(title = "userCompany", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserCompany userCompany)
    {
        return toAjax(userCompanyService.insertUserCompany(userCompany));
    }

    /**
     * 修改userCompany
     */
    @PreAuthorize("@ss.hasPermi('clean:insertCompany:edit')")
    @Log(title = "userCompany", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserCompany userCompany)
    {
        return toAjax(userCompanyService.updateUserCompany(userCompany));
    }

    /**
     * 删除userCompany
     */
    @PreAuthorize("@ss.hasPermi('clean:insertCompany:remove')")
    @Log(title = "userCompany", businessType = BusinessType.DELETE)
	@DeleteMapping("/{companyNums}")
    public AjaxResult remove(@PathVariable String companyNums)
    {
        return toAjax(userCompanyService.deleteUserCompanyByCompanyNums(companyNums));
    }
}
