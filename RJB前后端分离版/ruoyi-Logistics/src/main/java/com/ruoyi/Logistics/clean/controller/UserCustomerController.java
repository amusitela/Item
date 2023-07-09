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
import com.ruoyi.Logistics.clean.domain.UserCustomer;
import com.ruoyi.Logistics.clean.service.IUserCustomerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userCustomerController
 * 
 * @author lyw
 * @date 2023-07-07
 */
@RestController
@RequestMapping("/clean/insertsCustomer")
public class UserCustomerController extends BaseController
{
    @Autowired
    private IUserCustomerService userCustomerService;

    /**
     * 查询获取TempCustomer正确数据的列表
     *获取过的数据将在temp表中删除
     */
    @GetMapping("/test")
    @ResponseBody
    public TableDataInfo GetCustomer()
    {
        List<UserCustomer> list = userCustomerService.GetCustomer();
        return getDataTable(list);
    }

    /**
     * 查询userCustomer列表
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsCustomer:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserCustomer userCustomer)
    {
        startPage();
        List<UserCustomer> list = userCustomerService.selectUserCustomerList(userCustomer);
        return getDataTable(list);
    }

    /**
     * 导出userCustomer列表
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsCustomer:export')")
    @Log(title = "userCustomer", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserCustomer userCustomer)
    {
        List<UserCustomer> list = userCustomerService.selectUserCustomerList(userCustomer);
        ExcelUtil<UserCustomer> util = new ExcelUtil<UserCustomer>(UserCustomer.class);
        util.exportExcel(response, list, "userCustomer数据");
    }

    /**
     * 获取userCustomer详细信息
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsCustomer:query')")
    @GetMapping(value = "/{num}")
    public AjaxResult getInfo(@PathVariable("num") String num)
    {
        return success(userCustomerService.selectUserCustomerByNum(num));
    }

    /**
     * 新增userCustomer
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsCustomer:add')")
    @Log(title = "userCustomer", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserCustomer userCustomer)
    {
        return toAjax(userCustomerService.insertUserCustomer(userCustomer));
    }

    /**
     * 修改userCustomer
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsCustomer:edit')")
    @Log(title = "userCustomer", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserCustomer userCustomer)
    {
        return toAjax(userCustomerService.updateUserCustomer(userCustomer));
    }

    /**
     * 删除userCustomer
     */
    @PreAuthorize("@ss.hasPermi('clean:insertsCustomer:remove')")
    @Log(title = "userCustomer", businessType = BusinessType.DELETE)
	@DeleteMapping("/{nums}")
    public AjaxResult remove(@PathVariable String nums)
    {
        return toAjax(userCustomerService.deleteUserCustomerByNums(nums));
    }
}
