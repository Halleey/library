package lib.biblioteca.repositories;

import lib.biblioteca.entities.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
