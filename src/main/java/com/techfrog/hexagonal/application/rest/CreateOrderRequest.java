package com.techfrog.hexagonal.application.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.techfrog.hexagonal.domain.Product;

import javax.validation.constraints.NotNull;

public class CreateOrderRequest {

    @NotNull
    private Product product;

    @JsonCreator
    public CreateOrderRequest(@NotNull final Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

}
