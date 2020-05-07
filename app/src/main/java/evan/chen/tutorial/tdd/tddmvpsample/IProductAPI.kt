package evan.chen.tutorial.tdd.tddmvpsample

interface IProductAPI {
    fun getProduct(productId: String, loadAPICallback: LoadAPICallback)

    interface LoadAPICallback {
        fun onGetResult(productResponse: ProductResponse)
    }
}