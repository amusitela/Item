package com.ruoyi.Logistics.clean.mapper;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.Customer;

/**
 * CustomerMapper接口
 * 
 * @author lyw
 * @date 2023-06-12
 */
public interface CustomerMapper 
{

    /**
     * 查询Customer
     * 
     * @param num Customer主键
     * @return Customer
     */
    public Customer selectCustomerByNum(String num);

    /**
     * 查询Customer列表
     * 
     * @param customer Customer
     * @return Customer集合
     */
    public List<Customer> selectCustomerList(Customer customer);
    /**
     * 查询Customer信息
     *
     *
     * @return Customer集合
     */
    public List<Customer> selectAllCustomer();

    /**
     * 新增Customer
     * 
     * @param customer Customer
     * @return 结果
     */
    public int insertCustomer(Customer customer);

    /**
     * 修改Customer
     * 
     * @param customer Customer
     * @return 结果
     */
    public int updateCustomer(Customer customer);
    /**
     * 修改Customer
     *
     * @param num
     * @return 结果
     */
    public int updateCustomerByNum(String num);

    /**
     * 删除Customer
     * 
     * @param num Customer主键
     * @return 结果
     */
    public int deleteCustomerByNum(String num);

    /**
     * 批量删除Customer
     * 
     * @param nums 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCustomerByNums(String[] nums);
}
