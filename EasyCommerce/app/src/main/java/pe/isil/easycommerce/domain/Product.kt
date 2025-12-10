package pe.isil.easycommerce.domain

data class Product(
    val id: Int,
    val name: String,
    val price: Int,
    val image: String,
    val images: List<String>
)
