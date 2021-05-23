package jakmot.com.doggoparadise.api

import jakmot.com.doggoparadise.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface DogCeoService {

    @GET("api/breeds/image/random/{count}")
    suspend fun getRandomImage(
        @Path("count") count: Int,
    ): DogRandomImagesResponse

    companion object {
        const val BASE_URL = "https://dog.ceo/"

        fun create(baseUrl: String): DogCeoService {
            val loggingInterceptor = HttpLoggingInterceptor(
            ).apply {
                level = if (BuildConfig.DEBUG) Level.BODY else Level.NONE
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(DogCeoService::class.java)
        }
    }
}