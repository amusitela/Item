package com.ruoyi.Logistics.clean.service;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.UserLogistics;

/**
 * userLogisticsService接口
 * 
 * @author lyw
 * @date 2023-06-14
 */
public interface IUserLogisticsService 
{
    /**
     * 查询userLogistics
     * 
     * @param tNum userLogistics主键
     * @return userLogistics
     */
    public UserLogistics selectUserLogisticsByTNum(String tNum);

    /**
     * 查询userLogistics列表
     * 
     * @param userLogistics userLogistics
     * @return userLogistics集合
     */
    public List<UserLogistics> selectUserLogisticsList(UserLogistics userLogistics);

    /**
     * 查询tempLogistics列表
     *
     * @param userLogistics userLogistics
     * @return userLogistics集合
     */
    public List<UserLogistics> selectTempLogisticsList(UserLogistics userLogistics);

    /**
     * 新增userLogistics
     * 
     * @param userLogistics userLogistics
     * @return 结果
     */
    public int insertUserLogistics(UserLogistics userLogistics);

    /**
     * 修改userLogistics
     * 
     * @param userLogistics userLogistics
     * @return 结果
     */
    public int updateUserLogistics(UserLogistics userLogistics);

    /**
     * 批量删除userLogistics
     * 
     * @param tNums 需要删除的userLogistics主键集合
     * @return 结果
     */
    public int deleteUserLogisticsByTNums(String tNums);

    /**
     * 删除userLogistics信息
     * 
     * @param tNum userLogistics主键
     * @return 结果
     */
    public int deleteUserLogisticsByTNum(String tNum);

    /**
     * 查询获取Logistics正确数据
     * 获取过的数据将在temp表中删除
     */
    public List<UserLogistics> GetLogistics();
}
