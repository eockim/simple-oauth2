package com.example.simpleouath2;

import com.example.simpleouath2.domain.Member;
import com.example.simpleouath2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@EnableResourceServer
@SpringBootApplication
public class SimpleOuath2Application {

    @Autowired
    MemberService memberService;

    @RequestMapping("/member")
    public List<Member> all(){
        return memberService.findAll();
    }

    @RequestMapping("/member/{id}")
    public Member get(@PathVariable("id")Long id){
        return memberService.find(id);
    }


    public static void main(String[] args) {
        SpringApplication.run(SimpleOuath2Application.class, args);
    }
}
