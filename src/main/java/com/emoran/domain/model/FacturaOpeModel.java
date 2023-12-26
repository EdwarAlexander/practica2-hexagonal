package com.emoran.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaOpeModel {

    private Long id;
    private String nombreCliente;
    private String numDocumentoCliente;
    private Date fechaEmision;
    private BigDecimal total;
    private List<FacturaOpeDetalleModel> productoLista;
}
