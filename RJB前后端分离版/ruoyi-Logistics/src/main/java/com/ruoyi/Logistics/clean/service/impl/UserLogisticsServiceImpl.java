package com.ruoyi.Logistics.clean.service.impl;

import java.util.List;

import com.ruoyi.Logistics.clean.mapper.LogisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Logistics.clean.mapper.UserLogisticsMapper;
import com.ruoyi.Logistics.clean.domain.UserLogistics;
import com.ruoyi.Logistics.clean.service.IUserLogisticsService;
import com.ruoyi.common.core.text.Convert;

/**
 * userLogisticsService业务层处理
 * 
 * @author lyw
 * @date 2023-06-14
 */
@Service
public class UserLogisticsServiceImpl implements IUserLogisticsService 
{
    @Autowired
    private UserLogisticsMapper userLogisticsMapper;

    @Autowired
    private LogisticsMapper logisticsMapper;


    /**
     * 查询userLogistics
     * 
     * @param tNum userLogistics主键
     * @return userLogistics
     */
    @Override
    public UserLogistics selectUserLogisticsByTNum(String tNum)
    {
        return userLogisticsMapper.selectUserLogisticsByTNum(tNum);
    }

    /**
     * 查询userLogistics列表
     * 
     * @param userLogistics userLogistics
     * @return userLogistics
     */
    @Override
    public List<UserLogistics> selectUserLogisticsList(UserLogistics userLogistics)
    {
        return userLogisticsMapper.selectUserLogisticsList(userLogistics);
    }

    /**
     * 查询tempLogistics列表
     *
     * @param userLogistics userLogistics
     * @return userLogistics
     */
    @Override
    public List<UserLogistics> selectTempLogisticsList(UserLogistics userLogistics) {
        return userLogisticsMapper.selectTempLogisticsList(userLogistics);
    }

    /**
     * 新增userLogistics
     * 
     * @param userLogistics userLogistics
     * @return 结果
     */
    @Override
    public int insertUserLogistics(UserLogistics userLogistics)
    {
        return userLogisticsMapper.insertUserLogistics(userLogistics);
    }

    /**
     * 修改userLogistics
     * 
     * @param userLogistics userLogistics
     * @return 结果
     */
    @Override
    public int updateUserLogistics(UserLogistics userLogistics)
    {
        return userLogisticsMapper.updateUserLogistics(userLogistics);
    }

    /**
     * 批量删除userLogistics
     * 
     * @param tNums 需要删除的userLogistics主键
     * @return 结果
     */
    @Override
    public int deleteUserLogisticsByTNums(String tNums)
    {
        return userLogisticsMapper.deleteUserLogisticsByTNums(Convert.toStrArray(tNums));
    }

    /**
     * 删除userLogistics信息
     * 
     * @param tNum userLogistics主键
     * @return 结果
     */
    @Override
    public int deleteUserLogisticsByTNum(String tNum)
    {
        return userLogisticsMapper.deleteUserLogisticsByTNum(tNum);
    }

    /**
     * 查询获取Logistics正确数据
     * 获取过的数据将在temp表中删除
     */
    @Override
    public List<UserLogistics> GetLogistics()
    {
        List<UserLogistics> list = userLogisticsMapper.selectTempLogisticsList(new UserLogistics());
        for (UserLogistics user: list
        ) {
            int i = userLogisticsMapper.insertUserLogistics(user);
            int i1 = logisticsMapper.deleteLogisticsByTNum(user.gettNum());
        }
        List<UserLogistics> userLogistics = userLogisticsMapper.selectUserLogisticsList(new UserLogistics());
        return userLogistics;
    }
}
