package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TranLoading;

/**
 * 装货表Service接口
 * 
 * @author 111
 * @date 2023-07-06
 */
public interface ITranLoadingService 
{
    /**
     * 查询装货表
     * 
     * @param id 装货表主键
     * @return 装货表
     */
    public TranLoading selectTranLoadingById(Long id);

    /**
     * 查询装货表列表
     * 
     * @param tranLoading 装货表
     * @return 装货表集合
     */
    public List<TranLoading> selectTranLoadingList(TranLoading tranLoading);

    /**
     * 新增装货表
     * 
     * @param tranLoading 装货表
     * @return 结果
     */
    public int insertTranLoading(TranLoading tranLoading);

    /**
     * 修改装货表
     * 
     * @param tranLoading 装货表
     * @return 结果
     */
    public int updateTranLoading(TranLoading tranLoading);

    /**
     * 批量删除装货表
     * 
     * @param ids 需要删除的装货表主键集合
     * @return 结果
     */
    public int deleteTranLoadingByIds(Long[] ids);

    /**
     * 删除装货表信息
     * 
     * @param id 装货表主键
     * @return 结果
     */
    public int deleteTranLoadingById(Long id);
}
