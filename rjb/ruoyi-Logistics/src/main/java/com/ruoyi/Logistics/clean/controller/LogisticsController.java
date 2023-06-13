package com.ruoyi.Logistics.clean.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.Logistics.clean.domain.Customer;
import com.ruoyi.Logistics.clean.service.ICustomerService;
import com.ruoyi.Logistics.utils.SolveLogisticsErrorUtil;
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
import com.ruoyi.Logistics.clean.domain.Logistics;
import com.ruoyi.Logistics.clean.service.ILogisticsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * LogisticsController
 * 
 * @author lyw
 * @date 2023-06-13
 */
@Controller
@RequestMapping("/clean/Logistics")
public class LogisticsController extends BaseController
{
    private String prefix = "clean/Logistics";

    @Autowired
    private ILogisticsService logisticsService;

//    @Autowired
//    private ICustomerService customerService;

    @RequiresPermissions("clean:Logistics:view")
    @GetMapping()
    public String Logistics()
    {
        return prefix + "/Logistics";
    }

    /**
     * 查询Logistics列表
     */
    //@RequiresPermissions("clean:Logistics:list")
    @GetMapping("/logisticsclean")
    @ResponseBody
    public  List<Logistics> LogisticsClean()
    {
        //录入temp数据库数据
        List<Logistics> logisticses = logisticsService.selectLogisticsList(new Logistics());
        //查找物流信息数据库中有的客户，在客户信息数据库查不到的数据
        List<String> nums = logisticsService.findNotIn();
        //去重
        Map<String, Integer> logistcsmap = new HashMap<>();
        //List<Customer> customers = customerService.selectAllCustomer();

        int p = 0;
        // for (int i = 0; i < 5; i ++ ) System.out.println(logisticses.get(i));

        //工具类，规范身份信息
        SolveLogisticsErrorUtil solveLogisticsErrorUtil = new SolveLogisticsErrorUtil();

        Integer cnt = solveLogisticsErrorUtil.getCount(logisticses);
        List counts = solveLogisticsErrorUtil.solve(logisticses);

        Logistics logistics = null;
        for (int i = 0; i < cnt; i ++ ) {
            logistics = logisticses.get(i);
            //去重
            if (logistcsmap.get(logistics.getNum()) == null) {
                logistcsmap.put(logistics.getNum(), 1);
            }
            else {
                logistics.setError(1);
            }
            //
            if ((Integer)counts.get(i) == 1) logistics.setError((Integer) counts.get(i));
            System.out.println(logistics.getError());

            //查找物流信息数据库中有的客户，在客户信息数据库查不到的数据
            if (p < nums.size() && nums.get(p).equals(logistics.getNum())) {
                p ++;
                logistics.setError(2);
            }

            if(logistics.getError() == 1) logisticsService.updateLogistics(logistics);
        }
        return logisticsService.selectLogisticsList(new Logistics());
    }


    /**
     * 查询Logistics列表
     */
    @RequiresPermissions("clean:Logistics:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Logistics logistics)
    {
        startPage();
        List<Logistics> list = logisticsService.selectLogisticsList(logistics);
        return getDataTable(list);
    }

    /**
     * 导出Logistics列表
     */
    @RequiresPermissions("clean:Logistics:export")
    @Log(title = "Logistics", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Logistics logistics)
    {
        List<Logistics> list = logisticsService.selectLogisticsList(logistics);
        ExcelUtil<Logistics> util = new ExcelUtil<Logistics>(Logistics.class);
        return util.exportExcel(list, "Logistics数据");
    }

    /**
     * 新增Logistics
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存Logistics
     */
    @RequiresPermissions("clean:Logistics:add")
    @Log(title = "Logistics", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Logistics logistics)
    {
        return toAjax(logisticsService.insertLogistics(logistics));
    }

    /**
     * 修改Logistics
     */
    @RequiresPermissions("clean:Logistics:edit")
    @GetMapping("/edit/{tNum}")
    public String edit(@PathVariable("tNum") String tNum, ModelMap mmap)
    {
        Logistics logistics = logisticsService.selectLogisticsByTNum(tNum);
        mmap.put("logistics", logistics);
        return prefix + "/edit";
    }

    /**
     * 修改保存Logistics
     */
    @RequiresPermissions("clean:Logistics:edit")
    @Log(title = "Logistics", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Logistics logistics)
    {
        return toAjax(logisticsService.updateLogistics(logistics));
    }

    /**
     * 删除Logistics
     */
    @RequiresPermissions("clean:Logistics:remove")
    @Log(title = "Logistics", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(logisticsService.deleteLogisticsByTNums(ids));
    }
}
