package pe.isil.easypet.di

import androidx.room.Room
import pe.isil.easypet.MyApplication
import pe.isil.easypet.core.database.AppDatabase
import pe.isil.easypet.data.local.ProductDao
import pe.isil.easypet.data.repositories.ProductRepositoryImpl
import pe.isil.easypet.data.remote.ProductService
import pe.isil.easypet.domain.repositories.ProductRepository
import pe.isil.easypet.presentation.ProductListViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Module {

    fun getProductListViewModel(): ProductListViewModel {
        return ProductListViewModel(getProductRepository())
    }

    fun getProductRepository(): ProductRepository {
        return ProductRepositoryImpl(
            getProductService(),
            getProductDao()
        )
    }

    fun getProductService(): ProductService {
        return getRetrofit().create(ProductService::class.java)
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://petapi-591531460223.us-central1.run.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getProductDao(): ProductDao {
        return getAppDatabase().productDao()
    }

    fun getAppDatabase(): AppDatabase {
        return Room.databaseBuilder(
            MyApplication.INSTANCE.applicationContext, AppDatabase::class.java, "easypet"
        ).build()
    }
}