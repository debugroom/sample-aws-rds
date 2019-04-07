package org.debugroom.sample.aws.rds.config;

import lombok.extern.slf4j.Slf4j;
import org.debugroom.sample.aws.rds.domain.model.entity.User;
import org.debugroom.sample.aws.rds.domain.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Slf4j
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);

        SampleService sampleService = context.getBean(SampleService.class);
        sampleService.deleteAll();

        User user1 = User.builder()
                .userId("0")
                .userName("Test0")
                .loginId("Test0")
                .build();

        User user2 = User.builder()
                .userId("1")
                .userName("Test1")
                .loginId("Test1")
                .build();

        sampleService.saveUser(user1);
        sampleService.saveUser(user2);

        List<User> users = sampleService.findAll();

        users.stream().forEach(user -> log.info(user.getUserName()));


    }



}
