package com.ruoyi.web;


import com.ruoyi.Logistics.clean.domain.Customer;
import com.ruoyi.Logistics.clean.service.impl.CustomerServiceImpl;
import com.ruoyi.Logistics.utils.SolveCustomerErrorUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
@SpringBootTest
public class TestJava {

    @Autowired
    private CustomerServiceImpl customerService;

    @Test
    public void testID(){

            //查询所有的用户
            List<Customer> customers = customerService.selectAllCustomer();

            for (int i = 0; i < 5; i ++ ) System.out.println(customers.get(i));

            //工具类，正则表达式判断数据是否异常
            SolveCustomerErrorUtil solveErrorUtil = new SolveCustomerErrorUtil();

            Integer cnt = solveErrorUtil.getCount(customers);
            List counts = solveErrorUtil.solve(customers);
            Customer customer = null;

            //检查异常数据，并修改标记为异常
            for (int i = 0; i < cnt; i ++ ) {
                customer = customers.get(i);
                customer.setError((Integer) counts.get(i));
                System.out.println(customer.getError());
                if(customer.getError() == 1) customerService.updateCustomer(customer);
            }

            customers = customerService.selectAllCustomer();

            for (int i = 0; i < 5; i ++ ) System.out.println(customers.get(i));


        }
    }

