package com.ruoyi.Logistics.clean.service;

import java.util.List;
import com.ruoyi.Logistics.clean.domain.Customer;

/**
 * CustomerService接口
 * 
 * @author lyw
 * @date 2023-06-12
 */
public interface ICustomerService 
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
     * 批量删除Customer
     * 
     * @param nums 需要删除的Customer主键集合
     * @return 结果
     */
    public int deleteCustomerByNums(String nums);

    /**
     * 删除Customer信息
     * 
     * @param num Customer主键
     * @return 结果
     */
    public int deleteCustomerByNum(String num);
}
