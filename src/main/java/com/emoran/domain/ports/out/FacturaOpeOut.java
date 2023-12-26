package com.emoran.domain.ports.out;

import com.emoran.domain.model.FacturaOpeModel;

public interface FacturaOpeOut {

    void createOperacion(FacturaOpeModel facturaOpeModel);
}
