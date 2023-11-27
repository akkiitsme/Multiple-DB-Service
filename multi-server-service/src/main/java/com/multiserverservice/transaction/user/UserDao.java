package com.multiserverservice.transaction.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<PanelistBean,Integer> {
    PanelistBean findByPanelistId(int panelistId);
}
