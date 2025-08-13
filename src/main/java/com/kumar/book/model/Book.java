package com.kumar.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
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
