package com.ruoyi.Logistics.clean.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.Logistics.clean.service.IUserWorkService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.Logistics.clean.domain.Work;
import com.ruoyi.Logistics.clean.service.IWorkService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * workController
 * 
 * @author lyw
 * @date 2023-07-07
 */
@RestController
@RequestMapping("/clean/WORK")
public class WorkController extends BaseController
{
    @Autowired
    private IWorkService workService;

    @Autowired
    private IUserWorkService userWorkService;


    /**
     * 清理重复数据
     *
     * */
    @GetMapping("/workclean")
    @ResponseBody
    public AjaxResult workClean()
    {
        AjaxResult ajax = new AjaxResult();
        try {
            workService.workClean();
            userWorkService.GetWork();
            ajax = AjaxResult.success();
            return ajax;
        } catch (Exception e) {
            e.printStackTrace();
            ajax=AjaxResult.error();
            return ajax;
        }
    }

    /**
     * 查询work列表
     */
    @PreAuthorize("@ss.hasPermi('clean:WORK:list')")
    @GetMapping("/list")
    public TableDataInfo list(Work work)
    {
        startPage();
        List<Work> list = workService.selectWorkList(work);
        return getDataTable(list);
    }

    /**
     * 导出work列表
     */
    @PreAuthorize("@ss.hasPermi('clean:WORK:export')")
    @Log(title = "work", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Work work)
    {
        List<Work> list = workService.selectWorkList(work);
        ExcelUtil<Work> util = new ExcelUtil<Work>(Work.class);
        util.exportExcel(response, list, "work数据");
    }

    /**
     * 获取work详细信息
     */
    @PreAuthorize("@ss.hasPermi('clean:WORK:query')")
    @GetMapping(value = "/{num}")
    public AjaxResult getInfo(@PathVariable("num") Integer num)
    {
        return success(workService.selectWorkByNum(num));
    }

    /**
     * 新增work
     */
    @PreAuthorize("@ss.hasPermi('clean:WORK:add')")
    @Log(title = "work", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Work work)
    {
        return toAjax(workService.insertWork(work));
    }

    /**
     * 修改work
     */
    @PreAuthorize("@ss.hasPermi('clean:WORK:edit')")
    @Log(title = "work", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Work work)
    {
        return toAjax(workService.updateWork(work));
    }

    /**
     * 删除work
     */
    @PreAuthorize("@ss.hasPermi('clean:WORK:remove')")
    @Log(title = "work", businessType = BusinessType.DELETE)
	@DeleteMapping("/{nums}")
    public AjaxResult remove(@PathVariable String nums)
    {
        return toAjax(workService.deleteWorkByNums(nums));
    }
}
