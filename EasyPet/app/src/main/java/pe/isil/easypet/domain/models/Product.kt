package pe.isil.easypet.domain.models

import android.R

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val posterPath: String,
    val rating: Double,
    val isFavorite: Boolean = false
)
