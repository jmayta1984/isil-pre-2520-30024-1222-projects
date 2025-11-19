package pe.isil.easypet.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.isil.easypet.data.local.ProductDao
import pe.isil.easypet.data.models.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}