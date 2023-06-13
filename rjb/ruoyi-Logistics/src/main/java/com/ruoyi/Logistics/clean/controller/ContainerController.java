package com.ruoyi.Logistics.clean.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.ruoyi.Logistics.clean.domain.Container;
import com.ruoyi.Logistics.clean.service.IContainerService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * ContainerController
 * 
 * @author lyw
 * @date 2023-06-13
 */
@Controller
@RequestMapping("/clean/Container")
public class ContainerController extends BaseController
{
    private String prefix = "clean/Container";

    @Autowired
    private IContainerService containerService;

    @RequiresPermissions("clean:Container:view")
    @GetMapping()
    public String Container()
    {
        return prefix + "/Container";
    }


    /**
     * 清洗container数据
     * */
    @GetMapping("/cleancontainer")
    @ResponseBody
    public List<Container> cleanContainer()
    {
        //录入temp数据库的数据
        List<Container> containers = containerService.selectContainerList(new Container());
        //用于去重使用，利用了map自带的方法
        Map<Integer, Integer> containermap = new HashMap<>();
        Container container = null;

        //控制台输出
        for (int i = 0; i < containers.size(); i ++ ) System.out.println(containers.get(i));

        //具体去重的方法
        for (int i = 0; i < containers.size(); i ++ ) {
            container = containers.get(i);
            System.out.println(container);
            if (containermap.get(container.getNum()) == null) {
                containermap.put(container.getNum(), 1);
            }
            else {
                container.setError(1);
            }
            //更新标记异常数据
            System.out.println(container.getError());
            if (container.getError() == 1) containerService.updateContainer(container);
        }
        return containerService.selectContainerList(new Container());
    }
    /**
     * 查询Container列表
     */
    @RequiresPermissions("clean:Container:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Container container)
    {
        startPage();
        List<Container> list = containerService.selectContainerList(container);
        return getDataTable(list);
    }

    /**
     * 导出Container列表
     */
    @RequiresPermissions("clean:Container:export")
    @Log(title = "Container", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Container container)
    {
        List<Container> list = containerService.selectContainerList(container);
        ExcelUtil<Container> util = new ExcelUtil<Container>(Container.class);
        return util.exportExcel(list, "Container数据");
    }

    /**
     * 新增Container
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存Container
     */
    @RequiresPermissions("clean:Container:add")
    @Log(title = "Container", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Container container)
    {
        return toAjax(containerService.insertContainer(container));
    }

    /**
     * 修改Container
     */
    @RequiresPermissions("clean:Container:edit")
    @GetMapping("/edit/{num}")
    public String edit(@PathVariable("num") Integer num, ModelMap mmap)
    {
        Container container = containerService.selectContainerByNum(num);
        mmap.put("container", container);
        return prefix + "/edit";
    }

    /**
     * 修改保存Container
     */
    @RequiresPermissions("clean:Container:edit")
    @Log(title = "Container", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Container container)
    {
        return toAjax(containerService.updateContainer(container));
    }

    /**
     * 删除Container
     */
    @RequiresPermissions("clean:Container:remove")
    @Log(title = "Container", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(containerService.deleteContainerByNums(ids));
    }
}
