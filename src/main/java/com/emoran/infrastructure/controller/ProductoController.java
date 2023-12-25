package com.emoran.infrastructure.controller;

import com.emoran.application.service.ProductoService;
import com.emoran.domain.model.ProductoModel;
import com.emoran.infrastructure.controller.apidoc.IProductoController;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductoController implements IProductoController {

    private final ProductoService productoService;

    @Override
    public ResponseEntity<ProductoModel> create(ProductoModel productoModelRequest) {
        ProductoModel productoModel = productoService.create(productoModelRequest);
        return new ResponseEntity<>(productoModel, HttpStatus.CREATED);
    }
}
