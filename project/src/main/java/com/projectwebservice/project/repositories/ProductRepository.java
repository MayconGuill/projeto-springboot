package com.projectwebservice.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectwebservice.project.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
