package com.emoran.infrastructure.controller.apidoc;

import com.emoran.domain.model.FacturaOpeModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/facturasOpe")
@Tag(name = "Operaciones Factura")
public interface IFacturaOpeController {

    @Operation(summary = "Metodo para registrar una factura y detalle")
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody FacturaOpeModel facturaOpeModelRequest);

}
