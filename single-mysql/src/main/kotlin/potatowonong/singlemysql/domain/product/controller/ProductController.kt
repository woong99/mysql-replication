package potatowonong.singlemysql.domain.product.controller

import org.springframework.web.bind.annotation.*
import potatowonong.singlemysql.domain.product.dto.request.ProductCreateRequest
import potatowonong.singlemysql.domain.product.service.ProductService

@RestController
@RequestMapping("/api/v1/products")
class ProductController(
    private val productService: ProductService
) {

    @PostMapping
    fun createProduct(
        @RequestBody request: ProductCreateRequest
    ) {
        productService.createProduct(request)
    }

    @GetMapping
    fun getProducts(): List<String> {
        return productService.getProducts().map { it.name }
    }
}