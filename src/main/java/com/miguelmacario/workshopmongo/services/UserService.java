package com.miguelmacario.workshopmongo.services;

import com.miguelmacario.workshopmongo.domain.User;
import com.miguelmacario.workshopmongo.repository.UserRepository;
import com.miguelmacario.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto nao econtrado"));
    }

}
