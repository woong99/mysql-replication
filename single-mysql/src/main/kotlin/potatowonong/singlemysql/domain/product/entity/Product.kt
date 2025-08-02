package potatowonong.singlemysql.domain.product.entity

import jakarta.persistence.*
import potatowonong.singlemysql.domain.product.dto.request.ProductCreateRequest

@Entity
class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: Long
) {
    companion object {
        fun create(
            request: ProductCreateRequest
        ): Product = Product(
            name = request.name,
            price = request.price
        )
    }
}