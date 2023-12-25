package com.emoran.application.usecase;

import com.emoran.domain.model.FacturaCabeceraModel;
import com.emoran.domain.ports.in.FacturaCabeceraIn;
import com.emoran.domain.ports.out.FacturaCabeceraOut;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class FacturaCabeceraServiceImpl implements FacturaCabeceraIn {

    private final FacturaCabeceraOut facturaCabeceraOut;

    @Override
    public FacturaCabeceraModel create(FacturaCabeceraModel request) {
        return facturaCabeceraOut.create(request);
    }

    @Override
    public Optional<FacturaCabeceraModel> update(Long code, FacturaCabeceraModel request) {
        return facturaCabeceraOut.update(code, request);
    }

    @Override
    public List<FacturaCabeceraModel> getAll() {
        return facturaCabeceraOut.getAll();
    }

    @Override
    public Optional<FacturaCabeceraModel> get(Long code) {
        return facturaCabeceraOut.get(code);
    }

    @Override
    public boolean delete(Long code) {
        return facturaCabeceraOut.delete(code);
    }
}
