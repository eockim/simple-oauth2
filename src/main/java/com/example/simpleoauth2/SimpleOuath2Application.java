package com.example.simpleoauth2;

import com.example.simpleoauth2.domain.Member;
import com.example.simpleoauth2.service.MemberService;
import com.example.simpleoauth2.service.OauthUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SpringBootApplication
@Slf4j
public class SimpleOuath2Application {

    @Autowired
    MemberService memberService;

    @Autowired
    OauthUserDetailService oauthUserDetailService;

    @Autowired
    static PasswordEncoder passwordEncoder;

//    @RequestMapping("/member")
//    public List<Member> all(){
//        return memberService.findAll();
//    }
//
//    @RequestMapping("/member/{id}")
//    public Member get(@PathVariable("id")Long id){
//        return memberService.find(id);
//    }

    @GetMapping("/test")
    public String getTest(){

        return "get test";
    }

    @PostMapping("/test")
    public String postTest(){

        //oauthUserDetailService.loadUserByUsername("user").getPassword();
        log.info("password {}" , oauthUserDetailService.loadUserByUsername("user").getPassword());
        return "post test";
    }


    public static void main(String[] args) {
        SpringApplication.run(SimpleOuath2Application.class, args);
        System.out.println(passwordEncoder.encode("test"));
    }
}
