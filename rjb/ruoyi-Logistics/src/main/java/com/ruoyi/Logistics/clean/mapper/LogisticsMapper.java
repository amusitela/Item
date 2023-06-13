package com.ruoyi.Logistics.clean.mapper;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.Logistics;

/**
 * LogisticsMapper接口
 * 
 * @author lyw
 * @date 2023-06-13
 */
public interface LogisticsMapper 
{
    /**
     * 查询Logistics
     * 
     * @param tNum Logistics主键
     * @return Logistics
     */
    public Logistics selectLogisticsByTNum(String tNum);

    /**
     * 查询Logistics列表
     * 
     * @param logistics Logistics
     * @return Logistics集合
     */
    public List<Logistics> selectLogisticsList(Logistics logistics);

    /**
     * 新增Logistics
     * 
     * @param logistics Logistics
     * @return 结果
     */
    public int insertLogistics(Logistics logistics);

    /**
     * 修改Logistics
     * 
     * @param logistics Logistics
     * @return 结果
     */
    public int updateLogistics(Logistics logistics);

    /**
     * 删除Logistics
     * 
     * @param tNum Logistics主键
     * @return 结果
     */
    public int deleteLogisticsByTNum(String tNum);

    /**
     * 批量删除Logistics
     * 
     * @param tNums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLogisticsByTNums(String[] tNums);

    public List<String> findNotIn();
}
