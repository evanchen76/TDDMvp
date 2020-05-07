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

    @Before
    fun setupPresenter() {
        MockKAnnotations.init(this)
        presenter = ProductPresenter(repository)
    }

    @Test
    fun getProductTest() {
        val productId = "pixel3"
        val slot = slot<IProductRepository.LoadProductCallback>()
        //驗證是否有呼叫IProductRepository.getProduct
        presenter.getProduct(productId)
        verify { repository.getProduct(eq(productId), capture(slot)) }
    }
}