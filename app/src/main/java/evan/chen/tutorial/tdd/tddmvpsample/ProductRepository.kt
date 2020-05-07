package evan.chen.tutorial.tdd.tddmvpsample

class ProductRepository(val productAPI: IProductAPI) : IProductRepository {
    override fun getProduct(productId: String, callback: IProductRepository.LoadProductCallback) {
        productAPI.getProduct(productId, object : IProductAPI.LoadAPICallback{
            override fun onGetResult(productResponse: ProductResponse) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }
}
