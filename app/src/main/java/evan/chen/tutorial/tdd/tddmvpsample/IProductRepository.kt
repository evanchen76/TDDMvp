package evan.chen.tutorial.tdd.tddmvpsample

interface IProductRepository {
    fun getProduct(productId:String, callback: IProductRepository.LoadProductCallback)

    interface LoadProductCallback {
        fun onProductResult(productResponse: ProductResponse)
    }

}
