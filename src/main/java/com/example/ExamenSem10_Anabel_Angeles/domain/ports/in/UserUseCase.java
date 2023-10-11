package com.example.ExamenSem10_Anabel_Angeles.domain.ports.in;

import com.example.ExamenSem10_Anabel_Angeles.domain.model.Person;
import com.example.ExamenSem10_Anabel_Angeles.domain.model.User;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserUseCase {
    User crearUser(User user);
    Optional<User> getUser(Long id);
    String loginWithUser(Map<String, String> requestMap);
    List<User> findAll();
    Optional<User> updateUser(Long id,User user);
    Optional<User> deleteUser(Long id);
}
