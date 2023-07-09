package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TranLoadingMapper;
import com.ruoyi.system.domain.TranLoading;
import com.ruoyi.system.service.ITranLoadingService;

/**
 * 装货表Service业务层处理
 * 
 * @author 111
 * @date 2023-07-06
 */
@Service
public class TranLoadingServiceImpl implements ITranLoadingService 
{
    @Autowired
    private TranLoadingMapper tranLoadingMapper;

    /**
     * 查询装货表
     * 
     * @param id 装货表主键
     * @return 装货表
     */
    @Override
    public TranLoading selectTranLoadingById(Long id)
    {
        return tranLoadingMapper.selectTranLoadingById(id);
    }

    /**
     * 查询装货表列表
     * 
     * @param tranLoading 装货表
     * @return 装货表
     */
    @Override
    public List<TranLoading> selectTranLoadingList(TranLoading tranLoading)
    {
        return tranLoadingMapper.selectTranLoadingList(tranLoading);
    }

    /**
     * 新增装货表
     * 
     * @param tranLoading 装货表
     * @return 结果
     */
    @Override
    public int insertTranLoading(TranLoading tranLoading)
    {
        return tranLoadingMapper.insertTranLoading(tranLoading);
    }

    /**
     * 修改装货表
     * 
     * @param tranLoading 装货表
     * @return 结果
     */
    @Override
    public int updateTranLoading(TranLoading tranLoading)
    {
        return tranLoadingMapper.updateTranLoading(tranLoading);
    }

    /**
     * 批量删除装货表
     * 
     * @param ids 需要删除的装货表主键
     * @return 结果
     */
    @Override
    public int deleteTranLoadingByIds(Long[] ids)
    {
        return tranLoadingMapper.deleteTranLoadingByIds(ids);
    }

    /**
     * 删除装货表信息
     * 
     * @param id 装货表主键
     * @return 结果
     */
    @Override
    public int deleteTranLoadingById(Long id)
    {
        return tranLoadingMapper.deleteTranLoadingById(id);
    }
}
