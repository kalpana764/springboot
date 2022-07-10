package com.ss.org.cartService.controller;

import com.ss.org.cartService.common.CustomException;
import com.ss.org.cartService.entity.Cart;
import com.ss.org.cartService.entity.User;
import com.ss.org.cartService.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Log4j2
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        log.info("saveUser :: start");
        Optional.ofNullable(user)
                .orElseThrow(IllegalArgumentException::new);
        log.info("Saving user : {}", user);
        if (Optional.ofNullable(user.getCart()).isPresent()) {
            user.setCart(Cart.builder().withId(UUID.randomUUID().node()).build());
        }
        userRepository.save(user);
        return new ResponseEntity<>("User saved", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody User user, @PathVariable(name = "id") long id) {
        log.info("updateUser :: start");
        Optional.ofNullable(user)
                .orElseThrow(IllegalArgumentException::new);
        log.info("Updating user : {}", user);
        Optional<User> existingUser = userRepository.findById(id);
        existingUser.orElseThrow(IllegalArgumentException::new);
        user.setId(existingUser.get().getId());
        userRepository.save(user);
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") long id) {
        log.info("deleteUser :: start");
        userRepository.deleteById(id);
        return new ResponseEntity<>("User deleted with id" + id, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable(name = "id") long id) {
        log.info("getUser :: start");
        Optional.ofNullable(userRepository.getById(id)).ifPresent((user) -> new ResponseEntity<>(user, HttpStatus.OK));
        throw new CustomException("No user found", 431);
    }

}
