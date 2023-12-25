package com.emoran.infrastructure.controller;

import com.emoran.application.service.FacturaDetalleService;
import com.emoran.domain.model.FacturaDetalleModel;
import com.emoran.infrastructure.controller.apidoc.IFacturaDetalleController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class FacturaDetalleController implements IFacturaDetalleController {

    private final FacturaDetalleService facturaDetalleService;

    @Override
    public ResponseEntity<FacturaDetalleModel> create(FacturaDetalleModel facturaDetalleModelRequest) {
        FacturaDetalleModel facturaDetalleModel = facturaDetalleService.create(facturaDetalleModelRequest);
        return new ResponseEntity<>(facturaDetalleModel, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<FacturaDetalleModel>> getAll() {
        return new ResponseEntity<>(facturaDetalleService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FacturaDetalleModel> get(Long detalleId) {
        return facturaDetalleService.get(detalleId).map(detalle-> new ResponseEntity<>(detalle, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<FacturaDetalleModel> update(Long detalleId, FacturaDetalleModel facturaDetalleModelRequest) {
        return facturaDetalleService.update(detalleId, facturaDetalleModelRequest).map(detalle-> new ResponseEntity<>(detalle, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Void> delete(Long detalleId) {
        if(facturaDetalleService.delete(detalleId)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
