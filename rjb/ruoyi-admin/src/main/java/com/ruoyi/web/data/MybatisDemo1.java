package com.ruoyi.web.data;

import com.ruoyi.mapper.CustomerMapper;
import com.ruoyi.domain.Customer;
import com.ruoyi.utils.SolveCustomerErrorUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 李易蔚
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class MybatisDemo1 {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis核心配置文件，获取SqlSessionFactory
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.selectAll();

        for (int i = 0; i < 5; i ++ ) System.out.println(customers.get(i));

        SolveCustomerErrorUtil solveErrorUtil = new SolveCustomerErrorUtil();

        Integer cnt = solveErrorUtil.getCount(customers);
        List counts = solveErrorUtil.solve(customers);
        Customer customer = null;
        for (int i = 0; i < cnt; i ++ ) {
            customer = customers.get(i);
            customer.setError((Integer) counts.get(i));
            System.out.println(customer.getError());
            if(customer.getError() == 1) mapper.update(customer);
        }
        customers = mapper.selectAll();

        for (int i = 0; i < 5; i ++ ) System.out.println(customers.get(i));

        sqlSession.commit();
        sqlSession.close();




    }

}
