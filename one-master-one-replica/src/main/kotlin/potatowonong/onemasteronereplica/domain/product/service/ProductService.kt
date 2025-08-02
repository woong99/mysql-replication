package potatowonong.onemasteronereplica.domain.product.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import potatowonong.onemasteronereplica.domain.product.dto.request.ProductCreateRequest
import potatowonong.onemasteronereplica.domain.product.dto.response.ProductDetailResponse
import potatowonong.onemasteronereplica.domain.product.entity.Product
import potatowonong.onemasteronereplica.domain.product.repository.ProductRepository

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
    fun getProducts(): List<ProductDetailResponse> {
        return productRepository.findAll().map {
            ProductDetailResponse.from(it)
        }
    }
}