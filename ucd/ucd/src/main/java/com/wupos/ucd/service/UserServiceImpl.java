package com.wupos.ucd.service;

import com.wupos.ucd.entity.*;
import com.wupos.ucd.repository.ComplianceRepository;
import com.wupos.ucd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ComplianceRepository complianceRepository;

    @Override
    public String addUser(User user) {
        User savedUser = userRepository.save(user);
        complianceRepository.save(user.getCompliance());
        return User.PREFIX + User.df.format(savedUser.getPcp());
    }
}
