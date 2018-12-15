package com.example.demo.service;


import org.springframework.stereotype.Service;

@Service
public class BossService {

    public Boss getInstance(){
        Boss boss = new Boss();
        boss.setAge(20);
        boss.setName("jiang");
        boss.setNickName("jiu");
        return boss;
    }

}
