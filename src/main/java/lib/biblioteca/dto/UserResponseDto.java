package lib.biblioteca.dto;

import lib.biblioteca.entities.User;

public record UserResponseDto(Long id, String nome, String email, String password, String role) {

    public UserResponseDto(User user) {
        this(user.getId(),user.getNome(), user.getEmail(), user.getPassword(), user.getRoles().toString());
    }
}
