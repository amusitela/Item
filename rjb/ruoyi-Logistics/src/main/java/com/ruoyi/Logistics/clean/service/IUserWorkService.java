package com.ruoyi.Logistics.clean.service;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.UserWork;

/**
 * workService接口
 * 
 * @author lyw
 * @date 2023-06-14
 */
public interface IUserWorkService 
{
    /**
     * 查询work
     * 
     * @param num work主键
     * @return work
     */
    public UserWork selectUserWorkByNum(Integer num);

    /**
     * 查询work列表
     * 
     * @param userWork work
     * @return work集合
     */
    public List<UserWork> selectUserWorkList(UserWork userWork);


    /**
     * 查询tempwork列表
     *
     * @param userWork work
     * @return work集合
     */
    public List<UserWork> selectTempWorkList(UserWork userWork);

    /**
     * 新增work
     * 
     * @param userWork work
     * @return 结果
     */
    public int insertUserWork(UserWork userWork);

    /**
     * 修改work
     * 
     * @param userWork work
     * @return 结果
     */
    public int updateUserWork(UserWork userWork);

    /**
     * 批量删除work
     * 
     * @param nums 需要删除的work主键集合
     * @return 结果
     */
    public int deleteUserWorkByNums(String nums);

    /**
     * 删除work信息
     * 
     * @param num work主键
     * @return 结果
     */
    public int deleteUserWorkByNum(Integer num);
}
