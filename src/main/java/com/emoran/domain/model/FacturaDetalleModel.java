package com.emoran.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDetalleModel {

    private Long id;
    //private Long facturaId;
    //private Long productoId;
    private FacturaCabeceraModel factura;
    private ProductoModel producto;
    private Integer cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;
}
