package com.ruoyi.Logistics.clean.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.Logistics.clean.domain.Conditions;
import com.ruoyi.Logistics.clean.domain.Goods;
import com.ruoyi.Logistics.clean.mapper.WorkMapper;
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

    @Autowired
    private WorkMapper workMapper;

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
     * 获取过的数据将在temp表中删除
     * 获取work的正确数据
     */
    @Override
    public List<UserWork> GetWork()
    {
        List<UserWork> list = userWorkMapper.selectTempWorkList(new UserWork());
        for (UserWork user: list
        ) {
            int i = userWorkMapper.insertUserWork(user);
            int i1 = workMapper.deleteWorkByNo(Long.valueOf(user.getNum()));
        }
        List<UserWork> userWorks = userWorkMapper.selectUserWorkList(new UserWork());
        return userWorks;
    }

    /**
     * 查询同比
     *
     * @param conditions
     * @return Map
     */
    @Override
    public Map<String,Object> selectTONGBI(Conditions conditions) {
        return userWorkMapper.selectTONGBI(conditions);
    }

    /**
     * 查询日趋势
     *
     * @param conditions
     * @return Map
     */
    @Override
    public Map<String, Object> selectRIQU(Conditions conditions) {
        return userWorkMapper.selectRIQU(conditions);
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

    /**
     * 查询港口吞吐量
     *
     * @param conditions
     * @return Map
     */
    @Override
    public Double selectAllThroughput(Conditions conditions) {
        return userWorkMapper.selectAllThroughput(conditions);
    }

    /**
     * 查询港口吞吐量
     *
     * @param conditions
     * @return Map
     */
    @Override
    public Map<String,Object> selectPortThroughput(Conditions conditions) {
        return userWorkMapper.selectPortThroughput(conditions);
    }

    /**
     * 查询货物吞吐量
     *
     * @param conditions
     * @return Map
     */
    @Override
    public Map<String,Object> selectGoodsThroughput(Conditions conditions) {
        return userWorkMapper.selectGoodsThroughput(conditions);
    }

    /**
     * 查询货物流向
     *
     * @param conditions
     * @return Map
     */
    @Override
    public List<Goods> selectGoodsGoWhere(Conditions conditions){
        return userWorkMapper.selectGoodsGoWhere(conditions);
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
