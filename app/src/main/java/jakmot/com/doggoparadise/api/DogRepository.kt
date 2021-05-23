package jakmot.com.doggoparadise.api

import jakmot.com.doggoparadise.domain.Dog

class DogRepository(
    private val dogCeoService: DogCeoService,
) {

    suspend fun getRandomImages(count: Int): List<Dog> {
        return dogCeoService.getRandomImage(count)
            .message
            .mapIndexed { index, imageUrl ->
                Dog(
                    imageUrl,
                    name = "Pug $index",
                    shortDescription = "really cute pug",
                    longDescription = LONG_DESCRIPTION,
                )
            }
    }

    private companion object {
        private const val LONG_DESCRIPTION =
            "The pug is a breed of dog with physically distinctive features of a wrinkly, short-muzzled face, and curled tail. The breed has a fine, glossy coat that comes in a variety of colours, most often light brown (fawn) or black, and a compact, square body with well-developed muscles."
    }
}