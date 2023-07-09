package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TranPeople;

/**
 * 111Service接口
 * 
 * @author ruoyi
 * @date 2023-06-14
 */
public interface ITranPeopleService 
{
    /**
     * 查询111
     * 
     * @param kehuid 111主键
     * @return 111
     */
    public TranPeople selectTranPeopleByKehuid(String kehuid);

    /**
     * 查询111列表
     * 
     * @param tranPeople 111
     * @return 111集合
     */
    public List<TranPeople> selectTranPeopleList(TranPeople tranPeople);

    /**
     * 新增111
     * 
     * @param tranPeople 111
     * @return 结果
     */
    public int insertTranPeople(TranPeople tranPeople);

    /**
     * 修改111
     * 
     * @param tranPeople 111
     * @return 结果
     */
    public int updateTranPeople(TranPeople tranPeople);

    /**
     * 批量删除111
     * 
     * @param kehuids 需要删除的111主键集合
     * @return 结果
     */
    public int deleteTranPeopleByKehuids(String[] kehuids);

    /**
     * 删除111信息
     * 
     * @param kehuid 111主键
     * @return 结果
     */
    public int deleteTranPeopleByKehuid(String kehuid);
}
