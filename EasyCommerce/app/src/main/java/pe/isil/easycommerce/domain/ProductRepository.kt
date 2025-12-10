package pe.isil.easycommerce.domain

interface ProductRepository {
    suspend fun searchProducts(query: String): List<Product>
}