package com.ruoyi.Logistics.clean.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Company selectCompanyByCompanyNum(Integer num)
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
    public int deleteCompanyByCompanyNums(String nums)
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

    /**
     *清洗Company的重复数据
     *
     * */
    @Override
    public List<Company> cleanCompany(){

        //录入temp数据库的内容
        List<Company> companies = companyMapper.selectCompanyList(new Company());
        //用于去重使用，利用了map自带的方法
        Map<String, Integer> companymapper = new HashMap<>();
        Company company = null;
        //控制台输出
        for (int i = 0; i < companies.size(); i ++ ) System.out.println(companies.get(i));
        //去重的具体思路
        for (int i = 0; i < companies.size(); i ++ ) {
            company = companies.get(i);
            System.out.println(company);
            if (companymapper.get(company.getCompanyName()) == null) {
                companymapper.put(company.getCompanyName(), 1);
            }
            else {
                company.setError(1);
            }
            System.out.println(company.getError());
            //更新标记异常数据
            if (company.getError() == 1) companyMapper.updateCompany(company);
        }

        return companyMapper.selectCompanyList(new Company());
    }
}
