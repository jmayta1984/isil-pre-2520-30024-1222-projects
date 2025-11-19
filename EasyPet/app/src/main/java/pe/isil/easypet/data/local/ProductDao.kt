package pe.isil.easypet.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import pe.isil.easypet.data.models.ProductEntity

@Dao
interface ProductDao {
    @Insert
    suspend fun insert(entity: ProductEntity)

    @Delete
    suspend fun delete(entity: ProductEntity)

    @Query("select * from products")
    suspend fun fetchAll(): List<ProductEntity>
}