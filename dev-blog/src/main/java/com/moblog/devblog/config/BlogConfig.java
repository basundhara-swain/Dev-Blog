package com.moblog.devblog.config;

import com.moblog.devblog.domain.Blog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class BlogConfig {
    @Bean
// Use to create object inside a method.
    ArrayList<Blog> arrayList() {// dispacherservelet is a forntcontroller by which every request go though is first.After enter in front controller the request go to controller.
        return new ArrayList<>(); 
    }
}
// 3.2.2= 3= major version
//2=minor version
//2=patch upadte only fix the bug