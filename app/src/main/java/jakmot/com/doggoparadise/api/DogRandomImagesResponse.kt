package jakmot.com.doggoparadise.api

import com.squareup.moshi.Json

class DogRandomImagesResponse(
    @Json(name = "message") val message: List<String>,
)