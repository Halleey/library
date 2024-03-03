package lib.biblioteca.entities;
import jakarta.persistence.*;
@Entity
@Table(name = "livros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToOne(mappedBy = "book")
    private User user;
}
