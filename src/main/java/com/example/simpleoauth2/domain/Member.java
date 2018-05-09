package com.example.simpleoauth2.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Member implements Serializable {

    @Id
    @GeneratedValue
    Long id;
    String name;
    String userName;
    String remark;

    public Member(){}

    public Member(String name, String userName, String remark){
        this.name = name;
        this.userName = userName;
        this.remark = remark;
    }

}
