package com.projectwebservice.project.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projectwebservice.project.entities.User;
import com.projectwebservice.project.services.UserService;

@RestController // @RestController: indica que essa classe é um controlador REST, que responde com dados JSON.
@RequestMapping(value = "/users") // @RequestMapping("/users"): define o caminho base para todos os endpoints dessa classe (ex: http://localhost:8080/users).
public class UserResource {

    @Autowired // Injeta o serviço UserService para usar a lógica de negócio e acesso a dados.
    private UserService service;

    @GetMapping // Mapeia requisição GET em /users.
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list); // Retorna todos os usuários dentro de um ResponseEntity com status HTTP 200 (OK).
    }

    @GetMapping(value = "/{id}") // Mapeia GET /users/{id}, onde {id} é variável da URL.
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj); // Busca usuário pelo ID, retorna status 200 e o objeto no corpo.
    }

    @PostMapping // Mapeia requisição POST em /users.
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = service.insert(obj); 
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); // Cria um novo usuário com os dados recebidos no corpo da requisição (@RequestBody).
        return ResponseEntity.created(uri).body(obj); // Gera a URI do novo recurso criado (/users/{id}) e retorna status HTTP 201 (Created).
    }

    @DeleteMapping(value = "/{id}") // Mapeia requisição DELETE em /users/{id}.
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build(); // Retorna status 204 (No Content), que indica que a operação foi realizada, mas não há conteúdo para retornar.
    }

    @PutMapping(value = "/{id}") // Mapeia requisição PUT em /users/{id}.
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = service.update(id, obj); // Atualiza o usuário com base no ID e nos novos dados passados no corpo.
        return ResponseEntity.ok().body(obj); // Retorna o usuário atualizado com status 200 (OK).
    }
}
