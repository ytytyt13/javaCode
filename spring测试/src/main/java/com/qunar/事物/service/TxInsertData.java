package com.qunar.事物.service;

import com.qunar.事物.domain.TxUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface TxInsertData {
    void insertData(TxUser user);
    List<TxUser> selectUser();

    void lessMoney(String name,Float money);
    void addMoney(String name,Float money);

    void convert(String fromName,String toName,Float money);
}
