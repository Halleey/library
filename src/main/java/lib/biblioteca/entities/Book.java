package lib.biblioteca.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "livros")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String editor;
    @OneToOne(mappedBy = "book")
    private User user;
    public Book() {

    }

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    public Book(String nome, String editor, Genero genero) {
        this.nome = nome;
        this.editor = editor;
        this.genero = genero;
    }


}
