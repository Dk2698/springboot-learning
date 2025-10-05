package com.kumar.book.repository;

import com.kumar.book.model.Book;
import com.kumar.book.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
