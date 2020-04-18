package com.techfrog.hexagonal.application.rest;

import java.util.UUID;

public class CreateOrderResponse {

    private final UUID id;

    public CreateOrderResponse(final UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
