package com.emoran.infrastructure.entity;

import com.emoran.domain.model.ProductoModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "productos")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;

    public ProductoEntity() {
    }

    public ProductoEntity(Long id, String nombre, String descripcion, BigDecimal precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public static ProductoEntity fromProductoModel(ProductoModel productoModel){
        return new ProductoEntity(productoModel.getId(), productoModel.getNombre(), productoModel.getDescripcion(), productoModel.getPrecio(), productoModel.getStock());
    }

    public ProductoModel fromProductoEntity(){
        return new ProductoModel(id,nombre,descripcion,precio,stock);
    }
}
