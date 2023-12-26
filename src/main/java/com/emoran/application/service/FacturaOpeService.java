package com.emoran.application.service;

import com.emoran.domain.model.FacturaOpeModel;
import com.emoran.domain.ports.in.FacturaOpeIn;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FacturaOpeService implements FacturaOpeIn {

    private final FacturaOpeIn facturaOpeIn;

    @Override
    public void createOperacion(FacturaOpeModel facturaOpeModel) {
         facturaOpeIn.createOperacion(facturaOpeModel);
    }
}
