package com.emoran.application.usecase;

import com.emoran.domain.model.FacturaDetalleModel;
import com.emoran.domain.ports.in.FacturaDetalleIn;
import com.emoran.domain.ports.out.FacturaDetalleOut;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class FacturaDetalleServiceImpl implements FacturaDetalleIn {

    private final FacturaDetalleOut facturaDetalleOut;

    @Override
    public FacturaDetalleModel create(FacturaDetalleModel request) {
        return facturaDetalleOut.create(request);
    }

    @Override
    public Optional<FacturaDetalleModel> update(Long code, FacturaDetalleModel request) {
        return facturaDetalleOut.update(code, request);
    }

    @Override
    public List<FacturaDetalleModel> getAll() {
        return facturaDetalleOut.getAll();
    }

    @Override
    public Optional<FacturaDetalleModel> get(Long code) {
        return facturaDetalleOut.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return facturaDetalleOut.delete(code);
    }
}
