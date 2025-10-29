package pe.isil.easytravel.data

import com.google.gson.annotations.SerializedName


data class
DestinationDto(
    @SerializedName("bestSeason")
    val bestSeason: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("durationDays")
    val durationDays: Int,
    @SerializedName("highlights")
    val highlights: List<String>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("posterPath")
    val posterPath: String,
    @SerializedName("priceUSD")
    val priceUSD: Int,
    @SerializedName("rating")
    val rating: Double,
    @SerializedName("tags")
    val tags: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)