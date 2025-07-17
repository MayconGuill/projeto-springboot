package com.projectwebservice.project.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Entity idica que esta classe é uma entidade JPA (tabela no BD)
@Table(name = "tb_user") // Table define o nome da tablea no banco como "tb_user"
public class User implements Serializable{ // Serializable permite que objetos dessa classe sejam convertidos em bytes (importante para trafegar dados), necessário emem frameworks como JPA / Hibernate.
    private static final long serialVersionUID = 1L;

    @Id // Id marca a chave primária para o banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue com IDENTITY indica que será gerado automaticamente pelo banco
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore // JsonIgnore é uma anotação da biblioteca Jackson usada para ignorar atributos na serialização JSON - evita loops infinitos em relacionamentos bidirecionais.
    @OneToMany(mappedBy = "client") // OneToMany é uma anotação de relacionamento um-para-muitos entre User e Order, o mappedBy = "client", indica que o atributo client na entidade order é o dono do relacionamento.
    private List<Order> orders = new ArrayList<>();

    // Construtor padrão exigido pelo JPA
    public User() {
    }

    public User(Long id, String name, String email, String phone, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }    
}
