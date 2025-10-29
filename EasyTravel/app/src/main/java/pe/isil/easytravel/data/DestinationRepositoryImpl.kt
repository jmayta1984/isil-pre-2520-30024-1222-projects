package pe.isil.easytravel.data

import pe.isil.easytravel.domain.Destination
import pe.isil.easytravel.domain.DestinationRepository

class DestinationRepositoryImpl(private val service: DestinationService) : DestinationRepository {
    override suspend fun getDestinations(): List<Destination> {
        val response = service.getDestinations()
        if (response.isSuccessful) {
            response.body()?.let { wrapperDto ->
              return wrapperDto.destinations.map { dto ->
                    Destination(
                        id = dto.id,
                        title = dto.title,
                        posterPath = dto.posterPath,
                        overview = dto.overview
                    )
                }
            }
        }
        return emptyList()
    }
}