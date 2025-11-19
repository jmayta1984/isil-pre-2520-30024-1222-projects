package pe.isil.easypet.data.remote

import pe.isil.easypet.data.models.ProductsWrapperDto
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getAllProducts(): Response<ProductsWrapperDto>
}