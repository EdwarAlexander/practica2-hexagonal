package com.emoran.infrastructure.repository;

import com.emoran.domain.model.ProductoModel;
import com.emoran.domain.ports.out.ProductoOut;
import com.emoran.infrastructure.entity.ProductoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ProductoRepositoryAdapter implements ProductoOut {

    private final ProductoRepository productoRepository;

    @Override
    public ProductoModel create(ProductoModel request) {
        ProductoEntity productoEntity = ProductoEntity.fromProductoModel(request);
        return productoRepository.save(productoEntity).fromProductoEntity();
    }

    @Override
    public Optional<ProductoModel> update(Long code, ProductoModel request) {
        return Optional.empty();
    }

    @Override
    public List<ProductoModel> getAll() {
        return null;
    }

    @Override
    public Optional<ProductoModel> get(Long code) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long code) {
        return false;
    }
}
