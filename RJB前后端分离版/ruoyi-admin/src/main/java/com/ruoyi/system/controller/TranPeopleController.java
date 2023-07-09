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
import com.ruoyi.system.domain.TranPeople;
import com.ruoyi.system.service.ITranPeopleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 111Controller
 * 
 * @author ruoyi
 * @date 2023-06-14
 */
@RestController
@RequestMapping("/system/people")
public class TranPeopleController extends BaseController
{
    @Autowired
    private ITranPeopleService tranPeopleService;

    /**
     * 查询111列表
     */
    @PreAuthorize("@ss.hasPermi('system:people:list')")
    @GetMapping("/list")
    public TableDataInfo list(TranPeople tranPeople)
    {
        startPage();
        List<TranPeople> list = tranPeopleService.selectTranPeopleList(tranPeople);
        return getDataTable(list);
    }

    /**
     * 导出111列表
     */
    @PreAuthorize("@ss.hasPermi('system:people:export')")
    @Log(title = "111", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TranPeople tranPeople)
    {
        List<TranPeople> list = tranPeopleService.selectTranPeopleList(tranPeople);
        ExcelUtil<TranPeople> util = new ExcelUtil<TranPeople>(TranPeople.class);
        util.exportExcel(response, list, "111数据");
    }

    /**
     * 获取111详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:people:query')")
    @GetMapping(value = "/{kehuid}")
    public AjaxResult getInfo(@PathVariable("kehuid") String kehuid)
    {
        return success(tranPeopleService.selectTranPeopleByKehuid(kehuid));
    }

    /**
     * 新增111
     */
    @PreAuthorize("@ss.hasPermi('system:people:add')")
    @Log(title = "111", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TranPeople tranPeople)
    {
        return toAjax(tranPeopleService.insertTranPeople(tranPeople));
    }

    /**
     * 修改111
     */
    @PreAuthorize("@ss.hasPermi('system:people:edit')")
    @Log(title = "111", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TranPeople tranPeople)
    {
        return toAjax(tranPeopleService.updateTranPeople(tranPeople));
    }

    /**
     * 删除111
     */
    @PreAuthorize("@ss.hasPermi('system:people:remove')")
    @Log(title = "111", businessType = BusinessType.DELETE)
	@DeleteMapping("/{kehuids}")
    public AjaxResult remove(@PathVariable String[] kehuids)
    {
        return toAjax(tranPeopleService.deleteTranPeopleByKehuids(kehuids));
    }
}
