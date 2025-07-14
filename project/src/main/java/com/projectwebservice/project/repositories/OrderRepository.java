package com.projectwebservice.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectwebservice.project.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
}
