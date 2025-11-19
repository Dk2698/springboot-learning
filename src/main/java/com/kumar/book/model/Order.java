package com.kumar.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "orders")
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
