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
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Author is mandatory")
    private String author;

    @NotBlank(message = "Product is required")
    private String product;
    private int quantity;
}
