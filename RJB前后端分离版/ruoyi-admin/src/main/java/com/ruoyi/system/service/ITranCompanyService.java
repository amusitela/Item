package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.TranCompany;

/**
 * 公司表Service接口
 * 
 * @author 111
 * @date 2023-07-06
 */
public interface ITranCompanyService 
{
    /**
     * 查询公司表
     * 
     * @param id 公司表主键
     * @return 公司表
     */
    public TranCompany selectTranCompanyById(Long id);

    /**
     * 查询公司表列表
     * 
     * @param tranCompany 公司表
     * @return 公司表集合
     */
    public List<TranCompany> selectTranCompanyList(TranCompany tranCompany);

    /**
     * 新增公司表
     * 
     * @param tranCompany 公司表
     * @return 结果
     */
    public int insertTranCompany(TranCompany tranCompany);

    /**
     * 修改公司表
     * 
     * @param tranCompany 公司表
     * @return 结果
     */
    public int updateTranCompany(TranCompany tranCompany);

    /**
     * 批量删除公司表
     * 
     * @param ids 需要删除的公司表主键集合
     * @return 结果
     */
    public int deleteTranCompanyByIds(Long[] ids);

    /**
     * 删除公司表信息
     * 
     * @param id 公司表主键
     * @return 结果
     */
    public int deleteTranCompanyById(Long id);
}
