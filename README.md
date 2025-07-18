# Projeto Spring Boot - API REST de Usuários
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/MayconGuill/projeto-springboot/blob/main/LICENSE)

# Sobre o projeto
Este projeto é uma aplicação back-end construída com Spring Boot, que disponibiliza uma API REST para gerenciamento de usuários. 
Foi desenvolvido com o objetivo de aprendizado e prática dos principais conceitos de Java, Spring Boot, JPA, tratamento de exceções, e boas práticas de desenvolvimento.

## 🛠 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (banco de dados em memória)
- Maven

## 📌 Funcionalidades

- Listar todos os usuários (GET `/users`)
- Buscar um usuário por ID (GET `/users/{id}`)
- Inserir novo usuário (POST `/users`)
- Atualizar um usuário existente (PUT `/users/{id}`)
- Deletar um usuário (DELETE `/users/{id}`)

## 🔐 Tratamento de Erros

A API possui tratamento centralizado de erros utilizando `@ControllerAdvice`. As seguintes exceções são tratadas:

- `ResourceNotFoundException` → Retorna **404 Not Found**
- `DatabaseException` → Retorna **400 Bad Request**

## 🧪 Testes manuais

Você pode testar a API utilizando ferramentas como:
- [Postman](https://www.postman.com/)
- [Insomnia](https://insomnia.rest/)

```bash
# clonar repositório
git clone https://github.com/MayconGuill/projeto-springboot.git

# entrar na pasta do projeto back end
cd projeto-springboot

# executar o projeto
./mvnw spring-boot:run

# acesso ao banco H2:
http://localhost:8080/h2-console
(JDBC URL: jdbc:h2:mem:testdb, usuário: sa, senha em branco)
```

# Autor

Maycon Vieira Guill Rodrigues
https://www.linkedin.com/in/maycon-vieira-350b19304/
