package com.projectwebservice.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectwebservice.project.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
