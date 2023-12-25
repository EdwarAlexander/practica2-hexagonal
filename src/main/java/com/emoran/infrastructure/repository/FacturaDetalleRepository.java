package com.emoran.infrastructure.repository;

import com.emoran.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalleEntity, Long> {
}
