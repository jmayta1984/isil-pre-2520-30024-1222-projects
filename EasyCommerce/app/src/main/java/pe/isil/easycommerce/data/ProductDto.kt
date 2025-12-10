package pe.isil.easycommerce.data

import com.google.gson.annotations.SerializedName

data class ProductDto(
    val id: Int,
    @SerializedName("title")
    val name: String,
    val price: Int,
    val images: List<String>
)
