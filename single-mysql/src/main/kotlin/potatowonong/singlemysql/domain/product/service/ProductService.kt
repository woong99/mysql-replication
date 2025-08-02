package potatowonong.singlemysql.domain.product.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import potatowonong.singlemysql.domain.product.dto.request.ProductCreateRequest
import potatowonong.singlemysql.domain.product.entity.Product
import potatowonong.singlemysql.domain.product.repository.ProductRepository

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {
    @Transactional
    fun createProduct(
        request: ProductCreateRequest
    ) {
        val product = Product.create(request)
        productRepository.save(product)
    }

    @Transactional(readOnly = true)
    fun getProducts(): List<Product> {
        return productRepository.findAll()
    }
}