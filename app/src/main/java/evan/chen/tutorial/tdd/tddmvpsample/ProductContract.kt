package evan.chen.tutorial.tdd.tddmvpsample

interface ProductContract {
    interface IProductPresenter {
        fun getProduct(productId: String)
    }

    interface IProductView {
        fun onGetResult(productResponse: ProductResponse)
    }

}
