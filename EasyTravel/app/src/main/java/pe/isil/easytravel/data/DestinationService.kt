package pe.isil.easytravel.data

import retrofit2.Response
import retrofit2.http.GET

interface DestinationService {

    @GET("api/destinations")
    suspend fun getDestinations(): Response<DestinationsWrapperDto>
}