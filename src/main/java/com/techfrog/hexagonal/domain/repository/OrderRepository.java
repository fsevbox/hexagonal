package com.techfrog.hexagonal.domain.repository;

import com.techfrog.hexagonal.domain.Order;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository {

    Optional<Order> findById(UUID id);
    void save(Order order);
}
