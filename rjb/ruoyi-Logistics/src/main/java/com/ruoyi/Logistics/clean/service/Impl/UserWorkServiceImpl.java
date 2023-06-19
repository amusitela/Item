package com.ruoyi.Logistics.clean.service.impl;

import java.util.List;

import com.ruoyi.Logistics.clean.domain.Conditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Logistics.clean.mapper.UserWorkMapper;
import com.ruoyi.Logistics.clean.domain.UserWork;
import com.ruoyi.Logistics.clean.service.IUserWorkService;
import com.ruoyi.common.core.text.Convert;

/**
 * workService业务层处理
 * 
 * @author lyw
 * @date 2023-06-16
 */
@Service
public class UserWorkServiceImpl implements IUserWorkService 
{
    @Autowired
    private UserWorkMapper userWorkMapper;

    /**
     * 查询work
     * 
     * @param num work主键
     * @return work
     */
    @Override
    public UserWork selectUserWorkByNum(Integer num)
    {
        return userWorkMapper.selectUserWorkByNum(num);
    }

    /**
     * 查询temp列表
     *
     * @param userWork work
     * @return work集合
     */
    @Override
    public List<UserWork> selectTempWorkList(UserWork userWork) {
        return userWorkMapper.selectTempWorkList(userWork);
    }

    /**
     * 查询work列表
     * 
     * @param userWork work
     * @return work
     */
    @Override
    public List<UserWork> selectUserWorkList(UserWork userWork)
    {
        return userWorkMapper.selectUserWorkList(userWork);
    }

    @Override
    public Double selectPortThroughput(Conditions conditions) {
        return userWorkMapper.selectPortThroughput(conditions);
    }

    /**
     * 新增work
     * 
     * @param userWork work
     * @return 结果
     */
    @Override
    public int insertUserWork(UserWork userWork)
    {
        return userWorkMapper.insertUserWork(userWork);
    }

    /**
     * 修改work
     * 
     * @param userWork work
     * @return 结果
     */
    @Override
    public int updateUserWork(UserWork userWork)
    {
        return userWorkMapper.updateUserWork(userWork);
    }

    /**
     * 批量删除work
     * 
     * @param nums 需要删除的work主键
     * @return 结果
     */
    @Override
    public int deleteUserWorkByNums(String nums)
    {
        return userWorkMapper.deleteUserWorkByNums(Convert.toStrArray(nums));
    }

    /**
     * 删除work信息
     * 
     * @param num work主键
     * @return 结果
     */
    @Override
    public int deleteUserWorkByNum(Integer num)
    {
        return userWorkMapper.deleteUserWorkByNum(num);
    }
}
