package com.ruoyi.Logistics.clean.mapper;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.UserContainer;

/**
 * userContainerMapper接口
 * 
 * @author lyw
 * @date 2023-06-14
 */
public interface UserContainerMapper 
{
    /**
     * 查询userContainer
     * 
     * @param num userContainer主键
     * @return userContainer
     */
    public UserContainer selectUserContainerByNum(Integer num);

    /**
     * 查询userContainer列表
     * 
     * @param userContainer userContainer
     * @return userContainer集合
     */
    public List<UserContainer> selectUserContainerList(UserContainer userContainer);

    /**
     * 查询TempContainer列表
     *
     * @param userContainer userContainer
     * @return userContainer集合
     */
    public List<UserContainer> selectTempContainerList(UserContainer userContainer);

    /**
     * 新增userContainer
     * 
     * @param userContainer userContainer
     * @return 结果
     */
    public int insertUserContainer(UserContainer userContainer);

    /**
     * 修改userContainer
     * 
     * @param userContainer userContainer
     * @return 结果
     */
    public int updateUserContainer(UserContainer userContainer);

    /**
     * 删除userContainer
     * 
     * @param num userContainer主键
     * @return 结果
     */
    public int deleteUserContainerByNum(Integer num);

    /**
     * 批量删除userContainer
     * 
     * @param nums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserContainerByNums(String[] nums);
}
