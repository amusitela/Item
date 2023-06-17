package com.ruoyi.Logistics.clean.mapper;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.UserCompany;

/**
 * userCompanyMapper接口
 * 
 * @author lyw
 * @date 2023-06-17
 */
public interface UserCompanyMapper 
{
    /**
     * 查询userCompany
     * 
     * @param companyNum userCompany主键
     * @return userCompany
     */
    public UserCompany selectUserCompanyByCompanyNum(Integer companyNum);

    /**
     * 查询userCompany列表
     * 
     * @param userCompany userCompany
     * @return userCompany集合
     */
    public List<UserCompany> selectUserCompanyList(UserCompany userCompany);

    /**
     * 查询TempCompany列表
     *
     * @param userCompany userCompany
     * @return userCompany集合
     */
    public List<UserCompany> selectTempCompanyList(UserCompany userCompany);

    /**
     * 新增userCompany
     * 
     * @param userCompany userCompany
     * @return 结果
     */
    public int insertUserCompany(UserCompany userCompany);

    /**
     * 修改userCompany
     * 
     * @param userCompany userCompany
     * @return 结果
     */
    public int updateUserCompany(UserCompany userCompany);

    /**
     * 删除userCompany
     * 
     * @param companyNum userCompany主键
     * @return 结果
     */
    public int deleteUserCompanyByCompanyNum(Integer companyNum);

    /**
     * 批量删除userCompany
     * 
     * @param companyNums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserCompanyByCompanyNums(String[] companyNums);
}
