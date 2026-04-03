package org.example.week_2.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AppStartupService implements BeanNameAware {
    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("tên của bean là: "+ name);
    }
    @PostConstruct
    public void init(){
        String currentTime = String.valueOf(LocalDateTime.now());
        System.out.println("Application initialized at: "+currentTime);
    }
    @PreDestroy
    public void destroy(){
        String currentTime = String.valueOf(LocalDateTime.now());
        System.out.println("Application shutting down at: "+currentTime);
    }
}
