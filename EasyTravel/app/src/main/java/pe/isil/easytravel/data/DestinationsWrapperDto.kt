package pe.isil.easytravel.data

import com.google.gson.annotations.SerializedName


data class DestinationsWrapperDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("results")
    val destinations: List<DestinationDto>
)