package com.techfrog.hexagonal.domain;

import java.math.BigDecimal;
import java.util.*;

public class Order {

    private UUID id;
    private OrderStatus status;
    private List<OrderItem> orderItems;
    private BigDecimal price;

    public Order(final UUID id, final Product product) {
        this.id = id;
        this.orderItems = new ArrayList<>(Collections.singleton(new OrderItem(product)));
        this.status = OrderStatus.CREATED;
        this.price = product.getPrice();
    }

    public void complete() {
        validateState();
        this.status = OrderStatus.COMPLETED;
    }

    public void addOrder(final Product product) {
        validateState();
        validateProduct(product);
        orderItems.add(new OrderItem(product));
        price = price.add(product.getPrice());
    }

    public void removeOrder(final UUID id) {
        validateState();
        final OrderItem orderItem = getOrderItem(id);
        orderItems.remove(orderItem);
        price  = price.subtract(orderItem.getPrice());
    }

    private OrderItem getOrderItem(final UUID id) {
        return orderItems.stream()
                .filter(orderItem -> orderItem.getProductId().equals(id))
                .findFirst()
                .orElseThrow(() -> new DomainException("Product with id " + id + " doesn't exist"));
    }


    private void validateProduct(final Product product) {
        if(product == null) {
            throw new DomainException("The product cannot be null.");
        }
    }

    private void validateState() {
        if(OrderStatus.COMPLETED.equals(status)){
            throw new DomainException("The order is in completed state.");
        }
    }

    public UUID getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id) &&
                status.equals(order.status) &&
                orderItems.equals(order.orderItems) &&
                price.equals(order.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, orderItems, price);
    }

    private Order(){}
}