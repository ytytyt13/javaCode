package com.qunar.事物;

import com.qunar.事物.domain.TxUser;
import com.qunar.事物.service.TxInsertData;
import com.qunar.事物.service.impl.TxInsertDataImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yang
 * 2020年12月29日 14:55:00
 */
public class Demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TxInsertData txInsertData = (TxInsertData) applicationContext.getBean("txInsertDataImpl");
        System.out.println(txInsertData);
        //TxUser user = new TxUser("张三",1,1000F);
        //txInsertData.insertData(user);

        //txInsertData.lessMoney("小明",200F);
        //txInsertData.addMoney("张三",200F);

        txInsertData.convert("张三","小明",100F);
        txInsertData.selectUser();
    }
}
