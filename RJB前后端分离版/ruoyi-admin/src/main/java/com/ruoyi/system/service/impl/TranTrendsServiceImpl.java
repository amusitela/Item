package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TranTrendsMapper;
import com.ruoyi.system.domain.TranTrends;
import com.ruoyi.system.service.ITranTrendsService;

/**
 * 集装箱动态Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
@Service
public class TranTrendsServiceImpl implements ITranTrendsService 
{
    @Autowired
    private TranTrendsMapper tranTrendsMapper;

    /**
     * 查询集装箱动态
     * 
     * @param id 集装箱动态主键
     * @return 集装箱动态
     */
    @Override
    public TranTrends selectTranTrendsById(Long id)
    {
        return tranTrendsMapper.selectTranTrendsById(id);
    }

    /**
     * 查询集装箱动态列表
     * 
     * @param tranTrends 集装箱动态
     * @return 集装箱动态
     */
    @Override
    public List<TranTrends> selectTranTrendsList(TranTrends tranTrends)
    {
        return tranTrendsMapper.selectTranTrendsList(tranTrends);
    }

    /**
     * 新增集装箱动态
     * 
     * @param tranTrends 集装箱动态
     * @return 结果
     */
    @Override
    public int insertTranTrends(TranTrends tranTrends)
    {
        return tranTrendsMapper.insertTranTrends(tranTrends);
    }

    /**
     * 修改集装箱动态
     * 
     * @param tranTrends 集装箱动态
     * @return 结果
     */
    @Override
    public int updateTranTrends(TranTrends tranTrends)
    {
        return tranTrendsMapper.updateTranTrends(tranTrends);
    }

    /**
     * 批量删除集装箱动态
     * 
     * @param ids 需要删除的集装箱动态主键
     * @return 结果
     */
    @Override
    public int deleteTranTrendsByIds(Long[] ids)
    {
        return tranTrendsMapper.deleteTranTrendsByIds(ids);
    }

    /**
     * 删除集装箱动态信息
     * 
     * @param id 集装箱动态主键
     * @return 结果
     */
    @Override
    public int deleteTranTrendsById(Long id)
    {
        return tranTrendsMapper.deleteTranTrendsById(id);
    }
}
