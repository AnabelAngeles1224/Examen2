package com.example.ExamenSem10_Anabel_Angeles.domain.ports.out;

import com.example.ExamenSem10_Anabel_Angeles.domain.model.User;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepositoryPort {
    User saveUser(User usuario);

    Optional<User> findUserId(Long id);

    String loginWithUser(Map<String, String> requestMap);

    List<User> getAll();

    Optional<User> updateUser(Long id,User user);

    Optional<User> deleteUserById(Long id);
}