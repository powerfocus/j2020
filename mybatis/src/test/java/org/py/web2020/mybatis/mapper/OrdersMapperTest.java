package org.py.web2020.mybatis.mapper;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.web2020.mybatis.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersMapperTest {
    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void testInsert() {
        Orders order = new Orders(null, null, "java编程思想");
        int insert = ordersMapper.insert(order);
        TestCase.assertEquals(1, insert);
    }
}