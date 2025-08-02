package potatowonong.onemasterthreereplica.domain.product.repository

import org.springframework.data.jpa.repository.JpaRepository
import potatowonong.onemasterthreereplica.domain.product.entity.Product

interface ProductRepository : JpaRepository<Product, Long> {
}