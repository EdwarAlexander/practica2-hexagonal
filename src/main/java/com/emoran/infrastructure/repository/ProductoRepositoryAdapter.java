package com.emoran.infrastructure.repository;

import com.emoran.domain.model.ProductoModel;
import com.emoran.domain.ports.out.ProductoOut;
import com.emoran.infrastructure.entity.ProductoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        if(productoRepository.existsById(code)){
            request.setId(code);
            ProductoEntity productoEntity = ProductoEntity.fromProductoModel(request);
            return Optional.of(productoRepository.save(productoEntity).fromProductoEntity());
        }
        return Optional.empty();
    }

    @Override
    public List<ProductoModel> getAll() {
        return productoRepository.findAll().stream().map(ProductoEntity::fromProductoEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductoModel> get(Long code) {
        return productoRepository.findById(code).map(ProductoEntity::fromProductoEntity);
    }

    @Override
    public boolean delete(Long code) {
        if(productoRepository.existsById(code)){
            productoRepository.deleteById(code);
            return true;
        }
        return false;
    }
}
