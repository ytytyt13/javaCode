package com.qunar.事物.dao;

import com.qunar.事物.domain.TxUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TxUserDao {
    int insertUser(TxUser user);
    List<TxUser> selectUser();

    void lessMoney(@Param("name") String name, @Param("money") Float money);
    void addMoney(@Param("name") String name,@Param("money") Float money);
}
