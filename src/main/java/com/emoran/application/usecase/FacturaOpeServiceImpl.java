package com.emoran.application.usecase;

import com.emoran.domain.model.FacturaOpeModel;
import com.emoran.domain.ports.in.FacturaOpeIn;
import com.emoran.domain.ports.out.FacturaOpeOut;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FacturaOpeServiceImpl implements FacturaOpeIn {

    private final FacturaOpeOut facturaOpeOut;

    @Override
    public void createOperacion(FacturaOpeModel facturaOpeModel) {
        facturaOpeOut.createOperacion(facturaOpeModel);
    }
}
