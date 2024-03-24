package lib.biblioteca.dto;

import lib.biblioteca.entities.Book;

public record BookResponseDto (Long id, String nome, String editor){

    public BookResponseDto(Book book) {
       this(book.getId(), book.getNome(), book.getEditor());
    }

}
