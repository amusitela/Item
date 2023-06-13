package com.ruoyi.Logistics.clean.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.Logistics.clean.domain.Work;
import com.ruoyi.Logistics.clean.service.IWorkService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * workController
 * 
 * @author lyw
 * @date 2023-06-13
 */
@Controller
@RequestMapping("/clean/work")
public class WorkController extends BaseController
{
    private String prefix = "clean/work";

    @Autowired
    private IWorkService workService;

    @RequiresPermissions("clean:work:view")
    @GetMapping()
    public String work()
    {
        return prefix + "/work";
    }


    /**
    * 清理重复数据
     *
    * */
    //@RequiresPermissions("clean:work:list")
    @GetMapping("/workclean")
    @ResponseBody
    public List<Work> workClean()
    {
//       Work work1 = new Work();
//       work1.setTnum("QPYT7971799");
//       work1.setStatus(0);
//       work1.setError(0);
//        workService.insertWork(work1);
        List<Work> works = workService.selectWorkList(new Work());
        Map<String, Integer> workmap = new HashMap<>();
        Work work = null;

        for (int i = 0; i < works.size(); i ++ ) System.out.println(works.get(i));

        for (int i = 0; i < works.size(); i ++ ) {
            work = works.get(i);
            //System.out.println(work);
            String wKey = work.getTnum()+work.getStatus().toString();
            if (workmap.get(wKey) == null) {
                workmap.put((wKey), 1);
            }
            else {
                work.setError(1);
            }
           // System.out.println(work.getError());
            if (work.getError() == 1) workService.updateWork(work);
        }
        return works;
    }



    /**
     * 查询work列表
     */
    @RequiresPermissions("clean:work:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Work work)
    {
        startPage();
        List<Work> list = workService.selectWorkList(work);
        return getDataTable(list);
    }

    /**
     * 导出work列表
     */
    @RequiresPermissions("clean:work:export")
    @Log(title = "work", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Work work)
    {
        List<Work> list = workService.selectWorkList(work);
        ExcelUtil<Work> util = new ExcelUtil<Work>(Work.class);
        return util.exportExcel(list, "work数据");
    }

    /**
     * 新增work
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存work
     */
    @RequiresPermissions("clean:work:add")
    @Log(title = "work", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Work work)
    {
        return toAjax(workService.insertWork(work));
    }

    /**
     * 修改work
     */
    @RequiresPermissions("clean:work:edit")
    @GetMapping("/edit/{no}")
    public String edit(@PathVariable("no") Long no, ModelMap mmap)
    {
        Work work = workService.selectWorkByNo(no);
        mmap.put("work", work);
        return prefix + "/edit";
    }

    /**
     * 修改保存work
     */
    @RequiresPermissions("clean:work:edit")
    @Log(title = "work", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Work work)
    {
        return toAjax(workService.updateWork(work));
    }

    /**
     * 删除work
     */
    @RequiresPermissions("clean:work:remove")
    @Log(title = "work", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(workService.deleteWorkByNos(ids));
    }
}
