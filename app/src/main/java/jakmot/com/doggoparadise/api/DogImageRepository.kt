package jakmot.com.doggoparadise.api

import jakmot.com.doggoparadise.domain.Dog

class DogImageRepository(
    private val dogCeoService: DogCeoService,
) {

    suspend fun getRandomImages(count: Int): List<Dog> {
        return dogCeoService.getRandomImage(count)
            .message
            .map(::Dog)
    }
}