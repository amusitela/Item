package com.ruoyi.Logistics.clean.service.impl;

import java.util.List;

import com.ruoyi.Logistics.clean.mapper.ContainerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Logistics.clean.mapper.UserContainerMapper;
import com.ruoyi.Logistics.clean.domain.UserContainer;
import com.ruoyi.Logistics.clean.service.IUserContainerService;
import com.ruoyi.common.core.text.Convert;

/**
 * userContainerService业务层处理
 * 
 * @author lyw
 * @date 2023-06-14
 */
@Service
public class UserContainerServiceImpl implements IUserContainerService 
{
    @Autowired
    private UserContainerMapper userContainerMapper;

    @Autowired
    private ContainerMapper containerMapper;
    /**
     * 查询userContainer
     * 
     * @param num userContainer主键
     * @return userContainer
     */
    @Override
    public UserContainer selectUserContainerByNum(Integer num)
    {
        return userContainerMapper.selectUserContainerByNum(num);
    }

    /**
     * 查询userContainer列表
     * 
     * @param userContainer userContainer
     * @return userContainer
     */
    @Override
    public List<UserContainer> selectUserContainerList(UserContainer userContainer)
    {
        return userContainerMapper.selectUserContainerList(userContainer);
    }

    /**
     * 查询TempContainer列表
     *
     * @param userContainer userContainer
     * @return userContainer
     */
    @Override
    public List<UserContainer> selectTempContainerList(UserContainer userContainer) {
        return userContainerMapper.selectTempContainerList(userContainer);
    }

    /**
     * 新增userContainer
     * 
     * @param userContainer userContainer
     * @return 结果
     */
    @Override
    public int insertUserContainer(UserContainer userContainer)
    {
        return userContainerMapper.insertUserContainer(userContainer);
    }

    /**
     * 修改userContainer
     * 
     * @param userContainer userContainer
     * @return 结果
     */
    @Override
    public int updateUserContainer(UserContainer userContainer)
    {
        return userContainerMapper.updateUserContainer(userContainer);
    }

    /**
     * 批量删除userContainer
     * 
     * @param nums 需要删除的userContainer主键
     * @return 结果
     */
    @Override
    public int deleteUserContainerByNums(String nums)
    {
        return userContainerMapper.deleteUserContainerByNums(Convert.toStrArray(nums));
    }

    /**
     * 删除userContainer信息
     * 
     * @param num userContainer主键
     * @return 结果
     */
    @Override
    public int deleteUserContainerByNum(Integer num)
    {
        return userContainerMapper.deleteUserContainerByNum(num);
    }

    @Override
    public List<UserContainer> getContainer()
    {
        List<UserContainer> list = userContainerMapper.selectTempContainerList(new UserContainer());
        for (UserContainer user : list
        ) {
            int i = userContainerMapper.insertUserContainer(user);
            int i1 = containerMapper.deleteContainerByNum(user.getNum());
        }
        List<UserContainer> userContainers = userContainerMapper.selectUserContainerList(new UserContainer());
        return userContainers;
    }
}
