package com.emoran.infrastructure.controller.apidoc;

import com.emoran.domain.model.ProductoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public interface IProductoController {

    @PostMapping
    public ResponseEntity<ProductoModel> create(@RequestBody ProductoModel productoModelRequest);

    @GetMapping
    public ResponseEntity<List<ProductoModel>> getAll();

    @GetMapping("/{producto_id}")
    public ResponseEntity<ProductoModel> get(@PathVariable("producto_id") Long productoId);

    @PutMapping("/{producto_id}")
    public ResponseEntity<ProductoModel> update(@PathVariable("producto_id") Long productoId, @RequestBody ProductoModel productoModelRequest);

    @DeleteMapping("/{producto_id}")
    public ResponseEntity<Void> delete(@PathVariable("producto_id") Long productoId);
}
