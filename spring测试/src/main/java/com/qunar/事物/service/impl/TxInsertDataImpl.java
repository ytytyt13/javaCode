package com.qunar.事物.service.impl;

import com.qunar.事物.dao.TxUserDao;
import com.qunar.事物.domain.TxUser;
import com.qunar.事物.service.TxInsertData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @author yang
 * 2021年01月07日 17:41:00
 */
@Service
public class TxInsertDataImpl implements TxInsertData {


    @Autowired
    private TxUserDao txUserDao;


    @Override
    public void insertData(TxUser user) {
        txUserDao.insertUser(user);
    }

    @Override
    public List<TxUser> selectUser() {
        return txUserDao.selectUser();
    }

    @Override
    public void lessMoney(String name, Float money) {
        txUserDao.lessMoney(name,money);
    }

    @Override
    public void addMoney(String name, Float money) {
        txUserDao.addMoney(name,money);
    }



    @Override
    @Transactional
    public void convert(String fromName, String toName, Float money) {

        try {
            txUserDao.lessMoney(fromName, money);
            int i= 1/0;
            txUserDao.addMoney(toName, money);
        }catch (Exception e) {
            System.out.println("convert error");
        }
    }
}
