package pe.isil.easytravel.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DestinationService {

    @GET("api/destinations")
    suspend fun getDestinations(@Query("type") category: String = ""): Response<DestinationsWrapperDto>
}