package com.xp.exe.helloWorldTest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:coderXp
 * Description:
 * Date:Create in 2018/5/11 10:58
 * Modified By:
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/hello")
    public String sayHello(String name){
        return "hello :" + name;
    }
}
