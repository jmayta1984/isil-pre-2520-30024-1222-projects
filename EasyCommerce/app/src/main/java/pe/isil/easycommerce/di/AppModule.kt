package pe.isil.easycommerce.di

import pe.isil.easycommerce.data.ProductRepositoryImpl
import pe.isil.easycommerce.data.ProductService
import pe.isil.easycommerce.domain.ProductRepository
import pe.isil.easycommerce.presentation.ProductsViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

    fun getProductsViewModel(): ProductsViewModel {
        return ProductsViewModel(getProductRepository())
    }

    fun getProductRepository(): ProductRepository {
        return ProductRepositoryImpl(getProductService())
    }

    fun getProductService(): ProductService {
        return getRetrofit().create(ProductService::class.java)
    }

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}