package com.projectwebservice.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectwebservice.project.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
}
