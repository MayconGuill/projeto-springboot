package com.projectwebservice.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectwebservice.project.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{ // JpaRepository, O Spring Data cria automaticamente uma implementação para essa interface, permitindo operações CRUD (Create, Read, Update, Delete) na entidade User. O primeiro parâmetro <User> indica qual entidade será manipulada. O segundo parâmetro <Long> indica o tipo do identificador único (id) da entidade.
}
