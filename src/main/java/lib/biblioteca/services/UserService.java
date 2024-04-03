package lib.biblioteca.services;

import lib.biblioteca.dto.UserRequestDto;
import lib.biblioteca.entities.User;

import lib.biblioteca.enuns.RoleUser;
import lib.biblioteca.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(UserRequestDto requestDto) {
        String cripted = passwordEncoder.encode(requestDto.password());
        Set<RoleUser> roles = new HashSet<>();

        // Para cada role no array de roles no UserRequestDto, convertemos para RoleUser e adicionamos ao Set
        for (String roleString : requestDto.roles()) {
            roles.add(convertToRole(roleString));
        }

        User userData = new User(
                requestDto.nome(),
                requestDto.email(),
                cripted,
                roles
        );
        return repository.save(userData);
    }

    private RoleUser convertToRole(String roleString) {
        if (roleString == null) {
            throw new IllegalArgumentException("Role não pode ser nula");
        }

        // Converte a String de role para um enum RoleUser
        RoleUser roleUser;
        switch (roleString) {
            case "ROLE_USER":
                roleUser = RoleUser.ROLE_USER;
                break;
            case "ROLE_BIBLIOTECARIO":
                roleUser = RoleUser.ROLE_BIBLIOTECARIO;
                break;
            default:
                throw new IllegalArgumentException("Role desconhecida: " + roleString);
        }
        return roleUser;
    }
}