package pe.isil.easytravel.data

import pe.isil.easytravel.domain.Destination
import pe.isil.easytravel.domain.DestinationRepository

class DestinationRepositoryImpl(private val service: DestinationService) : DestinationRepository {
    override suspend fun getDestinations(category: String): List<Destination> {
        val response = service.getDestinations(category)
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