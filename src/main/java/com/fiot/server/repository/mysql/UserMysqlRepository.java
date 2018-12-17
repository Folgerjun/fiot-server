package com.fiot.server.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiot.server.entity.mysql.User;

public interface UserMysqlRepository extends JpaRepository<User, String> {

	User findByName(String name);
}
