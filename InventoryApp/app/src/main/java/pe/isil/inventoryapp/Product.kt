package pe.isil.inventoryapp

import java.util.UUID

data class Product(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val price: Double,
    val quantity: Int
)
