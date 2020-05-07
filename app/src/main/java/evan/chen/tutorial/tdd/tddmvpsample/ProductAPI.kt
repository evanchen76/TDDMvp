package evan.chen.tutorial.tdd.tddmvpsample

import android.os.Handler

class ProductAPI: IProductAPI {

    override fun getProduct(productId:String, loadAPICallBack: IProductAPI.LoadAPICallback) {
        //模擬從API取得資料
        val handler = Handler()
        handler.postDelayed(Runnable {
            val productResponse = ProductResponse()
            productResponse.id = "pixel3"
            productResponse.name = "Google Pixel 3"
            productResponse.desc = "5.5吋螢幕"
            productResponse.price = 27000
            loadAPICallBack.onGetResult(productResponse)
        }, 1000)
    }
}