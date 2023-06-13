package com.ruoyi.Logistics.clean.service;

import com.ruoyi.Logistics.clean.domain.Customer;

import java.util.List;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public interface CustomerService {

    public int update(Customer customer);

    public List<Customer> selectAll();

}
