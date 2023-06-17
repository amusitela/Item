package com.ruoyi.Logistics.clean.mapper;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.UserWork;

/**
 * workMapper接口
 * 
 * @author lyw
 * @date 2023-06-16
 */
public interface UserWorkMapper 
{
    /**
     * 查询work
     * 
     * @param num work主键
     * @return work
     */
    public UserWork selectUserWorkByNum(Integer num);

    /**
     * 查询temp列表
     *
     * @param userWork work
     * @return work集合
     */
    public List<UserWork>selectTempWorkList(UserWork userWork);

    /**
     * 查询work列表
     * 
     * @param userWork work
     * @return work集合
     */
    public List<UserWork> selectUserWorkList(UserWork userWork);

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
     * 删除work
     * 
     * @param num work主键
     * @return 结果
     */
    public int deleteUserWorkByNum(Integer num);

    /**
     * 批量删除work
     * 
     * @param nums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserWorkByNums(String[] nums);
}
