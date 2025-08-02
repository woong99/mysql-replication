package potatowonong.onemasteronereplica.domain.product.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import potatowonong.onemasteronereplica.domain.product.dto.request.ProductCreateRequest
import potatowonong.onemasteronereplica.domain.product.dto.response.ProductDetailResponse
import potatowonong.onemasteronereplica.domain.product.service.ProductService

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun createProduct(
        @RequestBody request: ProductCreateRequest
    ): ResponseEntity<Unit> {
        productService.createProduct(request)

        return ResponseEntity.ok().build()
    }

    @GetMapping
    fun getProducts(): ResponseEntity<List<ProductDetailResponse>> {
        return ResponseEntity.ok(productService.getProducts())
    }
}