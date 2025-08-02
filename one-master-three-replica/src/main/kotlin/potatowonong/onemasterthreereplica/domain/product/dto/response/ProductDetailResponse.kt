package potatowonong.onemasterthreereplica.domain.product.dto.response

import potatowonong.onemasterthreereplica.domain.product.entity.Product

data class ProductDetailResponse(
    val id: Long,
    val name: String,
    val price: Long
) {
    companion object {
        fun from(
            product: Product
        ) = ProductDetailResponse(
            id = product.id!!,
            name = product.name,
            price = product.price
        )
    }
}