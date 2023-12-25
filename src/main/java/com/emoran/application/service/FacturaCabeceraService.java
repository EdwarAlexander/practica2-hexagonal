package com.emoran.application.service;

import com.emoran.domain.model.FacturaCabeceraModel;
import com.emoran.domain.ports.in.FacturaCabeceraIn;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class FacturaCabeceraService implements FacturaCabeceraIn {

    private final FacturaCabeceraIn facturaCabeceraIn;

    @Override
    public FacturaCabeceraModel create(FacturaCabeceraModel request) {
        return facturaCabeceraIn.create(request);
    }

    @Override
    public Optional<FacturaCabeceraModel> update(Long code, FacturaCabeceraModel request) {
        return facturaCabeceraIn.update(code, request);
    }

    @Override
    public List<FacturaCabeceraModel> getAll() {
        return facturaCabeceraIn.getAll();
    }

    @Override
    public Optional<FacturaCabeceraModel> get(Long code) {
        return facturaCabeceraIn.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return facturaCabeceraIn.delete(code);
    }
}
