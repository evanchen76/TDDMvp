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
    @MockK(relaxed = true)
    private lateinit var repositoryCallback: IProductRepository.LoadProductCallback

    @MockK(relaxed = true)
    private lateinit var productAPI: IProductAPI

    @Before
    fun setupPresenter() {
        MockKAnnotations.init(this)
        repository = ProductRepository(productAPI)
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
}