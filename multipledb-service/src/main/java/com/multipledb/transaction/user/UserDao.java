package com.multipledb.transaction.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<UserBean,Integer> {
    UserBean findByUserId(int userId);
}
