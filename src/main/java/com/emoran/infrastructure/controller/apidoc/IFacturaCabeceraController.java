package com.emoran.infrastructure.controller.apidoc;

import com.emoran.domain.model.FacturaCabeceraModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@Tag(name = "Facturas")
public interface IFacturaCabeceraController {

    @Operation(summary = "Metodo para registrar una factura")
    @PostMapping
    public ResponseEntity<FacturaCabeceraModel> create(@RequestBody FacturaCabeceraModel facturaCabeceraModelRequest);

    @Operation(summary = "Metodo para listar todas las facturas")
    @GetMapping
    public ResponseEntity<List<FacturaCabeceraModel>> getAll();

    @Operation(summary = "Metodo para obtener una factura")
    @GetMapping("/{factura_id}")
    public ResponseEntity<FacturaCabeceraModel> get(@PathVariable("factura_id") Long facturaId);

    @Operation(summary = "Metodo para actualizar una factura")
    @PutMapping("/{factura_id}")
    public ResponseEntity<FacturaCabeceraModel> update(@PathVariable("factura_id") Long facturaId, @RequestBody FacturaCabeceraModel facturaCabeceraModelRequest);

    @Operation(summary = "Metodo para eliminar una factura")
    @DeleteMapping("/{factura_id}")
    public ResponseEntity<Void> delete(@PathVariable("factura_id") Long facturaId);
}
