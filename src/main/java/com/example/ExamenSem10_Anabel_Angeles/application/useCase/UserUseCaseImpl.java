package com.example.ExamenSem10_Anabel_Angeles.application.useCase;


import com.example.ExamenSem10_Anabel_Angeles.domain.model.User;
import com.example.ExamenSem10_Anabel_Angeles.domain.ports.in.UserUseCase;
import com.example.ExamenSem10_Anabel_Angeles.domain.ports.out.UserRepositoryPort;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserUseCaseImpl implements UserUseCase {
    private final UserRepositoryPort userRepositoryPort;
    public UserUseCaseImpl(UserRepositoryPort userRepositoryPort){
        this.userRepositoryPort = userRepositoryPort;
    }
    @Override
    public User crearUser(User usuario) {
        return userRepositoryPort.saveUser(usuario);
    }
    @Override
    public Optional<User> getUser(Long id) {
        return Optional.empty();
    }

    @Override
    public String loginWithUser(Map<String, String> requestMap) {
        return userRepositoryPort.loginWithUser(requestMap);
    }

    @Override
    public List<User> findAll() {
        return userRepositoryPort.getAll();
    }

    @Override
    public Optional<User> updateUser(Long id,User user) {
        return userRepositoryPort.updateUser(id,user);
    }

    @Override
    public Optional<User> deleteUser(Long id) {
        return userRepositoryPort.deleteUserById(id);
    }
}
