package pe.isil.easycommerce.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    @GET("products")
    suspend fun searchProduct(@Query("title") query: String): Response<List<ProductDto>>

}