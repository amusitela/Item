package  com.ruoyi.Logistics.clean.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import  com.ruoyi.Logistics.clean.domain.Customer;
import  com.ruoyi.Logistics.clean.service.ICustomerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * CustomerController
 * 
 * @author lyw
 * @date 2023-07-07
 */
@RestController
@RequestMapping("/clean/Customer")
public class CustomerController extends BaseController
{
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/test")
    @ResponseBody
    public TableDataInfo cleanCustomer()
    {
        List<Customer> list = customerService.cleanCustomer();
        return getDataTable(list);
    }

    /**
     * 查询Customer列表
     */
    @PreAuthorize("@ss.hasPermi('clean:Customer:list')")
    @GetMapping("/list")
    public TableDataInfo list(Customer customer)
    {
        startPage();
        List<Customer> list = customerService.selectCustomerList(customer);
        return getDataTable(list);
    }

    /**
     * 导出Customer列表
     */
    @PreAuthorize("@ss.hasPermi('clean:Customer:export')")
    @Log(title = "Customer", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Customer customer)
    {
        List<Customer> list = customerService.selectCustomerList(customer);
        ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
        util.exportExcel(response, list, "Customer数据");
    }

    /**
     * 获取Customer详细信息
     */
    @PreAuthorize("@ss.hasPermi('clean:Customer:query')")
    @GetMapping(value = "/{num}")
    public AjaxResult getInfo(@PathVariable("num") String num)
    {
        return success(customerService.selectCustomerByNum(num));
    }

    /**
     * 新增Customer
     */
    @PreAuthorize("@ss.hasPermi('clean:Customer:add')")
    @Log(title = "Customer", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Customer customer)
    {
        return toAjax(customerService.insertCustomer(customer));
    }

    /**
     * 修改Customer
     */
    @PreAuthorize("@ss.hasPermi('clean:Customer:edit')")
    @Log(title = "Customer", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Customer customer)
    {
        return toAjax(customerService.updateCustomer(customer));
    }

    /**
     * 删除Customer
     */
    @PreAuthorize("@ss.hasPermi('clean:Customer:remove')")
    @Log(title = "Customer", businessType = BusinessType.DELETE)
	@DeleteMapping("/{nums}")
    public AjaxResult remove(@PathVariable String nums)
    {
        return toAjax(customerService.deleteCustomerByNums(nums));
    }
}
