package com;

import com.qunar.dao.IUserDao;
import com.qunar.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author yang
 * 2021年01月26日 17:43:00
 */
public class MybatisTest {
    public static void main(String[] args)throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //4.使用 SqlSessionFactory 生产 SqlSession 对象
        SqlSession session = factory.openSession();
        //5.使用 SqlSession 创建 dao 接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = new User("a",12,33F);
        int i = userDao.saveUser(user);
        System.out.println(user.getId());
        //6.使用代理对象执行查询所有方法
//        List<User> users = userDao.findAll();
//        for(User user : users) {
//            System.out.println(user);
//        }
        //7.释放资源
        //session.commit();
        session.close();
        in.close();
    }
}
