package com.emoran.application.service;

import com.emoran.domain.model.FacturaDetalleModel;
import com.emoran.domain.ports.in.FacturaDetalleIn;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class FacturaDetalleService implements FacturaDetalleIn {

    private final FacturaDetalleIn facturaDetalleIn;

    @Override
    public FacturaDetalleModel create(FacturaDetalleModel request) {
        return facturaDetalleIn.create(request);
    }

    @Override
    public Optional<FacturaDetalleModel> update(Long code, FacturaDetalleModel request) {
        return facturaDetalleIn.update(code, request);
    }

    @Override
    public List<FacturaDetalleModel> getAll() {
        return facturaDetalleIn.getAll();
    }

    @Override
    public Optional<FacturaDetalleModel> get(Long code) {
        return facturaDetalleIn.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return facturaDetalleIn.delete(code);
    }
}
