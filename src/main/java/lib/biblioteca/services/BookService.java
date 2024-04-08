package lib.biblioteca.services;
import lib.biblioteca.dto.BookRequestDto;
import lib.biblioteca.dto.BookResponseDto;
import lib.biblioteca.entities.Book;
import lib.biblioteca.entities.Genero;
import lib.biblioteca.repositories.BookRepository;
import lib.biblioteca.repositories.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;
    private final GeneroRepository generoRepository;
    public BookService(BookRepository repository, GeneroRepository generoRepository)
    {
        this.generoRepository = generoRepository;
        this.repository = repository;
    }

    public Book save(BookRequestDto requestDto, Long generoId) {
        Genero genero = generoRepository.findById(generoId)
                .orElseThrow(() -> new IllegalArgumentException("Gênero não encontrado"));

        Book bookData = new Book();
        bookData.setNome(requestDto.nome());
        bookData.setEditor(requestDto.editor());
        bookData.setGenero(genero);

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
