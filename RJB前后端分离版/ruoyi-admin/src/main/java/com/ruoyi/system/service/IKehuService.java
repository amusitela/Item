package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Kehu;

/**
 * 111Service接口
 * 
 * @author ruoyi
 * @date 2023-06-13
 */
public interface IKehuService 
{
    /**
     * 查询111
     * 
     * @param id 111主键
     * @return 111
     */
    public Kehu selectKehuById(String id);

    /**
     * 查询111列表
     * 
     * @param kehu 111
     * @return 111集合
     */
    public List<Kehu> selectKehuList(Kehu kehu);

    /**
     * 新增111
     * 
     * @param kehu 111
     * @return 结果
     */
    public int insertKehu(Kehu kehu);

    /**
     * 修改111
     * 
     * @param kehu 111
     * @return 结果
     */
    public int updateKehu(Kehu kehu);

    /**
     * 批量删除111
     * 
     * @param ids 需要删除的111主键集合
     * @return 结果
     */
    public int deleteKehuByIds(String[] ids);

    /**
     * 删除111信息
     * 
     * @param id 111主键
     * @return 结果
     */
    public int deleteKehuById(String id);
}
