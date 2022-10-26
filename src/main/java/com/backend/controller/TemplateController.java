package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.exception.UserNotFoundException;
import com.backend.model.TemplateModel;
import com.backend.repository.TemplateRepository;

@RestController
@CrossOrigin("https://mytestsbox.com/")
public class TemplateController {

    @Autowired
    private TemplateRepository templateRepository;

    @PostMapping("/user")
    TemplateModel newUser(@RequestBody TemplateModel newUser) {
        return templateRepository.save(newUser);
    }

    @GetMapping("/users")
    List<TemplateModel> getAllUsers() {
        return templateRepository.findAll();
    }

    @GetMapping("/user/{id}")
    TemplateModel getUserById(@PathVariable String id) {
        return templateRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

    }

    @PutMapping("/user/{id}")
    TemplateModel updateUser(@RequestBody TemplateModel newUser, @PathVariable String id) {
        return templateRepository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return templateRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable String id) {
        if (!templateRepository.existsById(id)) {
            throw new UserNotFoundException(id);
        }
        templateRepository.deleteById(id);
        return "User with id: " + id + " has been deleted successfully";
    }

    @GetMapping("/test")
    public String test() {
        return "Hello";
    }
}
