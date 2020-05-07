package evan.chen.tutorial.tdd.tddmvpsample

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class ProductRepositoryTest {

    lateinit var repository: IProductRepository
    private var productResponse = ProductResponse()

    @MockK(relaxed = true)
    private lateinit var repositoryCallback: IProductRepository.LoadProductCallback

    @MockK(relaxed = true)
    private lateinit var productAPI: IProductAPI

    @Before
    fun setupPresenter() {
        MockKAnnotations.init(this)
        repository = ProductRepository(productAPI)

        productResponse.id = "pixel3"
        productResponse.name = "Google Pixel 3"
        productResponse.price = 27000
        productResponse.desc = "Desc"
    }

    @Test
    fun getProductTest() {
        //驗證跟Repository取得資料
        val productId = "pixel3"

        //驗證是否有呼叫IProductAPI.getProduct
        val slot = slot<IProductAPI.LoadAPICallback>()

        repository.getProduct(productId, repositoryCallback)

        verify { productAPI.getProduct(any(), capture(slot)) }
    }

    @Test
    fun getProductTestCallback() {
        //驗證跟Repository取得資料
        val productId = "pixel3"

        //驗證是否有呼叫IProductAPI.getProduct
        val slot = slot<IProductAPI.LoadAPICallback>()

        every { productAPI.getProduct(any(), capture(slot)) }
            .answers {
                //將callback攔截下載並指定productResponse的值。
                slot.captured.onGetResult(productResponse)
            }
        repository.getProduct(productId, repositoryCallback)

        verify { repositoryCallback.onProductResult(productResponse) }
    }
}