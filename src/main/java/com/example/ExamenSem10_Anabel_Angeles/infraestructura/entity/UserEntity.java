package com.example.ExamenSem10_Anabel_Angeles.infraestructura.entity;

import com.example.ExamenSem10_Anabel_Angeles.domain.model.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String password;
    private Integer estado;
    private Date fecha_crea;
    private Date fecha_mod;

    public UserEntity(Long id, String usuario, String password, Integer estado, Date fecha_crea, Date fecha_mod) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
        this.fecha_crea = fecha_crea;
        this.fecha_mod = fecha_mod;
    }

    public UserEntity() {
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public static UserEntity fromDomainModel(User user){
        return new UserEntity(
                user.getId(),
                user.getUsuario(),
                user.getPassword(),
                user.getEstado(),
                user.getFecha_crea(),
                user.getFecha_mod()
                );
    }
    public User toDomainModel(){
        return new User(id, usuario, password, estado, fecha_crea,fecha_mod);
    }
}
