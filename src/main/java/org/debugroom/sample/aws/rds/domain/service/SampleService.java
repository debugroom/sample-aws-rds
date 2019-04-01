package org.debugroom.sample.aws.rds.domain.service;

import org.debugroom.sample.aws.rds.domain.model.entity.User;

import java.util.List;

public interface SampleService {

    public List<User> findAll();
    public User saveUser(User user);
    public void deleteAll();

}
