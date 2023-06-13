package com.ruoyi.Logistics.clean.controller;

import java.util.List;

import com.ruoyi.Logistics.utils.SolveCustomerErrorUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.Logistics.clean.domain.Customer;
import com.ruoyi.Logistics.clean.service.ICustomerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * CustomerController
 * 
 * @author lyw
 * @date 2023-06-12
 */
@Controller
@RequestMapping("/clean/clean")
public class CustomerController extends BaseController
{
    private String prefix = "clean/clean";

    @Autowired
    private ICustomerService customerService;


    @GetMapping("/test")
    @ResponseBody
    public List<Customer> test()
    {
        //查询所有的用户
        List<Customer> customers = customerService.selectAllCustomer();

        for (int i = 0; i < 5; i ++ ) System.out.println(customers.get(i));

        //工具类，正则表达式判断数据是否异常
        SolveCustomerErrorUtil solveErrorUtil = new SolveCustomerErrorUtil();

        Integer cnt = solveErrorUtil.getCount(customers);
        List counts = solveErrorUtil.solve(customers);
        Customer customer = null;

        //检查异常数据，并修改标记为异常
        for (int i = 0; i < cnt; i ++ ) {
            customer = customers.get(i);
            customer.setError((Integer) counts.get(i));
            System.out.println(i);
            if(customer.getError() == 1) customerService.updateCustomer(customer);
        }

        customers = customerService.selectAllCustomer();

        for (int i = 0; i < 5; i ++ ) System.out.println(customers.get(i));

        return customers;

    }

    @RequiresPermissions("clean:clean:view")
    @GetMapping()
    public String clean()
    {
        return prefix + "/clean";
    }

    /**
     * 查询Customer列表
     */
    @RequiresPermissions("clean:clean:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Customer customer)
    {
        startPage();
        List<Customer> list = customerService.selectCustomerList(customer);
        return getDataTable(list);
    }

    /**
     * 导出Customer列表
     */
    @RequiresPermissions("clean:clean:export")
    @Log(title = "Customer", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Customer customer)
    {
        List<Customer> list = customerService.selectCustomerList(customer);
        ExcelUtil<Customer> util = new ExcelUtil<Customer>(Customer.class);
        return util.exportExcel(list, "Customer数据");
    }

    /**
     * 新增Customer
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存Customer
     */
    @RequiresPermissions("clean:clean:add")
    @Log(title = "Customer", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Customer customer)
    {
        return toAjax(customerService.insertCustomer(customer));
    }

    /**
     * 修改Customer
     */
    @RequiresPermissions("clean:clean:edit")
    @GetMapping("/edit/{num}")
    public String edit(@PathVariable("num") String num, ModelMap mmap)
    {
        Customer customer = customerService.selectCustomerByNum(num);
        mmap.put("customer", customer);
        return prefix + "/edit";
    }

    /**
     * 修改保存Customer
     */
    @RequiresPermissions("clean:clean:edit")
    @Log(title = "Customer", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Customer customer)
    {
        return toAjax(customerService.updateCustomer(customer));
    }

    /**
     * 删除Customer
     */
    @RequiresPermissions("clean:clean:remove")
    @Log(title = "Customer", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(customerService.deleteCustomerByNums(ids));
    }
}
