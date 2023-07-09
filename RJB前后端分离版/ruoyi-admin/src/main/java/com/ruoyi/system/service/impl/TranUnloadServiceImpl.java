package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TranUnloadMapper;
import com.ruoyi.system.domain.TranUnload;
import com.ruoyi.system.service.ITranUnloadService;

/**
 * 卸货表Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-06
 */
@Service
public class TranUnloadServiceImpl implements ITranUnloadService 
{
    @Autowired
    private TranUnloadMapper tranUnloadMapper;

    /**
     * 查询卸货表
     * 
     * @param id 卸货表主键
     * @return 卸货表
     */
    @Override
    public TranUnload selectTranUnloadById(Long id)
    {
        return tranUnloadMapper.selectTranUnloadById(id);
    }

    /**
     * 查询卸货表列表
     * 
     * @param tranUnload 卸货表
     * @return 卸货表
     */
    @Override
    public List<TranUnload> selectTranUnloadList(TranUnload tranUnload)
    {
        return tranUnloadMapper.selectTranUnloadList(tranUnload);
    }

    /**
     * 新增卸货表
     * 
     * @param tranUnload 卸货表
     * @return 结果
     */
    @Override
    public int insertTranUnload(TranUnload tranUnload)
    {
        return tranUnloadMapper.insertTranUnload(tranUnload);
    }

    /**
     * 修改卸货表
     * 
     * @param tranUnload 卸货表
     * @return 结果
     */
    @Override
    public int updateTranUnload(TranUnload tranUnload)
    {
        return tranUnloadMapper.updateTranUnload(tranUnload);
    }

    /**
     * 批量删除卸货表
     * 
     * @param ids 需要删除的卸货表主键
     * @return 结果
     */
    @Override
    public int deleteTranUnloadByIds(Long[] ids)
    {
        return tranUnloadMapper.deleteTranUnloadByIds(ids);
    }

    /**
     * 删除卸货表信息
     * 
     * @param id 卸货表主键
     * @return 结果
     */
    @Override
    public int deleteTranUnloadById(Long id)
    {
        return tranUnloadMapper.deleteTranUnloadById(id);
    }
}
