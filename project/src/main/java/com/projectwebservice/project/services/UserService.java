package com.projectwebservice.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projectwebservice.project.entities.User;
import com.projectwebservice.project.repositories.UserRepository;
import com.projectwebservice.project.services.exceptions.DatabaseException;
import com.projectwebservice.project.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service // Indica que esta classe é um componente de serviço do Spring. O Spring gerencia sua criação e permite a injeção de dependências em outros lugares.
public class UserService {

    @Autowired // Injeta automaticamente uma instância da interface UserRepository, que estende JpaRepository. Assim, sendo possível usar os métodos prontos do Spring Data JPA, como findAll, save, deleteById, etc.
    private UserRepository repository;

    public List<User> findAll() { // Retorna todos os usuários do banco de dados.
        return repository.findAll();
    }

    public User findById(Long id) { // Busca um usuário pelo id.
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // Retorna o usuário, ou lança uma exceção personalizada (ResourceNotFoundException) se não for encontrado. 
    }

    public User insert(User obj) { // Insere um novo usuário no banco de dados.
        return repository.save(obj);
    }

    public void delete(Long id) { 
        try {
            repository.deleteById(id); // Tenta deletar um usuário pelo id.
        } catch (EmptyResultDataAccessException e) { // Se o ID não existir, lança ResourceNotFoundException.
            e.printStackTrace(); // imprime no console a sequência de chamadas de métodos (stack trace) que levou à exceção.
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) { // Se houver violação de integridade (por exemplo, o usuário tem pedidos vinculados), lança DatabaseException.
            e.printStackTrace();
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj) {
        try {
            User entity = repository.getReferenceById(id); // getReferenceById(id) é usado para obter uma referência preguiçosa (sem consultar o banco de imediato).
            updateData(entity, obj); // Atualiza os dados de um usuário.
            return repository.save(entity);
        } catch (EntityNotFoundException e) { // Se o ID não for encontrado, lança ResourceNotFoundException.
            e.getStackTrace();
            throw new ResourceNotFoundException(id);
        }
    }
        
    private void updateData(User entity, User obj) {
         entity.setName(obj.getName());
         entity.setEmail(obj.getEmail());   
         entity.setPhone(obj.getPhone());
    }
}
