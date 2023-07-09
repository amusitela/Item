package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TranInfoMapper;
import com.ruoyi.system.domain.TranInfo;
import com.ruoyi.system.service.ITranInfoService;

/**
 * 物流信息Service业务层处理
 * 
 * @author 111
 * @date 2023-07-06
 */
@Service
public class TranInfoServiceImpl implements ITranInfoService 
{
    @Autowired
    private TranInfoMapper tranInfoMapper;

    /**
     * 查询物流信息
     * 
     * @param id 物流信息主键
     * @return 物流信息
     */
    @Override
    public TranInfo selectTranInfoById(String id)
    {
        return tranInfoMapper.selectTranInfoById(id);
    }

    /**
     * 查询物流信息列表
     * 
     * @param tranInfo 物流信息
     * @return 物流信息
     */
    @Override
    public List<TranInfo> selectTranInfoList(TranInfo tranInfo)
    {
        return tranInfoMapper.selectTranInfoList(tranInfo);
    }

    /**
     * 新增物流信息
     * 
     * @param tranInfo 物流信息
     * @return 结果
     */
    @Override
    public int insertTranInfo(TranInfo tranInfo)
    {
        return tranInfoMapper.insertTranInfo(tranInfo);
    }

    /**
     * 修改物流信息
     * 
     * @param tranInfo 物流信息
     * @return 结果
     */
    @Override
    public int updateTranInfo(TranInfo tranInfo)
    {
        return tranInfoMapper.updateTranInfo(tranInfo);
    }

    /**
     * 批量删除物流信息
     * 
     * @param ids 需要删除的物流信息主键
     * @return 结果
     */
    @Override
    public int deleteTranInfoByIds(String[] ids)
    {
        return tranInfoMapper.deleteTranInfoByIds(ids);
    }

    /**
     * 删除物流信息信息
     * 
     * @param id 物流信息主键
     * @return 结果
     */
    @Override
    public int deleteTranInfoById(String id)
    {
        return tranInfoMapper.deleteTranInfoById(id);
    }
}
