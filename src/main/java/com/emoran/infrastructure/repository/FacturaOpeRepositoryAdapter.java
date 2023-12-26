package com.emoran.infrastructure.repository;

import com.emoran.domain.model.FacturaOpeDetalleModel;
import com.emoran.domain.model.FacturaOpeModel;
import com.emoran.domain.ports.out.FacturaOpeOut;
import com.emoran.infrastructure.entity.FacturaCabeceraEntity;
import com.emoran.infrastructure.entity.FacturaDetalleEntity;
import com.emoran.infrastructure.entity.ProductoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FacturaOpeRepositoryAdapter implements FacturaOpeOut {

    private final FacturaCabeceraRepository facturaCabeceraRepository;

    private final FacturaDetalleRepository facturaDetalleRepository;

    @Override
    public void createOperacion(FacturaOpeModel facturaOpeModel) {
        FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.fromFacturaOpeModel(facturaOpeModel);
        FacturaCabeceraEntity facturaSaved = facturaCabeceraRepository.save(facturaCabeceraEntity);
        for (FacturaOpeDetalleModel detalle: facturaOpeModel.getProductoLista()) {
            ProductoEntity productoEntity = new ProductoEntity();
            productoEntity.setId(detalle.getProductoId());
            FacturaDetalleEntity facturaDetalleEntity = new FacturaDetalleEntity();
            facturaDetalleEntity.setFactura(facturaSaved);
            facturaDetalleEntity.setProducto(productoEntity);
            facturaDetalleEntity.setCantidad(detalle.getCantidad());
            facturaDetalleEntity.setPrecioUnitario(detalle.getPrecioUnitario());
            facturaDetalleEntity.setSubtotal(detalle.getSubtotal());
            facturaDetalleRepository.save(facturaDetalleEntity);
        }
    }
}
