package com.example.simpleoauth2;

import com.example.simpleoauth2.domain.Member;
import com.example.simpleoauth2.service.MemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableResourceServer
@SpringBootApplication
public class SimpleOuath2Application {

    MemberService memberService;

    @RequestMapping("/member")
    public List<Member> all(){
        return memberService.findAll();
    }

    @RequestMapping("/member/{id}")
    public Member get(@PathVariable("id")Long id){
        return memberService.find(id);
    }

    @RequestMapping("/test")
    public String test(){

        return "test";
    }


    public static void main(String[] args) {
        SpringApplication.run(SimpleOuath2Application.class, args);
    }
}
