package com.ruoyi.Logistics.clean.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Logistics.clean.mapper.CompanyMapper;
import com.ruoyi.Logistics.clean.domain.Company;
import com.ruoyi.Logistics.clean.service.ICompanyService;
import com.ruoyi.common.core.text.Convert;

/**
 * companyService业务层处理
 * 
 * @author lyw
 * @date 2023-06-13
 */
@Service
public class CompanyServiceImpl implements ICompanyService 
{
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 查询company
     * 
     * @param num company主键
     * @return company
     */
    @Override
    public Company selectCompanyByNum(Integer num)
    {
        return companyMapper.selectCompanyByNum(num);
    }

    /**
     * 查询company列表
     * 
     * @param company company
     * @return company
     */
    @Override
    public List<Company> selectCompanyList(Company company)
    {
        return companyMapper.selectCompanyList(company);
    }

    /**
     * 新增company
     * 
     * @param company company
     * @return 结果
     */
    @Override
    public int insertCompany(Company company)
    {
        return companyMapper.insertCompany(company);
    }

    /**
     * 修改company
     * 
     * @param company company
     * @return 结果
     */
    @Override
    public int updateCompany(Company company)
    {
        return companyMapper.updateCompany(company);
    }

    /**
     * 批量删除company
     * 
     * @param nums 需要删除的company主键
     * @return 结果
     */
    @Override
    public int deleteCompanyByNums(String nums)
    {
        return companyMapper.deleteCompanyByNums(Convert.toStrArray(nums));
    }

    /**
     * 删除company信息
     * 
     * @param num company主键
     * @return 结果
     */
    @Override
    public int deleteCompanyByNum(Integer num)
    {
        return companyMapper.deleteCompanyByNum(num);
    }
}
