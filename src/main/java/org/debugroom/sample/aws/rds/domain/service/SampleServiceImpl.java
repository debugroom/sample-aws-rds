package org.debugroom.sample.aws.rds.domain.service;

import org.debugroom.sample.aws.rds.domain.model.entity.User;
import org.debugroom.sample.aws.rds.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SampleServiceImpl implements SampleService{

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        if(!userRepository.existsById(user.getUserId())){
            user.setVer(0);
            return userRepository.save(user);
        }
        return null;
    }

}
