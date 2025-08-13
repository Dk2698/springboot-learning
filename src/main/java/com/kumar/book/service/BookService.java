package com.kumar.book.service;

import com.kumar.book.exception.ResourceNotFoundException;
import com.kumar.book.model.Book;
import com.kumar.book.repository.BookRepository;
import com.kumar.book.service.dto.BookDTO;
import com.kumar.book.service.mapper.BookMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookDTO createBook(BookDTO dto) {
        Book saved = bookRepository.save(bookMapper.toEntity(dto));
        return bookMapper.toDto(saved);
    }

    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        return bookMapper.toDto(book);
    }

    public List<BookDTO> getAllBooks() {
        return bookMapper.toDtoList(bookRepository.findAll());
    }

    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        bookRepository.delete(book);
    }

    public BookDTO updateBook(Long id, BookDTO dto) {
        Book existing = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
//        existing.setTitle(dto.getTitle());
//        existing.setAuthor(dto.getAuthor());
//        existing.setDescription(dto.getDescription());
        bookMapper.updateBookFromDto(dto, existing);
        return bookMapper.toDto(bookRepository.save(existing));
    }
}
