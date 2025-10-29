package pe.isil.easytravel.domain

interface DestinationRepository {
   suspend fun getDestinations() : List<Destination>
}