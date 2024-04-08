package lib.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "genero")
@Getter
@Setter
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String genero;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    private List<Book> livros;
}

