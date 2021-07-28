package com.qunar;

import com.qunar.dao.IUserDao;
import com.qunar.domain.User;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yang
 * 2021年01月27日 11:14:00
 */
public class MybastisCRUDTest {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;

    @Before//在测试方法执行之前执行
    public void init()throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.创建 SqlSession 工厂对象
        factory = builder.build(in);
        //4.创建 SqlSession 对象
        session = factory.openSession();
        //5.创建 Dao 的代理对象
        userDao = session.getMapper(IUserDao.class);

    }

    @Test
    public void testSave() {
        User 小明 = new User("小虎", 12, 1000F);
        int count = userDao.saveUser(小明);
        System.out.println(count);
    }

    @Test
    public void findAll() {
        List<User> all = userDao.findAll();
        all.stream().forEach(System.out::println);
    }

    @Test
    public void findOne() {
        System.out.println(userDao.findOne(1));
    }

    @Test
    public void delete() {
        userDao.deleteOne(3);
        System.out.println(userDao.findAll());
    }

    @Test
    public void findByName() {
        String name = "%三%";
        System.out.println(userDao.findByName(name));
    }

    @Test
    public void count() {
        System.out.println(userDao.countUser());
    }

    @Test
    public void 多个参数传递_方法1() {
        Map<String,Object> paraMap =new HashMap<>();
        paraMap.put("name","小红");
        paraMap.put("age",13);
        paraMap.put("salary",10.00011);
        userDao.多个参数传递_方法1(paraMap);
    }

    @Test
    public void 多个参数传递_方法2() {
        userDao.多个参数传递_方法2("小刘",23,0.0023F);
    }

    @Test
    public void resultMap的使用() {
        userDao.findAllAliasUser().stream().forEach(System.out::println);
    }

    @Test
    public void mybatis事物的控制() {
        try {
            Map<String, Object> paraMap = new HashMap<>();
            paraMap.put("name", "小王");
            paraMap.put("age", 15);
            paraMap.put("salary", 10.00011);
            userDao.多个参数传递_方法1(paraMap);
            //int i=1/0;
            session.commit();
        }catch (Exception e) {
            session.rollback();
        }finally {
            session.close();
        }
    }



    @After//在测试方法执行完成之后执行
    public void destroy() throws Exception{
        session.commit();
        //7.释放资源
        session.close();
        in.close();
    }

}
