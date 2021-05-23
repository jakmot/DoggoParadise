package jakmot.com.doggoparadise.gallery

import jakmot.com.doggoparadise.CoroutinesTestRule
import jakmot.com.doggoparadise.FileUtils
import jakmot.com.doggoparadise.InstantExecutorExtension
import jakmot.com.doggoparadise.api.DogCeoService
import jakmot.com.doggoparadise.di.appModule
import jakmot.com.doggoparadise.domain.Dog
import jakmot.com.doggoparadise.getValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.RegisterExtension
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import org.koin.test.junit5.KoinTestExtension

@ExperimentalCoroutinesApi
@ExtendWith(CoroutinesTestRule::class, InstantExecutorExtension::class)
class GalleryViewModelTest : KoinTest {

    private val server: MockWebServer = MockWebServer()

    private val fileUtils: FileUtils = FileUtils()

    private val galleryViewModel: GalleryViewModel by inject()

    @JvmField
    @RegisterExtension
    val koinTestExtension = KoinTestExtension.create {
        modules(
            appModule(),
            module(override = true) {
                single { DogCeoService.create(server.url("").toString()) }
            })
    }

    @BeforeEach
    fun beforeAll() {
        server.start()
    }

    @AfterEach
    fun afterAll() {
        server.close()
    }

    @Test
    fun should_emit_data_when_api_call_was_successful() {
        val expectedFirstElement = Dog(
            imageUrl = "https://images.dog.ceo/breeds/rottweiler/n02106550_10375.jpg",
            name = "Pug 0",
            shortDescription = "really cute pug",
            longDescription = "The pug is a breed of dog with physically distinctive features of a wrinkly, short-muzzled face, and curled tail. The breed has a fine, glossy coat that comes in a variety of colours, most often light brown (fawn) or black, and a compact, square body with well-developed muscles.",
        )
        server.enqueue(
            MockResponse()
                .setBody(fileUtils.loadFile("sample_response.json"))
        )

        galleryViewModel.init()
        val actualValue = getValue(galleryViewModel.getDogsImages())

        assertThat(actualValue.first()).isEqualTo(expectedFirstElement)
    }

    @Test
    fun should_show_error_when_api_call_failed() {
        server.enqueue(
            MockResponse()
                .setResponseCode(401)
        )

        galleryViewModel.init()
        val actualValue = getValue(galleryViewModel.shouldShowError())

        assertThat(actualValue.content).isTrue()
    }

}