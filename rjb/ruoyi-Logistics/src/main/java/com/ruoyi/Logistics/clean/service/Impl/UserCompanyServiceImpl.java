package com.ruoyi.Logistics.clean.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Logistics.clean.mapper.UserCompanyMapper;
import com.ruoyi.Logistics.clean.domain.UserCompany;
import com.ruoyi.Logistics.clean.service.IUserCompanyService;
import com.ruoyi.common.core.text.Convert;

/**
 * userCompanyService业务层处理
 * 
 * @author lyw
 * @date 2023-06-17
 */
@Service
public class UserCompanyServiceImpl implements IUserCompanyService 
{
    @Autowired
    private UserCompanyMapper userCompanyMapper;

    /**
     * 查询userCompany
     * 
     * @param companyNum userCompany主键
     * @return userCompany
     */
    @Override
    public UserCompany selectUserCompanyByCompanyNum(Integer companyNum)
    {
        return userCompanyMapper.selectUserCompanyByCompanyNum(companyNum);
    }

    /**
     * 查询userCompany列表
     * 
     * @param userCompany userCompany
     * @return userCompany
     */
    @Override
    public List<UserCompany> selectUserCompanyList(UserCompany userCompany)
    {
        return userCompanyMapper.selectUserCompanyList(userCompany);
    }

    @Override
    public List<UserCompany> selectTempCompanyList(UserCompany userCompany) {
        return userCompanyMapper.selectTempCompanyList(userCompany);
    }

    /**
     * 新增userCompany
     * 
     * @param userCompany userCompany
     * @return 结果
     */
    @Override
    public int insertUserCompany(UserCompany userCompany)
    {
        return userCompanyMapper.insertUserCompany(userCompany);
    }

    /**
     * 修改userCompany
     * 
     * @param userCompany userCompany
     * @return 结果
     */
    @Override
    public int updateUserCompany(UserCompany userCompany)
    {
        return userCompanyMapper.updateUserCompany(userCompany);
    }

    /**
     * 批量删除userCompany
     * 
     * @param companyNums 需要删除的userCompany主键
     * @return 结果
     */
    @Override
    public int deleteUserCompanyByCompanyNums(String companyNums)
    {
        return userCompanyMapper.deleteUserCompanyByCompanyNums(Convert.toStrArray(companyNums));
    }

    /**
     * 删除userCompany信息
     * 
     * @param companyNum userCompany主键
     * @return 结果
     */
    @Override
    public int deleteUserCompanyByCompanyNum(Integer companyNum)
    {
        return userCompanyMapper.deleteUserCompanyByCompanyNum(companyNum);
    }
}
