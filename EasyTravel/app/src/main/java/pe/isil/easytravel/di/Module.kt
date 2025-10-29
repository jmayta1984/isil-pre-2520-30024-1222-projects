package pe.isil.easytravel.di

import pe.isil.easytravel.data.DestinationRepositoryImpl
import pe.isil.easytravel.data.DestinationService
import pe.isil.easytravel.domain.DestinationRepository
import pe.isil.easytravel.presentation.DestinationListViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Module {

    fun getDestinationListViewModel(): DestinationListViewModel {
        return DestinationListViewModel(getDestinationRepository())
    }

    fun getDestinationRepository(): DestinationRepository {
        return DestinationRepositoryImpl(getDestinationService())
    }

    fun getDestinationService(): DestinationService {
        return getRetrofit().create(DestinationService::class.java)
    }

    fun getRetrofit(): Retrofit  = Retrofit
        .Builder()
        .baseUrl("https://travelapi-1071627934947.us-central1.run.app/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}