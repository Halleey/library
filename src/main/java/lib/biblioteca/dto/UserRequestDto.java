package lib.biblioteca.dto;

import java.util.List;

public record UserRequestDto(String nome, String email, String password, List<String> roles) {
}
