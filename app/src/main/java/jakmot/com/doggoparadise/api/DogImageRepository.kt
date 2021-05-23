package jakmot.com.doggoparadise.api

class DogImageRepository(
    private val dogCeoService: DogCeoService,
) {

    suspend fun getRandomImages(count: Int): List<DogImage> {
        return dogCeoService.getRandomImage(count)
            .message
            .map(::DogImage)
    }
}