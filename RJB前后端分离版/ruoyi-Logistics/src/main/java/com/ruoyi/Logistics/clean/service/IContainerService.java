package com.ruoyi.Logistics.clean.service;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.Container;

/**
 * ContainerService接口
 * 
 * @author lyw
 * @date 2023-06-13
 */
public interface IContainerService 
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
     * 批量删除Container
     * 
     * @param nums 需要删除的Container主键集合
     * @return 结果
     */
    public int deleteContainerByNums(String nums);

    /**
     * 删除Container信息
     * 
     * @param num Container主键
     * @return 结果
     */
    public int deleteContainerByNum(Integer num);


    /**
     * 清洗container数据
     * */
    public List<Container> cleanContainer();
}
