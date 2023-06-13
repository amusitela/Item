package com.ruoyi.Logistics.clean.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Logistics.clean.mapper.LogisticsMapper;
import com.ruoyi.Logistics.clean.domain.Logistics;
import com.ruoyi.Logistics.clean.service.ILogisticsService;
import com.ruoyi.common.core.text.Convert;

/**
 * LogisticsService业务层处理
 * 
 * @author lyw
 * @date 2023-06-13
 */
@Service
public class LogisticsServiceImpl implements ILogisticsService 
{
    @Autowired
    private LogisticsMapper logisticsMapper;

    /**
     * 查询Logistics
     * 
     * @param tNum Logistics主键
     * @return Logistics
     */
    @Override
    public Logistics selectLogisticsByTNum(String tNum)
    {
        return logisticsMapper.selectLogisticsByTNum(tNum);
    }

    /**
     * 查询Logistics列表
     * 
     * @param logistics Logistics
     * @return Logistics
     */
    @Override
    public List<Logistics> selectLogisticsList(Logistics logistics)
    {
        return logisticsMapper.selectLogisticsList(logistics);
    }

    /**
     * 新增Logistics
     * 
     * @param logistics Logistics
     * @return 结果
     */
    @Override
    public int insertLogistics(Logistics logistics)
    {
        return logisticsMapper.insertLogistics(logistics);
    }

    /**
     * 修改Logistics
     * 
     * @param logistics Logistics
     * @return 结果
     */
    @Override
    public int updateLogistics(Logistics logistics)
    {
        return logisticsMapper.updateLogistics(logistics);
    }

    /**
     * 批量删除Logistics
     * 
     * @param tNums 需要删除的Logistics主键
     * @return 结果
     */
    @Override
    public int deleteLogisticsByTNums(String tNums)
    {
        return logisticsMapper.deleteLogisticsByTNums(Convert.toStrArray(tNums));
    }

    /**
     * 删除Logistics信息
     * 
     * @param tNum Logistics主键
     * @return 结果
     */
    @Override
    public int deleteLogisticsByTNum(String tNum)
    {
        return logisticsMapper.deleteLogisticsByTNum(tNum);
    }

    @Override
    public List<String> findNotIn() {
        return logisticsMapper.findNotIn();
    }
}
