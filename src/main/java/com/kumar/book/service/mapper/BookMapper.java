package com.kumar.book.service.mapper;

import com.kumar.book.model.Book;
import com.kumar.book.service.dto.BookDTO;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO toDto(Book book);

    Book toEntity(BookDTO bookDTO);

    List<BookDTO> toDtoList(List<Book> book);

    List<Book> toEntityList(List<BookDTO> bookDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateBookFromDto(BookDTO dto, @MappingTarget Book entity);
}
