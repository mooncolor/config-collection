package com.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.springframework.boot.SpringApplication.run;

/**
 * Created by 孟旭 on 17/1/17.
 */

@ComponentScan(basePackages ="")
@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "")
@ServletComponentScan(basePackages = "")
public class CkbgddyxtApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = run(CkbgddyxtApplication.class, args);
    }

}
