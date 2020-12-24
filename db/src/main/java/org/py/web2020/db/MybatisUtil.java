package org.py.web2020.db;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;

import javax.sql.DataSource;
import java.sql.Connection;

public final class MybatisUtil {
    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    private Configuration configuration;

    private void init(String id, DataSource ds, TransactionFactory ts) {
        Environment env = new Environment(id, ts, ds);
        configuration = new Configuration(env);
        sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    public static SqlSession openSession(SqlSessionFactory sessionFactory) {
        return sessionFactory.openSession();
    }

    public static SqlSession openSession(SqlSessionFactory sessionFactory, boolean b) {
        return sessionFactory.openSession(b);
    }

    public static SqlSession openSession(SqlSessionFactory sessionFactory, Connection conn) {
        return sessionFactory.openSession(conn);
    }

    public static void close(SqlSession session) {
        session.close();
    }

    public MybatisUtil(String id, DataSource ds, TransactionFactory ts) {
        init(id, ds, ts);
        session = openSession(sessionFactory);
    }

    public void addMappers(String cp) {
        configuration.addMappers(cp);
    }

    public void addMapper(Class<?> type) {
        configuration.addMapper(type);
    }

    public void close() {
        session.close();
    }

    public SqlSession getSession() {
        return session;
    }
}
