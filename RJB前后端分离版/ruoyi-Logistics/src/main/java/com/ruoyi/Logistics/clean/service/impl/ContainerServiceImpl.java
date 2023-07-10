package com.ruoyi.Logistics.clean.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Logistics.clean.mapper.ContainerMapper;
import com.ruoyi.Logistics.clean.domain.Container;
import com.ruoyi.Logistics.clean.service.IContainerService;
import com.ruoyi.common.core.text.Convert;

/**
 * ContainerService业务层处理
 * 
 * @author lyw
 * @date 2023-06-13
 */
@Service
public class ContainerServiceImpl implements IContainerService 
{
    @Autowired
    private ContainerMapper containerMapper;

    /**
     * 查询Container
     * 
     * @param num Container主键
     * @return Container
     */
    @Override
    public Container selectContainerByNum(Integer num)
    {
        return containerMapper.selectContainerByNum(num);
    }

    /**
     * 查询Container列表
     * 
     * @param container Container
     * @return Container
     */
    @Override
    public List<Container> selectContainerList(Container container)
    {
        return containerMapper.selectContainerList(container);
    }

    /**
     * 新增Container
     * 
     * @param container Container
     * @return 结果
     */
    @Override
    public int insertContainer(Container container)
    {
        return containerMapper.insertContainer(container);
    }

    /**
     * 修改Container
     * 
     * @param container Container
     * @return 结果
     */
    @Override
    public int updateContainer(Container container)
    {
        return containerMapper.updateContainer(container);
    }

    /**
     * 批量删除Container
     * 
     * @param nums 需要删除的Container主键
     * @return 结果
     */
    @Override
    public int deleteContainerByNums(String nums)
    {
        return containerMapper.deleteContainerByNums(Convert.toStrArray(nums));
    }

    /**
     * 删除Container信息
     * 
     * @param num Container主键
     * @return 结果
     */
    @Override
    public int deleteContainerByNum(Integer num)
    {
        return containerMapper.deleteContainerByNum(num);
    }


    /**
     * 清洗container数据
     * */
    @Override
    public List<Container> cleanContainer()
    {
        //录入temp数据库的数据
        List<Container> containers = containerMapper.selectContainerList(new Container());
        //用于去重使用，利用了map自带的方法
        Map<Integer, Integer> containermap = new HashMap<>();
        Container container = null;

        //控制台输出
        //for (int i = 0; i < containers.size(); i ++ ) System.out.println(containers.get(i));

        //具体去重的方法
        for (int i = 0; i < containers.size(); i ++ ) {
            container = containers.get(i);
           // System.out.println(container);
            if (containermap.get(container.getNum()) == null) {
                containermap.put(container.getNum(), 1);
            }
            else {
                container.setError(1);
            }
            //更新标记异常数据
            //System.out.println(container.getError());
            if (container.getError() == 1) containerMapper.updateContainer(container);
        }
        return containerMapper.selectContainerList(new Container());
    }
}
