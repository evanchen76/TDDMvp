package evan.chen.tutorial.tdd.tddmvpsample

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class ProductPresenterTest {

    private lateinit var presenter: ProductContract.IProductPresenter

    @MockK(relaxed = true)
    private lateinit var repository: IProductRepository

    @MockK(relaxed = true)
    private lateinit var view: ProductContract.IProductView

    private var productResponse = ProductResponse()

    @Before
    fun setupPresenter() {
        MockKAnnotations.init(this)

        presenter = ProductPresenter(view, repository)

        productResponse.id = "pixel3"
        productResponse.name = "Google Pixel 3"
        productResponse.price = 27000
        productResponse.desc = "Desc"

    }

    @Test
    fun getProductTest() {
        val productId = "pixel3"
        val slot = slot<IProductRepository.LoadProductCallback>()
        //驗證是否有呼叫IProductRepository.getProduct
        presenter.getProduct(productId)
        verify { repository.getProduct(eq(productId), capture(slot)) }
    }

    @Test
    fun getProductCallBackTest() {
        val productId = "pixel3"
        val slot = slot<IProductRepository.LoadProductCallback>()
        //驗證是否有呼叫IProductRepository.getProduct
        every { repository.getProduct(eq(productId), capture(slot)) }
            .answers {
                //將callback攔截下載並指定productResponse的值。
                slot.captured.onProductResult(productResponse)
            }

        presenter.getProduct(productId)
        //驗證是否有呼叫View.onGetResult及是否傳入productResponse
        verify { view.onGetResult(eq(productResponse)) }
    }
}