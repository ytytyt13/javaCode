package com.qunar.自定义mybatis.sqlsession;


import com.qunar.自定义mybatis.cfg.Configuration;
import com.qunar.自定义mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.qunar.自定义mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 *  用于创建一个SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public DefaultSqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return  new DefaultSqlSessionFactory(cfg);
    }
}
