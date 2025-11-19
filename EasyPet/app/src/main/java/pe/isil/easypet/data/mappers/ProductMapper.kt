package pe.isil.easypet.data.mappers

import pe.isil.easypet.data.models.ProductDto
import pe.isil.easypet.data.models.ProductEntity
import pe.isil.easypet.domain.models.Product

fun ProductDto.toDomain(): Product =
    Product(
        id = id,
        title = title,
        description = description,
        posterPath = posterPath,
        rating = rating,
        price = price
    )

fun Product.toEntity(): ProductEntity =
    ProductEntity(
        id = id,
        title = title,
        description = description,
        posterPath = posterPath,
        rating = rating,
        price = price
    )