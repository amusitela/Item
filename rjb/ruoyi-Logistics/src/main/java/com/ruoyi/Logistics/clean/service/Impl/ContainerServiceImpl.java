package com.ruoyi.Logistics.clean.service.impl;

import java.util.List;
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
}
