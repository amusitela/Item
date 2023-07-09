package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TranPeopleMapper;
import com.ruoyi.system.domain.TranPeople;
import com.ruoyi.system.service.ITranPeopleService;

/**
 * 111Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-14
 */
@Service
public class TranPeopleServiceImpl implements ITranPeopleService 
{
    @Autowired
    private TranPeopleMapper tranPeopleMapper;

    /**
     * 查询111
     * 
     * @param kehuid 111主键
     * @return 111
     */
    @Override
    public TranPeople selectTranPeopleByKehuid(String kehuid)
    {
        return tranPeopleMapper.selectTranPeopleByKehuid(kehuid);
    }

    /**
     * 查询111列表
     * 
     * @param tranPeople 111
     * @return 111
     */
    @Override
    public List<TranPeople> selectTranPeopleList(TranPeople tranPeople)
    {
        return tranPeopleMapper.selectTranPeopleList(tranPeople);
    }

    /**
     * 新增111
     * 
     * @param tranPeople 111
     * @return 结果
     */
    @Override
    public int insertTranPeople(TranPeople tranPeople)
    {
        return tranPeopleMapper.insertTranPeople(tranPeople);
    }

    /**
     * 修改111
     * 
     * @param tranPeople 111
     * @return 结果
     */
    @Override
    public int updateTranPeople(TranPeople tranPeople)
    {
        return tranPeopleMapper.updateTranPeople(tranPeople);
    }

    /**
     * 批量删除111
     * 
     * @param kehuids 需要删除的111主键
     * @return 结果
     */
    @Override
    public int deleteTranPeopleByKehuids(String[] kehuids)
    {
        return tranPeopleMapper.deleteTranPeopleByKehuids(kehuids);
    }

    /**
     * 删除111信息
     * 
     * @param kehuid 111主键
     * @return 结果
     */
    @Override
    public int deleteTranPeopleByKehuid(String kehuid)
    {
        return tranPeopleMapper.deleteTranPeopleByKehuid(kehuid);
    }
}
