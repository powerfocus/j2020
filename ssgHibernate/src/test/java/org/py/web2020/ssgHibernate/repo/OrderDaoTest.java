package org.py.web2020.ssgHibernate.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.web2020.ssgHibernate.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    public void testSave() {
        Order order = Order.builder()
                .orderName("java编程思想")
                .build();
        orderDao.save(order);
    }
}