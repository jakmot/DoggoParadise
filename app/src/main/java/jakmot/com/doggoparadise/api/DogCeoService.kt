package jakmot.com.doggoparadise.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface DogCeoService {

    @GET("api/breeds/image/random/{count}")
    suspend fun getRandomImage(
        @Query("count") count: Int,
    ): DogRandomImagesResponse

    companion object {
        private const val BASE_URL = "https://dog.ceo/"

        fun create(): DogCeoService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(DogCeoService::class.java)
        }
    }
}