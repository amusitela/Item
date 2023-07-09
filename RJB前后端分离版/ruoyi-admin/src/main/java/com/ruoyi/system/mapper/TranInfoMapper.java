package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TranInfo;

/**
 * 物流信息Mapper接口
 * 
 * @author 111
 * @date 2023-07-06
 */
public interface TranInfoMapper 
{
    /**
     * 查询物流信息
     * 
     * @param id 物流信息主键
     * @return 物流信息
     */
    public TranInfo selectTranInfoById(String id);

    /**
     * 查询物流信息列表
     * 
     * @param tranInfo 物流信息
     * @return 物流信息集合
     */
    public List<TranInfo> selectTranInfoList(TranInfo tranInfo);

    /**
     * 新增物流信息
     * 
     * @param tranInfo 物流信息
     * @return 结果
     */
    public int insertTranInfo(TranInfo tranInfo);

    /**
     * 修改物流信息
     * 
     * @param tranInfo 物流信息
     * @return 结果
     */
    public int updateTranInfo(TranInfo tranInfo);

    /**
     * 删除物流信息
     * 
     * @param id 物流信息主键
     * @return 结果
     */
    public int deleteTranInfoById(String id);

    /**
     * 批量删除物流信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTranInfoByIds(String[] ids);
}
