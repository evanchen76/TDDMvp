package evan.chen.tutorial.tdd.tddmvpsample

class ProductPresenter(private val repository: IProductRepository) : ProductContract.IProductPresenter {
    override fun getProduct(productId: String) {
        repository.getProduct(productId, object : IProductRepository.LoadProductCallback{
            //還沒處理View的callback
        })
    }
}
