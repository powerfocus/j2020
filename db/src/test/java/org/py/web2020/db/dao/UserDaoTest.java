package org.py.web2020.db.dao;

import com.alibaba.druid.pool.DruidDataSource;
import junit.framework.TestCase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.py.web2020.db.MybatisUtil;
import org.py.web2020.db.model.User;

import java.util.List;


public class UserDaoTest {
    private MybatisUtil util;

    @Before
    public void before() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/web2020?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=true");
        ds.setUsername("py");
        ds.setPassword("123");
        util = new MybatisUtil("dev", ds, new JdbcTransactionFactory());
        util.addMappers("org.py.web2020.db.dao");
    }
    @After
    public void after() {
        util.close();
    }
    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        User user = User.builder()
                .userName("张三")
                .userPassword("123")
                .build();

        SqlSession session = util.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        int insert = mapper.insert(user);
        TestCase.assertEquals(1, insert);
    }

    @Test
    public void selectByPrimaryKey() {
        SqlSession session = util.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        User user = mapper.selectByPrimaryKey(1);
        TestCase.assertEquals(1, (long)user.getId());
        System.out.println(user);
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void findAndOrder() {
        SqlSession session = util.getSession();
        UserDao mapper = session.getMapper(UserDao.class);
        List<User> users = mapper.findAndOrder(1);
        users.forEach(u -> {
            u.getOrders().forEach(System.out::println);
            System.out.println("--------------------");
        });
    }
}