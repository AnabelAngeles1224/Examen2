package com.example.ExamenSem10_Anabel_Angeles.infraestructura.entity;


import com.example.ExamenSem10_Anabel_Angeles.domain.model.Person;
import com.example.ExamenSem10_Anabel_Angeles.domain.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "persons")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String email;
    private String telefono;
    private Integer estado;
    private Date fecha_crea;
    private Date fecha_mod;

    public PersonEntity(Long id, String nombre, String apellidos, String direccion, String email, String telefono, Integer estado, Date fecha_crea, Date fecha_mod) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.estado = estado;
        this.fecha_crea = fecha_crea;
        this.fecha_mod = fecha_mod;
    }

    public PersonEntity() {
    }
    public static PersonEntity fromDomainModel(Person person){
        return new PersonEntity(
                person.getId(),
                person.getNombre(),
                person.getApellidos(),
                person.getDireccion(),
                person.getEmail(),
                person.getTelefono(),
                person.getEstado(),
                person.getFecha_crea(),
                person.getFecha_mod()
        );
    }
    public Person toDomainModel(){
        return new Person(id, nombre, apellidos,direccion,
                email, telefono, estado,fecha_crea,fecha_mod);
    }

}
