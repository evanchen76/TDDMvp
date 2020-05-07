package evan.chen.tutorial.tdd.tddmvpsample

class ProductRepository(productAPI: IProductAPI) : IProductRepository {
    override fun getProduct(productId: String, callback: IProductRepository.LoadProductCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
