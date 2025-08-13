package com.kumar.book.controller;

import com.kumar.book.service.BookService;
import com.kumar.book.service.dto.BookDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO dto ){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(dto));
    }

    @GetMapping()
    public List<BookDTO> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @Valid @RequestBody BookDTO dto){
        return ResponseEntity.ok(bookService.updateBook(id, dto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
