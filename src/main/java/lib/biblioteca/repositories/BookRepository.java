package lib.biblioteca.repositories;

import lib.biblioteca.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface BookRepository extends JpaRepository<Book, Long> {


}
