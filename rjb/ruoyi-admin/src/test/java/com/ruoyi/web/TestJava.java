package com.ruoyi.web;


import com.ruoyi.Logistics.clean.domain.Customer;
import com.ruoyi.Logistics.clean.domain.UserContainer;
import com.ruoyi.Logistics.clean.service.impl.CustomerServiceImpl;
import com.ruoyi.Logistics.utils.SolveCustomerErrorUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
@SpringBootTest
public class TestJava {

    @Test
    public void testID(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);
        System.out.println(date);

    }
    }

