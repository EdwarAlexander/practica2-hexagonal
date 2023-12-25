package com.emoran.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacturaCabeceraModel {

    private Long id;
    private String nombreCliente;
    private String numDocumentoCliente;
    private Date fechaEmision;
    private BigDecimal total;
}
