package org.py.web2020.db.dao;

import com.alibaba.druid.pool.DruidDataSource;
import junit.framework.TestCase;
import lombok.extern.java.Log;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.py.web2020.db.model.UOrder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log
public class UOrderDaoTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    @Before
    public void before() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/web2020?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=true");
        dataSource.setUsername("py");
        dataSource.setPassword("123");

        TransactionFactory transactionFactory =
                new JdbcTransactionFactory();
        Environment environment =
                new Environment("dev", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMappers("org.py.web2020.db.dao");
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(configuration);
        session = sqlSessionFactory.openSession();
    }

    @After
    public void after() {
        session.close();
    }

    @Test
    public void test() {
        TestCase.assertNotNull(sqlSessionFactory);
    }

    @Test
    public void select() {
        UOrderDao mapper = session.getMapper(UOrderDao.class);
        UOrder uOrder = mapper.selectByPrimaryKey(1L);
        System.out.println(uOrder);
    }

    @Test
    public void insert() {
        UOrderDao mapper = session.getMapper(UOrderDao.class);
        Map<String, BigDecimal> books = new HashMap<>() {{
            put("java编程思想", BigDecimal.valueOf(128.0));
            put("c++ primer", BigDecimal.valueOf(99.8));
            put("go程序设计语言", BigDecimal.valueOf(79.0));
        }};
        books.forEach((k, v) -> {
            mapper.insert(UOrder.builder()
                    .title(k)
                    .uid(1)
                    .price(v)
                    .build());
        });
    }

    @Test
    public void delete() {
        UOrderDao mapper = session.getMapper(UOrderDao.class);
        mapper.deleteByPrimaryKey(1);
    }

    @Test
    public void findByUid() {
        UOrderDao mapper = session.getMapper(UOrderDao.class);
        List<UOrder> list = mapper.findByUid(1);
        list.forEach(System.out::println);
    }
}