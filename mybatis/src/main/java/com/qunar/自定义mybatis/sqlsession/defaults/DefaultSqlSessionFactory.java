package com.qunar.自定义mybatis.sqlsession.defaults;


import com.qunar.自定义mybatis.cfg.Configuration;
import com.qunar.自定义mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public DefaultSqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
