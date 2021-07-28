package com.qunar;

/**
 * @author yang
 * 2021年01月27日 21:41:00
 */
import com.qunar.dao.IAccountDao;
import com.qunar.dao.IUserDao;
import com.qunar.domain.Account;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yang
 * 2021年01月27日 11:14:00
 */
public class 动态sql {

    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IUserDao userDao;
    private IAccountDao accountDao;

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
        accountDao = session.getMapper(IAccountDao.class);
    }

    @Test
    public void 动态sql() {
        User user = new User("小虎", 12, 1000F);
        System.out.println(userDao.findByUser(user));
    }

    @Test
    public void findByids() {
        List<String> userIds = new ArrayList<>(Arrays.asList("1","2","3","4"));
        System.out.println(userDao.findByIds(userIds));
    }

    @Test
    public void 批量插入() {
        List<User> userlList = new ArrayList<>();
        User a = new User("小明", 13, 1000F);
        User b = new User("小红", 14, 1000F);
        User c = new User("小华", 15, 1000F);
        userlList.add(a);
        userlList.add(b);
        userlList.add(c);
        userDao.insertUserList(userlList);
    }

    @Test
    public void 批量插入账户() {
        List<Account> accountList = new ArrayList<>();
        Account a1 = new Account(4,12000F);
        Account a2 = new Account(4,13000F);
        Account a3 = new Account(5,14000F);
        accountList.add(a1);
        accountList.add(a2);
        accountList.add(a3);
        accountDao.insertAccountList(accountList);
    }

    @Test
    public void 多表一对一查询() {
        List<User> all = accountDao.findOneByOne();
        all.stream().forEach(System.out::println);
    }

    @Test
    public void 多表一对多查询() {
        List<User> oneByMore = accountDao.findOneByMore();
        oneByMore.stream().forEach(System.out::println);
    }


    @After//在测试方法执行完成之后执行
    public void destroy() throws Exception{
        session.commit();
        //7.释放资源
        session.close();
        in.close();
    }

}
