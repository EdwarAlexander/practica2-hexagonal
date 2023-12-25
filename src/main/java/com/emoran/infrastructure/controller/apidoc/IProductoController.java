package com.emoran.infrastructure.controller.apidoc;

import com.emoran.domain.model.ProductoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public interface IProductoController {

    @PostMapping
    public ResponseEntity<ProductoModel> create(@RequestBody ProductoModel productoModelRequest);
}
