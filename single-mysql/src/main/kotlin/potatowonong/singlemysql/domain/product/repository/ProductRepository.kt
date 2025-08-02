package potatowonong.singlemysql.domain.product.repository

import org.springframework.data.jpa.repository.JpaRepository
import potatowonong.singlemysql.domain.product.entity.Product

interface ProductRepository : JpaRepository<Product, Long> {
}