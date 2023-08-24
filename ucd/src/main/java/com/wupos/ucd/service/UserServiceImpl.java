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
    public long addOrUpdateUser(User user) {
        User savedUser = userRepository.findByPcp(user.getPcp());
        long pcp;

        if (savedUser != null) {
            savedUser.setName(user.getName());
            savedUser.setAddress(user.getAddress());
            savedUser.setCompliance(user.getCompliance());
            pcp = 0;
        } else {
            savedUser = user;
            pcp = savedUser.getPcp();
        }
        userRepository.save(savedUser);
        complianceRepository.save(user.getCompliance());
        return pcp;
    }
}
