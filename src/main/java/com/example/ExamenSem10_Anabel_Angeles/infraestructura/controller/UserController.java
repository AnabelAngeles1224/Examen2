package com.example.ExamenSem10_Anabel_Angeles.infraestructura.controller;

import com.example.ExamenSem10_Anabel_Angeles.application.service.UserService;
import com.example.ExamenSem10_Anabel_Angeles.domain.model.Person;
import com.example.ExamenSem10_Anabel_Angeles.domain.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService usuarioService) {
        this.userService = usuarioService;
    }
    @PostMapping("/signup")
    public void createUser(@RequestBody(required = true) User user){
        userService.crearUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody(required = true) Map<String, String> requestMap){
        return userService.loginWithUser(requestMap);
    }
    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.findAll();
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUserById(
            @PathVariable Long userId,
            @RequestBody User user
    ){
        return userService.updateUser(userId,user)
                .map(persona1 -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/delete/{userId}")
    public ResponseEntity<User> deleteUserById(@PathVariable Long userId){
        return userService.deleteUser(userId)
                .map(user1 -> new ResponseEntity<>(user1,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
