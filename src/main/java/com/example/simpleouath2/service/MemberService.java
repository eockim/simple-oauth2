package com.example.simpleouath2.service;

import com.example.simpleouath2.domain.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class MemberService {

    public List<Member> findAll() {

        return new ArrayList<Member>();
    }

    public Member find(Long id) {

        return new Member();
    }
}
