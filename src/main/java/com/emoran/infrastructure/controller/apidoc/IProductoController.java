package com.emoran.infrastructure.controller.apidoc;

import com.emoran.domain.model.ProductoModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos")
public interface IProductoController {

    @Operation(summary = "Metodo para registrar un producto")
    @PostMapping
    public ResponseEntity<ProductoModel> create(@RequestBody ProductoModel productoModelRequest);

    @Operation(summary = "Metodo para listar todos los productos")
    @GetMapping
    public ResponseEntity<List<ProductoModel>> getAll();

    @Operation(summary = "Metodo para obtener un producto")
    @GetMapping("/{producto_id}")
    public ResponseEntity<ProductoModel> get(@PathVariable("producto_id") Long productoId);

    @Operation(summary = "Metodo para actualizar un producto")
    @PutMapping("/{producto_id}")
    public ResponseEntity<ProductoModel> update(@PathVariable("producto_id") Long productoId, @RequestBody ProductoModel productoModelRequest);

    @Operation(summary = "Metodo para eliminar un producto")
    @DeleteMapping("/{producto_id}")
    public ResponseEntity<Void> delete(@PathVariable("producto_id") Long productoId);
}
