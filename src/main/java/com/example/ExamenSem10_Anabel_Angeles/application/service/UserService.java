package com.example.ExamenSem10_Anabel_Angeles.application.service;


import com.example.ExamenSem10_Anabel_Angeles.domain.model.User;
import com.example.ExamenSem10_Anabel_Angeles.domain.ports.in.UserUseCase;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserService implements UserUseCase {
    private final UserUseCase userUseCase; // usuarioUseCaseImpl

    public UserService(UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @Override
    public User crearUser(User usuario) {
        return userUseCase.crearUser(usuario); // id persona, usuario
    }
    @Override
    public Optional<User> getUser(Long id) {
        return Optional.empty();
    }

    @Override
    public String loginWithUser(Map<String, String> requestMap) {
        return userUseCase.loginWithUser(requestMap);
    }
    @Override
    public List<User> findAll() {
        return userUseCase.findAll();
    }

    @Override
    public Optional<User> updateUser(Long id,User user) {
        return userUseCase.updateUser(id,user);
    }

    @Override
    public Optional<User> deleteUser(Long id) {
        return userUseCase.deleteUser(id);
    }
}
