package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TranUnload;

/**
 * 卸货表Service接口
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
public interface ITranUnloadService 
{
    /**
     * 查询卸货表
     * 
     * @param id 卸货表主键
     * @return 卸货表
     */
    public TranUnload selectTranUnloadById(Long id);

    /**
     * 查询卸货表列表
     * 
     * @param tranUnload 卸货表
     * @return 卸货表集合
     */
    public List<TranUnload> selectTranUnloadList(TranUnload tranUnload);

    /**
     * 新增卸货表
     * 
     * @param tranUnload 卸货表
     * @return 结果
     */
    public int insertTranUnload(TranUnload tranUnload);

    /**
     * 修改卸货表
     * 
     * @param tranUnload 卸货表
     * @return 结果
     */
    public int updateTranUnload(TranUnload tranUnload);

    /**
     * 批量删除卸货表
     * 
     * @param ids 需要删除的卸货表主键集合
     * @return 结果
     */
    public int deleteTranUnloadByIds(Long[] ids);

    /**
     * 删除卸货表信息
     * 
     * @param id 卸货表主键
     * @return 结果
     */
    public int deleteTranUnloadById(Long id);
}
