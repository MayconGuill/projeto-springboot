package com.projectwebservice.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectwebservice.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
