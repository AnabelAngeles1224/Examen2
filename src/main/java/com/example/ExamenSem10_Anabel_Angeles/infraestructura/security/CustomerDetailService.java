package com.example.ExamenSem10_Anabel_Angeles.infraestructura.security;

import com.example.ExamenSem10_Anabel_Angeles.infraestructura.entity.UserEntity;
import com.example.ExamenSem10_Anabel_Angeles.infraestructura.repository.UserJpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
@Service
public class CustomerDetailService implements UserDetailsService {
    private final UserJpaRepository userJpaRepository;
    private UserEntity userDetail;
    public CustomerDetailService(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userDetail = userJpaRepository.findByUsuario(username);
        if(!Objects.isNull(userDetail)){
            return new User(userDetail.getUsuario(), userDetail.getPassword(), new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("User not found");
        }
    }
    public UserEntity getUserDetail() {
        return userDetail;
    }
}
