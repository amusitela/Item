package com.ruoyi.Logistics.clean.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.Logistics.clean.domain.Conditions;
import com.ruoyi.Logistics.clean.domain.Goods;
import com.ruoyi.Logistics.clean.domain.UserWork;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

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
     * 查询港口吞吐量
     *
     * @param conditions
     * @return Double
     */
    public Double selectAllThroughput(@Param("conditions") Conditions conditions);

    /**
     * 查询港口吞吐量
     *
     * @param conditions
     * @return Map
     */
    @MapKey("作业港口")
    public Map<String,Object> selectPortThroughput(@Param("conditions") Conditions conditions);

    /**
     * 查询货物吞吐量
     *
     * @param conditions
     * @return Map
     */
    @MapKey("货物名称")
    public Map<String,Object> selectGoodsThroughput(@Param("conditions") Conditions conditions);

    /**
     * 查询货物流向
     *
     * @param conditions
     * @return Map
     */

    public List<Goods> selectGoodsGoWhere(@Param("conditions") Conditions conditions);

    /**
     * 查询同比
     *
     * @param conditions
     * @return Map
     */
    @MapKey("now")
    public Map<String,Object> selectTONGBI(@Param("conditions") Conditions conditions);
    /**
     * 查询货物日趋
     *
     * @param conditions
     * @return Map
     */
    @MapKey("now")
     public Map<String,Object> selectRIQU(@Param("conditions")Conditions conditions);

    @MapKey("货物名称")
    public Map<String,Object> selectRUKU(@Param("conditions")Conditions conditions);

    @MapKey("货物名称")
    public Map<String,Object> selectCHUKU(@Param("conditions")Conditions conditions);

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
     * 删除work
     * 
     * @param num work主键
     * @return 结果
     */
    public int deleteUserWorkByNum(String num);

    /**
     * 批量删除work
     * 
     * @param nums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserWorkByNums(String[] nums);
}
