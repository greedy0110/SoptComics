package org.sopt24.dshyun0226.soptcomics.presentation.contract

import org.sopt24.dshyun0226.soptcomics.domain.model.ProductOverviewData
import org.sopt24.dshyun0226.soptcomics.presentation.view.BaseView

interface ProductContract {
    interface View: BaseView<Presenter>{
        fun drawProduct(productList: ArrayList<ProductOverviewData>)
    }

    interface Presenter {
        val kind: String
        fun onActivityCreated()
    }
}