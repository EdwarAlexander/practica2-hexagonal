package com.emoran.infrastructure.controller;

import com.emoran.application.service.FacturaOpeService;
import com.emoran.domain.model.FacturaOpeModel;
import com.emoran.infrastructure.controller.apidoc.IFacturaOpeController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FacturaOpeController implements IFacturaOpeController {

    private final FacturaOpeService facturaOpeService;

    @Override
    public ResponseEntity<Void> create(FacturaOpeModel facturaOpeModelRequest) {
        facturaOpeService.createOperacion(facturaOpeModelRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
