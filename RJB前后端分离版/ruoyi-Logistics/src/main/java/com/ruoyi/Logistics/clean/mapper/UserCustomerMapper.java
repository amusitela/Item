package com.ruoyi.Logistics.clean.mapper;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.UserCustomer;

/**
 * userCustomerMapper接口
 * 
 * @author lyw
 * @date 2023-06-14
 */
public interface UserCustomerMapper 
{
    /**
     * 查询userCustomer
     * 
     * @param num userCustomer主键
     * @return userCustomer
     */
    public UserCustomer selectUserCustomerByNum(String num);

    /**
     * 查询userCustomer列表
     * 
     * @param userCustomer userCustomer
     * @return userCustomer集合
     */
    public List<UserCustomer> selectUserCustomerList(UserCustomer userCustomer);


    /**
     * 查询tempCustomer列表
     *
     * @param userCustomer userCustomer
     * @return userCustomer集合
     */
    public List<UserCustomer> selectTempCustomerList(UserCustomer userCustomer);


    /**
     * 新增userCustomer
     * 
     * @param userCustomer userCustomer
     * @return 结果
     */
    public int insertUserCustomer(UserCustomer userCustomer);

    /**
     * 修改userCustomer
     * 
     * @param userCustomer userCustomer
     * @return 结果
     */
    public int updateUserCustomer(UserCustomer userCustomer);

    /**
     * 删除userCustomer
     * 
     * @param num userCustomer主键
     * @return 结果
     */
    public int deleteUserCustomerByNum(String num);

    /**
     * 批量删除userCustomer
     * 
     * @param nums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserCustomerByNums(String[] nums);
}
