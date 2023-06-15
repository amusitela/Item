package com.ruoyi.Logistics.clean.service;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.UserContainer;

/**
 * userContainerService接口
 * 
 * @author lyw
 * @date 2023-06-14
 */
public interface IUserContainerService 
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
     * 批量删除userContainer
     * 
     * @param nums 需要删除的userContainer主键集合
     * @return 结果
     */
    public int deleteUserContainerByNums(String nums);

    /**
     * 删除userContainer信息
     * 
     * @param num userContainer主键
     * @return 结果
     */
    public int deleteUserContainerByNum(Integer num);
}
