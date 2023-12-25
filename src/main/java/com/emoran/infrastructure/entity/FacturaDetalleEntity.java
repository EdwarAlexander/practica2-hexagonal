package com.emoran.infrastructure.entity;

import com.emoran.domain.model.FacturaDetalleModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "facturadetalle")
public class FacturaDetalleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    private FacturaCabeceraEntity factura;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoEntity producto;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    public FacturaDetalleEntity() {
    }

    public FacturaDetalleEntity(Long id, FacturaCabeceraEntity factura, ProductoEntity producto, Integer cantidad, BigDecimal precioUnitario, BigDecimal subtotal) {
        this.id = id;
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    public static FacturaDetalleEntity fromFacturaDetalleModel(FacturaDetalleModel facturaDetalleModel){
        FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromFacturaCabeceraModel(facturaDetalleModel.getFactura());
        ProductoEntity productoEntity = ProductoEntity.fromProductoModel(facturaDetalleModel.getProducto());
        return new FacturaDetalleEntity(facturaDetalleModel.getId(), facturaCabeceraEntity, productoEntity, facturaDetalleModel.getCantidad(), facturaDetalleModel.getPrecioUnitario(), facturaDetalleModel.getSubtotal());
    }

    public FacturaDetalleModel fromFacturaDetalleEntity(){
        return new FacturaDetalleModel(id, factura.fromFacturaCabeceraEntity(),producto.fromProductoEntity(), cantidad, precioUnitario, subtotal);
    }
}
