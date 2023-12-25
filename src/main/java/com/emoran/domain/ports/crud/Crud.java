package com.emoran.domain.ports.crud;

import java.util.List;
import java.util.Optional;

public interface Crud <RQ,RS,ID>{

    RS create(RQ request);
    Optional<RS> update(ID code, RQ request);
    List<RS> getAll();
    Optional<RS> get(ID code);
    boolean delete(ID code);
}
