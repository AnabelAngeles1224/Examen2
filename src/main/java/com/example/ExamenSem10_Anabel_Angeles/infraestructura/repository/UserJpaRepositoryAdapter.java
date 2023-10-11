package com.example.ExamenSem10_Anabel_Angeles.infraestructura.repository;

import com.example.ExamenSem10_Anabel_Angeles.domain.model.User;
import com.example.ExamenSem10_Anabel_Angeles.domain.ports.out.UserRepositoryPort;
import com.example.ExamenSem10_Anabel_Angeles.infraestructura.entity.PersonEntity;
import com.example.ExamenSem10_Anabel_Angeles.infraestructura.entity.UserEntity;
import com.example.ExamenSem10_Anabel_Angeles.infraestructura.security.CustomerDetailService;
import com.example.ExamenSem10_Anabel_Angeles.infraestructura.security.Jwt.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserJpaRepositoryAdapter implements UserRepositoryPort {
    private final UserJpaRepository userJpaRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomerDetailService customerDetailService;

    public UserJpaRepositoryAdapter(UserJpaRepository userJpaRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomerDetailService customerDetailService) {
        this.userJpaRepository = userJpaRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.customerDetailService = customerDetailService;
    }
    @Override
    public User saveUser(User user) {
        user.setFecha_crea(new Date());
        UserEntity userEntity = UserEntity.fromDomainModel(user);
        UserEntity saveUserEntity = userJpaRepository.save(userEntity);
        return saveUserEntity.toDomainModel();
    }
    @Override
    public Optional<User> findUserId(Long id) {
        return Optional.empty();
    }

    @Override
    public String loginWithUser(Map<String, String> requestMap) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("usuario"), requestMap.get("password")));
            if(authentication.isAuthenticated()){
                    String token_generado = jwtUtil.generateToken(
                        customerDetailService.getUserDetail().getUsuario(),
                        customerDetailService.getUserDetail().getPassword()
                );
                return token_generado;
            }

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<UserEntity> lista = userJpaRepository.findAll();
        List<User> listaFinal = new ArrayList<>();
        for(UserEntity userEntity : lista){
            listaFinal.add(userEntity.toDomainModel());
        }
        return listaFinal;
    }

    @Override
    public Optional<User> updateUser(Long id,User user) {
        if (userJpaRepository.existsById(id)){
            user.setId(id);
            user.setFecha_mod(new Date());
            UserEntity userEntity= UserEntity.fromDomainModel(user);
            UserEntity updateUserEntity = userJpaRepository.save(userEntity);
            return Optional.of(updateUserEntity.toDomainModel());
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> deleteUserById(Long id) {

        Optional<UserEntity> userEntityOptional = userJpaRepository.findById(id);

        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            userEntity.setEstado(0);
            UserEntity updateUserEntity = userJpaRepository.save(userEntity);
            return Optional.of(updateUserEntity.toDomainModel());
        }

        return Optional.empty();

    }
}