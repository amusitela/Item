package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TranTrends;

/**
 * 集装箱动态Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
public interface TranTrendsMapper 
{
    /**
     * 查询集装箱动态
     * 
     * @param id 集装箱动态主键
     * @return 集装箱动态
     */
    public TranTrends selectTranTrendsById(Long id);

    /**
     * 查询集装箱动态列表
     * 
     * @param tranTrends 集装箱动态
     * @return 集装箱动态集合
     */
    public List<TranTrends> selectTranTrendsList(TranTrends tranTrends);

    /**
     * 新增集装箱动态
     * 
     * @param tranTrends 集装箱动态
     * @return 结果
     */
    public int insertTranTrends(TranTrends tranTrends);

    /**
     * 修改集装箱动态
     * 
     * @param tranTrends 集装箱动态
     * @return 结果
     */
    public int updateTranTrends(TranTrends tranTrends);

    /**
     * 删除集装箱动态
     * 
     * @param id 集装箱动态主键
     * @return 结果
     */
    public int deleteTranTrendsById(Long id);

    /**
     * 批量删除集装箱动态
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTranTrendsByIds(Long[] ids);
}
