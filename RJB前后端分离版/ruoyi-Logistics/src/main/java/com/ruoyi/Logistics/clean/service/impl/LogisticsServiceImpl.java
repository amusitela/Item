package com.ruoyi.Logistics.clean.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.Logistics.utils.SolveLogisticsErrorUtil;
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


    /**
     * 找到不存在客户表里的客户的信息
     */
    @Override
    public List<String> findNotIn() {
        return logisticsMapper.findNotIn();
    }


    /**
     * 查询Logistics列表
     */
    @Override
    public  List<Logistics> LogisticsClean()
    {
        //录入temp数据库数据
        List<Logistics> logisticses = logisticsMapper.selectLogisticsList(new Logistics());
        //查找物流信息数据库中有的客户，在客户信息数据库查不到的数据
        List<String> nums = logisticsMapper.findNotIn();
        //去重
        Map<String, Integer> logistcsmap = new HashMap<>();
        //List<Customer> customers = customerService.selectAllCustomer();

        int p = 0;
        // for (int i = 0; i < 5; i ++ ) System.out.println(logisticses.get(i));

        //工具类，规范身份信息
        SolveLogisticsErrorUtil solveLogisticsErrorUtil = new SolveLogisticsErrorUtil();

        Integer cnt = solveLogisticsErrorUtil.getCount(logisticses);
        List counts = solveLogisticsErrorUtil.solve(logisticses);

        Logistics logistics = null;
        for (int i = 0; i < cnt; i ++ ) {
            logistics = logisticses.get(i);
            //去重
            String s = logistics.gettNum() + logistics.getName();
            if (logistcsmap.get(s) == null) {
                logistcsmap.put(s, 1);
            }
            else {
                logistics.setError(1);
            }
            //
            if ((Integer)counts.get(i) == 1) logistics.setError((Integer) counts.get(i));
            System.out.println(logistics.getError());

            //查找物流信息数据库中有的客户，在客户信息数据库查不到的数据
            if (p < nums.size() && nums.get(p).equals(logistics.getNum())) {
                p ++;
                logistics.setError(2);
            }

            if(logistics.getError() == 1) logisticsMapper.updateLogistics(logistics);
            if(logistics.getError() == 2) logisticsMapper.updateLogistics(logistics);
        }
        return logisticsMapper.selectLogisticsList(new Logistics());
    }
}
