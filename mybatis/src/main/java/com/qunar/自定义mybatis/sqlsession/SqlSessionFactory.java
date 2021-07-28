package com.qunar.自定义mybatis.sqlsession;

import com.qunar.自定义mybatis.sqlsession.defaults.DefaultSqlSession;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    DefaultSqlSession openSession();
}
