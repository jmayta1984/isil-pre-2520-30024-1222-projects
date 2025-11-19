package pe.isil.easypet.data.repositories

import pe.isil.easypet.data.local.ProductDao
import pe.isil.easypet.data.remote.ProductService
import pe.isil.easypet.data.mappers.toDomain
import pe.isil.easypet.data.mappers.toEntity
import pe.isil.easypet.domain.models.Product
import pe.isil.easypet.domain.repositories.ProductRepository

class ProductRepositoryImpl(
    private val service: ProductService,
    private val dao: ProductDao
) : ProductRepository {
    override suspend fun getAllProducts(): List<Product> {

        val response = service.getAllProducts()
        val favoriteIds = dao.fetchAll().map { it.id }

        if (response.isSuccessful) {
            response.body()?.let { wrapperDto ->
                val productsDto = wrapperDto.products
                return productsDto.map { dto ->
                    dto.toDomain().copy(isFavorite = favoriteIds.contains(dto.id))
                }
            }
        }
        return emptyList()
    }

    override suspend fun toggleFavorite(product: Product) {
        val favoriteIds = dao.fetchAll().map { it.id }
        val entity = product.toEntity()
        if (favoriteIds.contains(product.id)) {
            dao.delete(entity)
        } else {
            dao.insert(entity)
        }
    }
}