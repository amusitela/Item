package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TranCompanyMapper;
import com.ruoyi.system.domain.TranCompany;
import com.ruoyi.system.service.ITranCompanyService;

/**
 * 公司表Service业务层处理
 * 
 * @author 111
 * @date 2023-07-06
 */
@Service
public class TranCompanyServiceImpl implements ITranCompanyService 
{
    @Autowired
    private TranCompanyMapper tranCompanyMapper;

    /**
     * 查询公司表
     * 
     * @param id 公司表主键
     * @return 公司表
     */
    @Override
    public TranCompany selectTranCompanyById(Long id)
    {
        return tranCompanyMapper.selectTranCompanyById(id);
    }

    /**
     * 查询公司表列表
     * 
     * @param tranCompany 公司表
     * @return 公司表
     */
    @Override
    public List<TranCompany> selectTranCompanyList(TranCompany tranCompany)
    {
        return tranCompanyMapper.selectTranCompanyList(tranCompany);
    }

    /**
     * 新增公司表
     * 
     * @param tranCompany 公司表
     * @return 结果
     */
    @Override
    public int insertTranCompany(TranCompany tranCompany)
    {
        return tranCompanyMapper.insertTranCompany(tranCompany);
    }

    /**
     * 修改公司表
     * 
     * @param tranCompany 公司表
     * @return 结果
     */
    @Override
    public int updateTranCompany(TranCompany tranCompany)
    {
        return tranCompanyMapper.updateTranCompany(tranCompany);
    }

    /**
     * 批量删除公司表
     * 
     * @param ids 需要删除的公司表主键
     * @return 结果
     */
    @Override
    public int deleteTranCompanyByIds(Long[] ids)
    {
        return tranCompanyMapper.deleteTranCompanyByIds(ids);
    }

    /**
     * 删除公司表信息
     * 
     * @param id 公司表主键
     * @return 结果
     */
    @Override
    public int deleteTranCompanyById(Long id)
    {
        return tranCompanyMapper.deleteTranCompanyById(id);
    }
}
