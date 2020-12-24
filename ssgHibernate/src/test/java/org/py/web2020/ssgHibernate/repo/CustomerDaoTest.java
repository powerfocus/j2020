package org.py.web2020.ssgHibernate.repo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.py.web2020.ssgHibernate.entity.Customer;
import org.py.web2020.ssgHibernate.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private OrderDao orderDao;

    @Test
    public void test() {

    }

    @Test
    public void testSave() {
        Customer zs = Customer.builder()
                .customerName("张三")
                .build();
        /*Order order1 = Order.builder()
                .orderName("java编程思想")
                .build();

        Order order2 = Order.builder()
                .orderName("c++编程思想")
                .build();*/

        customerDao.save(zs);
        /*orderDao.save(order1);
        orderDao.save(order2);*/

    }
}