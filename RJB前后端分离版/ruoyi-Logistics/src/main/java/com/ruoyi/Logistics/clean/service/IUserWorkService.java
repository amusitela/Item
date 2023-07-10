package com.ruoyi.Logistics.clean.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.Logistics.clean.domain.Conditions;
import com.ruoyi.Logistics.clean.domain.Goods;
import com.ruoyi.Logistics.clean.domain.UserWork;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

/**
 * workService接口
 * 
 * @author lyw
 * @date 2023-06-16
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
     * 查询temp列表
     *
     * @param userWork work
     * @return work集合
     */
    public List<UserWork> selectTempWorkList(UserWork userWork);

    /**
     * 获取过的数据将在temp表中删除
     * 获取work的正确数据
     */
    public List<UserWork> GetWork();

    /**
     * 查询同比
     *
     * @param conditions
     * @return Map
     */
    public Map<String,Object> selectTONGBI(Conditions conditions);

    /**
     * 查询日趋势
     *
     * @param conditions
     * @return Map
     */
    public Map<String,Object> selectRIQU( Conditions conditions);
    /**
     * 查询work列表
     * 
     * @param userWork work
     * @return work集合
     */
    public List<UserWork> selectUserWorkList(UserWork userWork);

    /**
     * 查询港口吞吐量
     *
     * @param conditions
     * @return Double
     */
    public Double selectAllThroughput(Conditions conditions);

    /**
     * 查询港口吞吐量
     *
     * @param conditions
     * @return Map
     */
    public Map<String,Object> selectPortThroughput(Conditions conditions);

    /**
     * 查询货物吞吐量
     *
     * @param conditions
     * @return Map
     */
    public Map<String,Object> selectGoodsThroughput(Conditions conditions);

    /**
     * 查询货物入库周期分析
     *
     * @param conditions
     * @return Map
     */
    public Map<String,Object> selectRUKU(Conditions conditions);

    /**
     * 查询货物出库周期分析
     *
     * @param conditions
     * @return Map
     */
    public Map<String,Object> selectCHUKU(Conditions conditions);

    /**
     * 查询货物流向
     *
     * @param conditions
     * @return Map
     */
    public List<Goods> selectGoodsGoWhere(Conditions conditions);
    /**
     * 更新视图
     *
     * @param
     * @return void
     */

    /**
     * 新增work
     * 
     * @param userWork work
     * @return 结果
     */
    public int insertUserWork(UserWork userWork);

    public int insert(UserWork userWork);
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
    public int deleteUserWorkByNum(String num);
}
