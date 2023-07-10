package com.ruoyi.Logistics.clean.service;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.Company;

/**
 * companyService接口
 * 
 * @author lyw
 * @date 2023-06-13
 */
public interface ICompanyService 
{
    /**
     * 查询company
     * 
     * @param num company主键
     * @return company
     */
    public Company selectCompanyByCompanyNum(Integer num);

    /**
     * 查询company列表
     * 
     * @param company company
     * @return company集合
     */
    public List<Company> selectCompanyList(Company company);

    /**
     * 新增company
     * 
     * @param company company
     * @return 结果
     */
    public int insertCompany(Company company);

    /**
     * 修改company
     * 
     * @param company company
     * @return 结果
     */
    public int updateCompany(Company company);

    /**
     * 批量删除company
     * 
     * @param nums 需要删除的company主键集合
     * @return 结果
     */
    public int deleteCompanyByCompanyNums(String nums);

    /**
     * 删除company信息
     * 
     * @param num company主键
     * @return 结果
     */
    public int deleteCompanyByNum(String num);

    /**
     *清洗Company的重复数据
     *
     * */
    public List<Company> cleanCompany();
}
