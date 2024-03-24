package lib.biblioteca.services;
import lib.biblioteca.dto.BookRequestDto;
import lib.biblioteca.dto.BookResponseDto;
import lib.biblioteca.entities.Book;
import lib.biblioteca.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book save(BookRequestDto requestDto) {
        Book bookData = new Book(
                requestDto.nome(),
                requestDto.editor()
        );
        return repository.save(bookData);
    }

    public List<Book> findAll() {
        return repository.findAll();
    }
    public Optional<Book> findId(Long id) {
        return repository.findById(id);
    }


    public List<BookResponseDto> getAllBooks() {
        List<Book> books = repository.findAll();

        List<BookResponseDto> bookResponseDtos = new ArrayList<>();

        for (Book book : books) {
            BookResponseDto bookResponseDto = new BookResponseDto(book);
            bookResponseDtos.add(bookResponseDto);
        }

        return bookResponseDtos;
    }
}
