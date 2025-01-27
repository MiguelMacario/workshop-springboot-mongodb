package com.miguelmacario.workshopmongo.resources;

import com.miguelmacario.workshopmongo.domain.User;
import com.miguelmacario.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll (){
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }
}
