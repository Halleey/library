package lib.biblioteca.dto;

import java.util.List;

public record UserRequestDto(String name, String email, String password, List<String> roles) {
}
