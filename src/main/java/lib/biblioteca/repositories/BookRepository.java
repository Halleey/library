package lib.biblioteca.repositories;

import lib.biblioteca.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository<Book, Long> {


}
