package com.qunar.dao;

import com.qunar.domain.Account;
import com.qunar.domain.User;

import java.util.List;

/**
 * @author yang
 * 2021年01月29日 13:17:00
 */
public interface IAccountDao {

    /**
     * 批量插入账户
     * @param accountList
     * @return
     */
    public int insertAccountList(List<Account> accountList);

    /**
     *一对一查询
     */
    public List<User> findOneByOne();

    /**
     * 一对多查询
     * @return
     */
    public List<User> findOneByMore();
}
