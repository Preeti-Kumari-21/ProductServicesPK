package com.scaler.productservicespk.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {

    /*
    * http://localhost:8080/sample/hello
    * */
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello Preeti";
    }

    /*
    * http://localhost:8080/sample/hello/preeti
    * http://localhost:8080/sample/hello/kp
    * http://localhost:8080/sample/hello/vasu
    * */
    @GetMapping("/hello/{name}")
    public String sayHelloName(@PathVariable("name") String name){
    return "Hello " + name;
    }

    @GetMapping("/hello/{name}/{numberOfTimes}")
    public String sayHelloUserTimes(@PathVariable("name") String name,@PathVariable("numberOfTimes") int numberOfTimes){
        String response = "";
        for(int i=0;i<numberOfTimes;i++){
            String s = "Hello " + name + "<br>";
            response += s;
        }
        return response;
    }
}
