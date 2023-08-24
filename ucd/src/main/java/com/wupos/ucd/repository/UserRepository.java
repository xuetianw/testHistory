package com.wupos.ucd.repository;

import com.wupos.ucd.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByPcp(Long pcp);
}
