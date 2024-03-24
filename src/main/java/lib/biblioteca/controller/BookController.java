package lib.biblioteca.controller;

import lib.biblioteca.dto.BookRequestDto;
import lib.biblioteca.dto.BookResponseDto;
import lib.biblioteca.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {


    private final BookService service;

    public BookController(BookService bookService) {
        this.service = bookService;
    }


    @PostMapping()
    public ResponseEntity<String> saveBook(@RequestBody BookRequestDto requestDto) {
        service.save(requestDto);
        return  ResponseEntity.ok("Livro adicionado com sucesso");
    }
    @GetMapping
    public ResponseEntity<List<BookResponseDto>> allBooks() {
        List<BookResponseDto> books = service.getAllBooks();
        return ResponseEntity.ok(books);
    }

}
