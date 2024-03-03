package lib.biblioteca.services;

import lib.biblioteca.entities.User;

import lib.biblioteca.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User user) {
        if (repository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists");
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}