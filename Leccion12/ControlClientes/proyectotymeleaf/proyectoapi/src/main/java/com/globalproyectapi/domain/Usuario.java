package com.globalproyectapi.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idUsuario;

    @NotEmpty
    public String username;

    @NotEmpty
    public String password;

    @OneToMany()
    @JoinColumn(name = "id_usuario")
    public List<Rol> roles;
}
