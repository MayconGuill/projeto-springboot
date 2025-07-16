package com.projectwebservice.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectwebservice.project.entities.OrderItem;
import com.projectwebservice.project.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
