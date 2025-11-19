package pe.isil.easypet.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    @ColumnInfo("poster_path")
    val posterPath: String,
    val rating: Double,
    val price: Double
)
