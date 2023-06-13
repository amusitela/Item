package com.ruoyi.Logistics.clean.mapper;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.Container;

/**
 * ContainerMapper接口
 * 
 * @author lyw
 * @date 2023-06-13
 */
public interface ContainerMapper 
{
    /**
     * 查询Container
     * 
     * @param num Container主键
     * @return Container
     */
    public Container selectContainerByNum(Integer num);

    /**
     * 查询Container列表
     * 
     * @param container Container
     * @return Container集合
     */
    public List<Container> selectContainerList(Container container);

    /**
     * 新增Container
     * 
     * @param container Container
     * @return 结果
     */
    public int insertContainer(Container container);

    /**
     * 修改Container
     * 
     * @param container Container
     * @return 结果
     */
    public int updateContainer(Container container);

    /**
     * 删除Container
     * 
     * @param num Container主键
     * @return 结果
     */
    public int deleteContainerByNum(Integer num);

    /**
     * 批量删除Container
     * 
     * @param nums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteContainerByNums(String[] nums);
}
