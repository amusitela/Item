package com.ruoyi.Logistics.clean.service.impl;

import java.util.List;

import com.ruoyi.Logistics.clean.domain.Company;
import com.ruoyi.Logistics.clean.domain.UserWork;
import com.ruoyi.Logistics.clean.mapper.CompanyMapper;
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

    @Autowired
    private CompanyMapper companyMapper;

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

    /**
     * 获取TempCompany正确的数据列表
     * 获取过的数据将在temp表中删除
     */
    @Override
    public List<UserCompany> getCompany()
    {
        List<UserCompany> userCompanies = userCompanyMapper.selectTempCompanyList(new UserCompany());
        for (UserCompany user:userCompanies
        ) {
            //插入时也需要考虑到去重
//            if(userCompanyMapper.selectUserCompanyList(user) == null){
                int i = userCompanyMapper.insertUserCompany(user);
//            }else{
//                Company company = new Company();
//                company.setCompanyNum(Integer.valueOf(user.getCompanyNum()));
//                company.setCompanyName(user.getCompanyName());
//                company.setCustomerNum(user.getCustomerNum());
//                company.setPersonName(user.getPersonName());
//                company.setPhone(user.getPhone());
//                company.setPlace(user.getPlace());
//                company.setError(1);
//                int i = companyMapper.updateCompany(company);
//            }
        }
        String a[]= new String[1001];
        int b= 0 ;
        int c= 0 ;
        int size = userCompanies.size();
        for (UserCompany user:userCompanies
        ) {
            b++;
            c++;
            a[b]= String.valueOf(user.getCompanyNum());
            if(b==1000){
                int i1 = companyMapper.deleteCompanyByNums(a);
                b=0;
                a=new String[1001];
            }
            if(c==(size-1)){
                int i1 = companyMapper.deleteCompanyByNums(a);
            }
        }
        return null;

    }
}
