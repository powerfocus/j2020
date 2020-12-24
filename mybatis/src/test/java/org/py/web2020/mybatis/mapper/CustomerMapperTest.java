package org.py.web2020.mybatis.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.web2020.mybatis.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerMapperTest {
    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void insertTest() {
        Customer customer = new Customer(null, "张三");
        customerMapper.insert(customer);
    }

    @Test
    public void selectTest() {
        List<Customer> customers = customerMapper.selectList(new QueryWrapper<>());
        customers.forEach(System.out::println);
    }

    @Test
    public void selectPageTest() {
        int pageIndex = 1;
        int pageSize = 20;
        Page<Customer> pages = customerMapper.selectPage(new Page<>(pageIndex, pageSize), new QueryWrapper<>());
        pages.getRecords().forEach(System.out::println);
    }
}