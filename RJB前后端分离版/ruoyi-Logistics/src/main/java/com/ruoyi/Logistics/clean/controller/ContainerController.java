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
import com.ruoyi.Logistics.clean.domain.Container;
import com.ruoyi.Logistics.clean.service.IContainerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * ContainerController
 * 
 * @author lyw
 * @date 2023-07-07
 */
@RestController
@RequestMapping("/clean/Container")
public class ContainerController extends BaseController
{
    @Autowired
    private IContainerService containerService;

    /**
     * 清洗container数据
     * */
    @GetMapping("/cleancontainer")
    @ResponseBody
    public TableDataInfo cleanContainer()
    {
        List<Container> list = containerService.cleanContainer();
        return getDataTable(list);
    }

    /**
     * 查询Container列表
     */
    @PreAuthorize("@ss.hasPermi('clean:Container:list')")
    @GetMapping("/list")
    public TableDataInfo list(Container container)
    {
        startPage();
        List<Container> list = containerService.selectContainerList(container);
        return getDataTable(list);
    }

    /**
     * 导出Container列表
     */
    @PreAuthorize("@ss.hasPermi('clean:Container:export')")
    @Log(title = "Container", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Container container)
    {
        List<Container> list = containerService.selectContainerList(container);
        ExcelUtil<Container> util = new ExcelUtil<Container>(Container.class);
        util.exportExcel(response, list, "Container数据");
    }

    /**
     * 获取Container详细信息
     */
    @PreAuthorize("@ss.hasPermi('clean:Container:query')")
    @GetMapping(value = "/{num}")
    public AjaxResult getInfo(@PathVariable("num") Integer num)
    {
        return success(containerService.selectContainerByNum(num));
    }

    /**
     * 新增Container
     */
    @PreAuthorize("@ss.hasPermi('clean:Container:add')")
    @Log(title = "Container", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Container container)
    {
        return toAjax(containerService.insertContainer(container));
    }

    /**
     * 修改Container
     */
    @PreAuthorize("@ss.hasPermi('clean:Container:edit')")
    @Log(title = "Container", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Container container)
    {
        return toAjax(containerService.updateContainer(container));
    }

    /**
     * 删除Container
     */
    @PreAuthorize("@ss.hasPermi('clean:Container:remove')")
    @Log(title = "Container", businessType = BusinessType.DELETE)
	@DeleteMapping("/{nums}")
    public AjaxResult remove(@PathVariable String nums)
    {
        return toAjax(containerService.deleteContainerByNums(nums));
    }
}
