package com.emoran.infrastructure.repository;

import com.emoran.domain.model.FacturaDetalleModel;
import com.emoran.domain.ports.out.FacturaDetalleOut;
import com.emoran.infrastructure.entity.FacturaDetalleEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FacturaDetalleRepositoryAdapter implements FacturaDetalleOut {

    private final FacturaDetalleRepository facturaDetalleRepository;

    @Override
    public FacturaDetalleModel create(FacturaDetalleModel request) {
        FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromFacturaDetalleModel(request);
        return facturaDetalleRepository.save(facturaDetalleEntity).fromFacturaDetalleEntity();
    }

    @Override
    public Optional<FacturaDetalleModel> update(Long code, FacturaDetalleModel request) {
        if(facturaDetalleRepository.existsById(code)){
            request.setId(code);
            FacturaDetalleEntity facturaDetalleEntity = FacturaDetalleEntity.fromFacturaDetalleModel(request);
            return Optional.of(facturaDetalleRepository.save(facturaDetalleEntity).fromFacturaDetalleEntity());
        }
        return Optional.empty();
    }

    @Override
    public List<FacturaDetalleModel> getAll() {
        return facturaDetalleRepository.findAll().stream().map(FacturaDetalleEntity::fromFacturaDetalleEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<FacturaDetalleModel> get(Long code) {
        return facturaDetalleRepository.findById(code).map(FacturaDetalleEntity::fromFacturaDetalleEntity);
    }

    @Override
    public boolean delete(Long code) {
        if(facturaDetalleRepository.existsById(code)){
            facturaDetalleRepository.deleteById(code);
            return true;
        }
        return false;
    }
}
