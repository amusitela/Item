package com.ruoyi.Logistics.clean.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Logistics.clean.mapper.UserCustomerMapper;
import com.ruoyi.Logistics.clean.domain.UserCustomer;
import com.ruoyi.Logistics.clean.service.IUserCustomerService;
import com.ruoyi.common.core.text.Convert;

/**
 * userCustomerService业务层处理
 * 
 * @author lyw
 * @date 2023-06-14
 */
@Service
public class UserCustomerServiceImpl implements IUserCustomerService
{
    @Autowired
    private UserCustomerMapper userCustomerMapper;

    /**
     * 查询userCustomer
     * 
     * @param num userCustomer主键
     * @return userCustomer
     */
    @Override
    public UserCustomer selectUserCustomerByNum(String num)
    {
        return userCustomerMapper.selectUserCustomerByNum(num);
    }

    /**
     * 查询userCustomer列表
     * 
     * @param userCustomer userCustomer
     * @return userCustomer
     */
    @Override
    public List<UserCustomer> selectUserCustomerList(UserCustomer userCustomer)
    {
        return userCustomerMapper.selectUserCustomerList(userCustomer);
    }

    @Override
    public List<UserCustomer> selectTempCustomerList(UserCustomer userCustomer) {
        return userCustomerMapper.selectTempCustomerList(userCustomer);
    }



    /**
     * 新增userCustomer
     * 
     * @param userCustomer userCustomer
     * @return 结果
     */
    @Override
    public int insertUserCustomer(UserCustomer userCustomer)
    {
        return userCustomerMapper.insertUserCustomer(userCustomer);
    }

    /**
     * 修改userCustomer
     * 
     * @param userCustomer userCustomer
     * @return 结果
     */
    @Override
    public int updateUserCustomer(UserCustomer userCustomer)
    {
        return userCustomerMapper.updateUserCustomer(userCustomer);
    }

    /**
     * 批量删除userCustomer
     * 
     * @param nums 需要删除的userCustomer主键
     * @return 结果
     */
    @Override
    public int deleteUserCustomerByNums(String nums)
    {
        return userCustomerMapper.deleteUserCustomerByNums(Convert.toStrArray(nums));
    }

    /**
     * 删除userCustomer信息
     * 
     * @param num userCustomer主键
     * @return 结果
     */
    @Override
    public int deleteUserCustomerByNum(String num)
    {
        return userCustomerMapper.deleteUserCustomerByNum(num);
    }
}
