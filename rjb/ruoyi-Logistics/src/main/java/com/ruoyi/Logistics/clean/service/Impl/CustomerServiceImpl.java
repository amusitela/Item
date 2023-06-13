package com.ruoyi.Logistics.clean.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Logistics.clean.mapper.CustomerMapper;
import com.ruoyi.Logistics.clean.domain.Customer;
import com.ruoyi.Logistics.clean.service.ICustomerService;
import com.ruoyi.common.core.text.Convert;

/**
 * CustomerService业务层处理
 * 
 * @author lyw
 * @date 2023-06-12
 */
@Service
public class CustomerServiceImpl implements ICustomerService 
{
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 查询Customer
     * 
     * @param num Customer主键
     * @return Customer
     */
    @Override
    public Customer selectCustomerByNum(String num)
    {
        return customerMapper.selectCustomerByNum(num);
    }

    /**
     * 查询Customer列表
     * 
     * @param customer Customer
     * @return Customer
     */
    @Override
    public List<Customer> selectCustomerList(Customer customer)
    {
        return customerMapper.selectCustomerList(customer);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerMapper.selectAllCustomer();
    }

    /**
     * 新增Customer
     * 
     * @param customer Customer
     * @return 结果
     */
    @Override
    public int insertCustomer(Customer customer)
    {
        return customerMapper.insertCustomer(customer);
    }

    /**
     * 修改Customer
     * 
     * @param customer Customer
     * @return 结果
     */
    @Override
    public int updateCustomer(Customer customer)
    {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public int updateCustomerByNum(String num) {
        return customerMapper.updateCustomerByNum(num);
    }

    /**
     * 批量删除Customer
     * 
     * @param nums 需要删除的Customer主键
     * @return 结果
     */
    @Override
    public int deleteCustomerByNums(String nums)
    {
        return customerMapper.deleteCustomerByNums(Convert.toStrArray(nums));
    }

    /**
     * 删除Customer信息
     * 
     * @param num Customer主键
     * @return 结果
     */
    @Override
    public int deleteCustomerByNum(String num)
    {
        return customerMapper.deleteCustomerByNum(num);
    }
}
