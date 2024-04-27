package org.mgb.inventoryservice.repo;

import org.mgb.inventoryservice.entities.Product;
import org.mgb.inventoryservice.entities.ProductReserved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource
public interface ProductReservedRepository extends JpaRepository<ProductReserved, UUID> {

}
