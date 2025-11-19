package pe.isil.easypet.data.models

import com.google.gson.annotations.SerializedName

data class ProductDto(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    @SerializedName("image")
    val posterPath: String,
    val rating: Double
)

data class ProductsWrapperDto(
    @SerializedName("results")
    val products: List<ProductDto>
)