package lib.biblioteca.services;
import lib.biblioteca.entities.Book;
import lib.biblioteca.repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepository repository;

    public Book save(Book book) {
        return repository.save(book);
    }
    public List<Book> findAll() {
        return repository.findAll();
    }
    public Optional<Book> findId(Long id) {
        return repository.findById(id);
    }
 }
