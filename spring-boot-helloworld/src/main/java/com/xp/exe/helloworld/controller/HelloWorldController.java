package com.xp.exe.helloworld.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/3/7 19:39
 * Modified By:
 */
@RestController     //@RestController相当于是@controller+@responseBody注解
public class HelloWorldController {

    @RequestMapping("/sayHello/{name}")     //使用@PathVariable注解来绑定路径参数
    public String sayHello(@PathVariable("name") String name){
        return "hello !"+name;
    }
}
