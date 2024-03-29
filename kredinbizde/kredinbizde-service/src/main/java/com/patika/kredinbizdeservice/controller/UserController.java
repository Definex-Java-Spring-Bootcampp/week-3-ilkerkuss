package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.dto.request.SaveUserRequest;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.producer.enums.NotificationType;
import com.patika.kredinbizdeservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    /* @Autowired*/
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody SaveUserRequest userRequest) {
        System.out.println("userService: " + userService.hashCode());
        return userService.save(userRequest.getUser(),userRequest.getNotificationType());
    }


    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable String email) {

        return userService.getByEmail(email);
    }

    @GetMapping("/id/{userId}")
    public User getByUserId(@PathVariable Long userId) {

        return userService.getById(userId);
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> update(@PathVariable String email, @RequestBody User user) {

        User user1 = userService.update(email, user);

        if (user1 != null) {
            return ResponseEntity.ok().body(user1);
        }

        return ResponseEntity.notFound().build();
    }


   /* @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }*/
}
