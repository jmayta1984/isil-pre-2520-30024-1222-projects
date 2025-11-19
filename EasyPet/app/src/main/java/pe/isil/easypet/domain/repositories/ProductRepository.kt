package pe.isil.easypet.domain.repositories

import pe.isil.easypet.domain.models.Product

interface ProductRepository {

    suspend fun getAllProducts(): List<Product>

    suspend fun toggleFavorite(product: Product)
}