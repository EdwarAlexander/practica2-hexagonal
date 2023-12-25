package com.emoran.infrastructure.controller;

import com.emoran.application.service.FacturaCabeceraService;
import com.emoran.domain.model.FacturaCabeceraModel;
import com.emoran.infrastructure.controller.apidoc.IFacturaCabeceraController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FacturaCabeceraController implements IFacturaCabeceraController {

    private final FacturaCabeceraService facturaCabeceraService;

    @Override
    public ResponseEntity<FacturaCabeceraModel> create(FacturaCabeceraModel facturaCabeceraModelRequest) {
        FacturaCabeceraModel facturaCabeceraModel = facturaCabeceraService.create(facturaCabeceraModelRequest);
        return new ResponseEntity<>(facturaCabeceraModel, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<FacturaCabeceraModel>> getAll() {
        return new ResponseEntity<>(facturaCabeceraService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FacturaCabeceraModel> get(Long facturaId) {
        return facturaCabeceraService.get(facturaId).map(factura-> new ResponseEntity<>(factura,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<FacturaCabeceraModel> update(Long facturaId, FacturaCabeceraModel facturaCabeceraModelRequest) {
        return facturaCabeceraService.update(facturaId, facturaCabeceraModelRequest).map(factura-> new ResponseEntity<>(factura,HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Void> delete(Long facturaId) {
        if(facturaCabeceraService.delete(facturaId)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
