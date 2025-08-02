package potatowonong.singlemysql.domain.product.dto.request

data class ProductCreateRequest(
    val name: String,
    val price: Long
) {
}