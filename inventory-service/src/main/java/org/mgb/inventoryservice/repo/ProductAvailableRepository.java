package org.mgb.inventoryservice.repo;

import org.mgb.inventoryservice.entities.ProductAvailable;
import org.mgb.inventoryservice.entities.ProductReserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource
public interface ProductAvailableRepository extends JpaRepository<ProductAvailable, UUID> {

}
