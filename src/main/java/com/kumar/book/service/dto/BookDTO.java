package com.kumar.book.service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BookDTO {

    private Long id;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @NotBlank(message = "Title is required")
    @Size(min = 2, message = "Title must be at east 2 characters")
    private String title;
    private String description;
    private String isbn;
    private String anotherAuthor;
}
