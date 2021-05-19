package jakmot.com.doggoparadise.api

import com.squareup.moshi.Json

data class DogRandomImagesResponse(
    @Json(name = "message") val message: List<String>,
)