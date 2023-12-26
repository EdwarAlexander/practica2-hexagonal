package com.emoran.domain.ports.in;

import com.emoran.domain.model.FacturaOpeModel;

public interface FacturaOpeIn {

    void createOperacion(FacturaOpeModel facturaOpeModel);
}
