package evan.chen.tutorial.tdd.tddmvpsample

class ProductPresenter(
    private val view: ProductContract.IProductView,
    private val repository: IProductRepository
) : ProductContract.IProductPresenter {
    override fun getProduct(productId: String) {
        repository.getProduct(productId, object : IProductRepository.LoadProductCallback {
            //還沒處理View的callback
            override fun onProductResult(productResponse: ProductResponse) {
                view.onGetResult(productResponse)
            }
        })
    }
}
