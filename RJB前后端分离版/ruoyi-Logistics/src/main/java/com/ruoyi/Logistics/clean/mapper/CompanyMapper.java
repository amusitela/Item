package com.ruoyi.Logistics.clean.mapper;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.Company;

/**
 * companyMapper接口
 * 
 * @author lyw
 * @date 2023-06-13
 */
public interface CompanyMapper 
{
    /**
     * 查询company
     * 
     * @param num company主键
     * @return company
     */
    public Company selectCompanyByNum(Integer num);

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
     * 删除company
     * 
     * @param num company主键
     * @return 结果
     */
    public int deleteCompanyByNum(String num);

    /**
     * 批量删除company
     * 
     * @param nums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompanyByNums(String[] nums);
}
