package com.emoran.application.service;

import com.emoran.domain.model.ProductoModel;
import com.emoran.domain.ports.in.ProductoIn;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductoService implements ProductoIn {

    private final ProductoIn productoIn;

    @Override
    public ProductoModel create(ProductoModel request) {
        return productoIn.create(request);
    }

    @Override
    public Optional<ProductoModel> update(Long code, ProductoModel request) {
        return productoIn.update(code, request);
    }

    @Override
    public List<ProductoModel> getAll() {
        return productoIn.getAll();
    }

    @Override
    public Optional<ProductoModel> get(Long code) {
        return productoIn.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return productoIn.delete(code);
    }
}
