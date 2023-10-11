package com.example.ExamenSem10_Anabel_Angeles.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    private Long id;
    private String usuario;
    private String password;
    private Integer estado;
    private Date fecha_crea;
    private Date fecha_mod;

    public User(Long id, String usuario, String password, Integer estado, Date fecha_crea,Date fecha_mod) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.fecha_crea = fecha_crea;
        this.fecha_mod = fecha_mod;
    }
}
