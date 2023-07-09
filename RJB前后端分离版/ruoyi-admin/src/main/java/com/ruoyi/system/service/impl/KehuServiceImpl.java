package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.KehuMapper;
import com.ruoyi.system.domain.Kehu;
import com.ruoyi.system.service.IKehuService;

/**
 * 111Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-13
 */
@Service
public class KehuServiceImpl implements IKehuService 
{
    @Autowired
    private KehuMapper kehuMapper;

    /**
     * 查询111
     * 
     * @param id 111主键
     * @return 111
     */
    @Override
    public Kehu selectKehuById(String id)
    {
        return kehuMapper.selectKehuById(id);
    }

    /**
     * 查询111列表
     * 
     * @param kehu 111
     * @return 111
     */
    @Override
    public List<Kehu> selectKehuList(Kehu kehu)
    {
        return kehuMapper.selectKehuList(kehu);
    }

    /**
     * 新增111
     * 
     * @param kehu 111
     * @return 结果
     */
    @Override
    public int insertKehu(Kehu kehu)
    {
        return kehuMapper.insertKehu(kehu);
    }

    /**
     * 修改111
     * 
     * @param kehu 111
     * @return 结果
     */
    @Override
    public int updateKehu(Kehu kehu)
    {
        return kehuMapper.updateKehu(kehu);
    }

    /**
     * 批量删除111
     * 
     * @param ids 需要删除的111主键
     * @return 结果
     */
    @Override
    public int deleteKehuByIds(String[] ids)
    {
        return kehuMapper.deleteKehuByIds(ids);
    }

    /**
     * 删除111信息
     * 
     * @param id 111主键
     * @return 结果
     */
    @Override
    public int deleteKehuById(String id)
    {
        return kehuMapper.deleteKehuById(id);
    }
}
