package com.emoran.infrastructure.repository;

import com.emoran.domain.model.FacturaCabeceraModel;
import com.emoran.domain.ports.out.FacturaCabeceraOut;
import com.emoran.infrastructure.entity.FacturaCabeceraEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class FacturaCabeceraRepositoryAdapter implements FacturaCabeceraOut {

    private final FacturaCabeceraRepository facturaCabeceraRepository;

    @Override
    public FacturaCabeceraModel create(FacturaCabeceraModel request) {
        FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromFacturaCabeceraModel(request);
        return facturaCabeceraRepository.save(facturaCabeceraEntity).fromFacturaCabeceraEntity();
    }

    @Override
    public Optional<FacturaCabeceraModel> update(Long code, FacturaCabeceraModel request) {
        if(facturaCabeceraRepository.existsById(code)){
            request.setId(code);
            FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromFacturaCabeceraModel(request);
            return Optional.of(facturaCabeceraRepository.save(facturaCabeceraEntity).fromFacturaCabeceraEntity());
        }
        return Optional.empty();
    }

    @Override
    public List<FacturaCabeceraModel> getAll() {
        return facturaCabeceraRepository.findAll().stream().map(FacturaCabeceraEntity::fromFacturaCabeceraEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<FacturaCabeceraModel> get(Long code) {
        return facturaCabeceraRepository.findById(code).map(FacturaCabeceraEntity::fromFacturaCabeceraEntity);
    }

    @Override
    public boolean delete(Long code) {
        if(facturaCabeceraRepository.existsById(code)){
            facturaCabeceraRepository.deleteById(code);
            return true;
        }
        return false;
    }
}
