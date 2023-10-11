package com.example.ExamenSem10_Anabel_Angeles.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Person {
    private Long id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private Integer estado;
    private Date fecha_crea;
    private Date fecha_mod;

    public Person(Long id, String nombre, String apellidos,String direccion, String email,
                  String telefono, Integer estado, Date fecha_crea,Date fecha_mod) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.estado= estado;
        this.fecha_crea = fecha_crea;
        this.fecha_mod = fecha_mod;
    }
}
