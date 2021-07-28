package com.qunar.controller;

import com.qunar.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 * @author yang
 * 2021年02月23日 18:14:00
 */
@Controller
@RequestMapping(path = "/test")
@ResponseBody
public class HelloController {


    @ModelAttribute
    public void testModelAttribute(String id) {
        System.out.println(id);
    }

//    @ModelAttribute
//    public User returnUser(String name){
//        System.out.println(name);
//        User user = new User();
//        user.setName("zhangsan");
//        user.setAge(13);
//        System.out.println(user);
//
//        return user;
//    }

    @RequestMapping(path="/user")
    public User getUser(User user) {
        System.out.println(user);
        return user;
    }

    @RequestMapping(path="/hello")
    public String sayHello(String name){
        System.out.println("hello springMVC");
        System.out.println("name:"+ name);
        return "success";
    }
    @RequestMapping(path = "/testRequestMapping")
    public String testRequestMapping(@RequestBody(required = false)String body){
        System.out.println("测试RequeMapping注解");
        System.out.println(body);
        return "success";
    }

    @RequestMapping(path = "/testDate")
    public String testDate(@RequestParam(value = "date")Date date){
        System.out.println("测试类型转换器");
        System.out.println(date);
        return "success";
    }

    @RequestMapping(path = "/testVariable/{id}/{path}")
    public String testVariable(@PathVariable("id")Integer id, @PathVariable("path") String path){
        System.out.println(id);
        System.out.println(path);
        return "success";
    }

    @RequestMapping(value = "/getSuggestInfo", method=RequestMethod.POST)
    public String getSuggestInfo(@RequestBody Map<String,Object> param,
                                      HttpServletRequest request, HttpServletResponse response){
        param.get("b");
        return "success";
    }
}
