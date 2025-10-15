package pe.isil.inventoryapp

import java.util.UUID

data class Product(
    val id: String = UUID.randomUUID().toString(),
    var name: String,
    var price: Double,
    var quantity: Int
)
