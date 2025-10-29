package pe.isil.easytravel.domain

interface DestinationRepository {
   suspend fun getDestinations(category: String) : List<Destination>
}