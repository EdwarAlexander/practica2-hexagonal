package com.emoran.infrastructure.controller.apidoc;

import com.emoran.domain.model.FacturaCabeceraModel;
import com.emoran.domain.model.FacturaDetalleModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturadetalle")
@Tag(name = "Detalle de Factura")
public interface IFacturaDetalleController {

    @Operation(summary = "Metodo para registrar un detalle de factura")
    @PostMapping
    public ResponseEntity<FacturaDetalleModel> create(@RequestBody FacturaDetalleModel facturaDetalleModelRequest);

    @Operation(summary = "Metodo para listar todos los detalles de facturas")
    @GetMapping
    public ResponseEntity<List<FacturaDetalleModel>> getAll();

    @Operation(summary = "Metodo para obtener un detalle factura")
    @GetMapping("/{detalle_id}")
    public ResponseEntity<FacturaDetalleModel> get(@PathVariable("detalle_id") Long detalleId);

    @Operation(summary = "Metodo para actualizar un detalle factura")
    @PutMapping("/{detalle_id}")
    public ResponseEntity<FacturaDetalleModel> update(@PathVariable("detalle_id") Long detalleId, @RequestBody FacturaDetalleModel facturaDetalleModelRequest);

    @Operation(summary = "Metodo para eliminar un detalle factura")
    @DeleteMapping("/{detalle_id}")
    public ResponseEntity<Void> delete(@PathVariable("detalle_id") Long detalleId);
}
