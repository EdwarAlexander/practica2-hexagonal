package com.emoran.application.usecase;

import com.emoran.domain.model.ProductoModel;
import com.emoran.domain.ports.in.ProductoIn;
import com.emoran.domain.ports.out.ProductoOut;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ProductoServiceImpl implements ProductoIn {

    private final ProductoOut productoOut;

    @Override
    public ProductoModel create(ProductoModel request) {
        return productoOut.create(request);
    }

    @Override
    public Optional<ProductoModel> update(Long code, ProductoModel request) {
        return productoOut.update(code, request);
    }

    @Override
    public List<ProductoModel> getAll() {
        return productoOut.getAll();
    }

    @Override
    public Optional<ProductoModel> get(Long code) {
        return productoOut.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return productoOut.delete(code);
    }
}
