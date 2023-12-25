package com.emoran.infrastructure.controller;

import com.emoran.application.service.ProductoService;
import com.emoran.domain.model.ProductoModel;
import com.emoran.infrastructure.controller.apidoc.IProductoController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductoController implements IProductoController {

    private final ProductoService productoService;

    @Override
    public ResponseEntity<ProductoModel> create(ProductoModel productoModelRequest) {
        ProductoModel productoModel = productoService.create(productoModelRequest);
        return new ResponseEntity<>(productoModel, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ProductoModel>> getAll() {
        return new ResponseEntity<>(productoService.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductoModel> get(Long productoId) {
        return productoService.get(productoId).map(producto-> new ResponseEntity<>(producto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<ProductoModel> update(Long productoId, ProductoModel productoModelRequest) {
        return productoService.update(productoId, productoModelRequest).map(producto-> new ResponseEntity<>(producto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Void> delete(Long productoId) {
        if(productoService.delete(productoId)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
