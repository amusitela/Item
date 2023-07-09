package com.ruoyi.Logistics.utils;


import com.ruoyi.Logistics.clean.domain.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * @User: Mr.Yang
 * @Date: 2023/6/10
 */
public class SolveCustomerErrorUtil {

    public Integer getCount(List<Customer> customers) {
        return customers.size();
    }

    public List solve(List<Customer> customers) {
        Integer cnt = getCount(customers);
        List<Integer> counts = new ArrayList(cnt+5);
        if (cnt != null) {
            Customer customer = null;
            for (int i = 0; i < cnt; i ++ ) {
                customer = customers.get(i);
                if (!(customer.getNum().matches("^[1-9]\\d{5}(18|19|20)\\d{2}(0\\d|1[0-2])([0-2]\\d|3[0-1])\\d{3}[0-9Xx]$")&&customer.getNum().matches("^1[3456789]\\d{9}$"))) {
                    customer.setError(1);
                }
                counts.add(customer.getError());
            }
        }
        return counts;
    }
}
