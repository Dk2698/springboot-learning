package com.kumar.book.service.transaction;

import com.kumar.book.model.Order;
import com.kumar.book.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void placeOrder(Order order){
        orderRepository.save(order);

        // transaction rollback and Order is not saved
        if (order.getQuantity() > 100){
            throw new RuntimeException("Quality too large");
        }
        // code below won't run
        System.out.println("Order placed: "+ order.getProduct());
    }
}
