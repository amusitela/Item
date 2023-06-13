package com.ruoyi.mapper;

import com.ruoyi.domain.Customer;

import java.util.List;

/**
 * @User: Mr.Yang
 * @Date: 2023/6/10
 */
public interface CustomerMapper {

    List<Customer> selectAll();

    public int update(Customer customer);

}
