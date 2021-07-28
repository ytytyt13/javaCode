package com.qunar.dao;

import com.qunar.domain.AliasUser;
import com.qunar.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 插入一个用户
     * @param user
     * @return
     */
    int saveUser(User user);

    /**
     * 查找一个用户
     * @param id
     * @return
     */
    User findOne(int id);

    /**
     * 删除一个用户
     * @param id
     * @return
     */
    int deleteOne(int id);


    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);


    /**
     * 聚合查询
     * @return
     */
    int countUser();


    /**
     * 传递多个参数
     * @return
     */
    int 多个参数传递_方法1(Map paraMap);
    int 多个参数传递_方法2(@Param("name111")String name, @Param("age")Integer age, @Param("salary")Float salary);

    /**
     * 通过resultMap对返回结果进行映射
     * @return
     */
    List<AliasUser> findAllAliasUser();


    /**
     * 通过动态sql拼装查询语句
     * @param user
     * @return
     */
    List<User> findByUser(User user);

    /**
     * 通过ids查找用户
     * @param userIds
     * @return
     */
    List<User> findByIds(List<String> userIds);

    /**
     * 批量插入
     */
    int insertUserList(List<User> userList);

}
