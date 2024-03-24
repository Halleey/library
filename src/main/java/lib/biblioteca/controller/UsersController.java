package lib.biblioteca.controller;

import lib.biblioteca.dto.UserRequestDto;
import lib.biblioteca.entities.User;
import lib.biblioteca.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto requestDto) {
        userService.saveUser(requestDto);
        return ResponseEntity.ok("save user ");

    }
}
