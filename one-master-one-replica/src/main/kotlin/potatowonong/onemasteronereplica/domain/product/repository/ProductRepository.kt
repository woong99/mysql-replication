package potatowonong.onemasteronereplica.domain.product.repository

import org.springframework.data.jpa.repository.JpaRepository
import potatowonong.onemasteronereplica.domain.product.entity.Product

interface ProductRepository : JpaRepository<Product, Long> {
}