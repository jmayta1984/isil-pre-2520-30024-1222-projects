package pe.isil.easycommerce.data

import android.util.Log
import pe.isil.easycommerce.domain.Product
import pe.isil.easycommerce.domain.ProductRepository

class ProductRepositoryImpl(private val service: ProductService) : ProductRepository {
    override suspend fun searchProducts(query: String): List<Product> {
        try {
            val response = service.searchProduct(query)

            if (response.isSuccessful) {
                val dtos = response.body()
                dtos?.let {

                    return it.map { dto ->
                        Product(
                            id = dto.id,
                            name = dto.name,
                            price = dto.price,
                            image = dto.images[0],
                            images = dto.images
                        )
                    }
                }
                return emptyList()
            } else {
                return emptyList()

            }
        } catch (_: Exception) {
            return emptyList()
        }


    }
}