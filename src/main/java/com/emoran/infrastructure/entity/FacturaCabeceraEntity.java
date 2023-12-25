package com.emoran.infrastructure.entity;

import com.emoran.domain.model.FacturaCabeceraModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "facturacabecera")
public class FacturaCabeceraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_id")
    private Long id;

    @Column(name = "cliente_nombre")
    private String nombreCliente;

    @Column(name = "cliente_num_documento")
    private String numDocumentoCliente;

    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @Column(name = "total")
    private BigDecimal total;

    public FacturaCabeceraEntity() {
    }

    public FacturaCabeceraEntity(Long id, String nombreCliente, String numDocumentoCliente, Date fechaEmision, BigDecimal total) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.numDocumentoCliente = numDocumentoCliente;
        this.fechaEmision = fechaEmision;
        this.total = total;
    }

    public static FacturaCabeceraEntity fromFacturaCabeceraModel(FacturaCabeceraModel facturaCabeceraModel){
        return new FacturaCabeceraEntity(facturaCabeceraModel.getId(), facturaCabeceraModel.getNombreCliente(), facturaCabeceraModel.getNumDocumentoCliente(), facturaCabeceraModel.getFechaEmision(), facturaCabeceraModel.getTotal());
    }

    public FacturaCabeceraModel fromFacturaCabeceraEntity(){
        return new FacturaCabeceraModel(id, nombreCliente, numDocumentoCliente, fechaEmision, total);
    }
}
