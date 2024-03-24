package lib.biblioteca.entities;
import jakarta.persistence.*;
import lib.biblioteca.enuns.RoleUser;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;
    @Setter
    @Getter
    @ElementCollection(targetClass = RoleUser.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    private Set<RoleUser> roles;

    public User(String nome, String email, String password, Set<RoleUser> roles) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
    public User() {

    }
}
