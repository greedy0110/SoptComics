package org.sopt24.dshyun0226.soptcomics.presentation.comics_overview

import org.sopt24.dshyun0226.soptcomics.domain.model.ProductOverviewData
import org.sopt24.dshyun0226.soptcomics.presentation.view.BaseView

interface ComicsOverviewContract {
    interface View: BaseView<Presenter>{
        fun updateComicsOverviewList(productList: ArrayList<ProductOverviewData>)
    }

    interface Presenter {
        val kind: String
        fun onActivityCreated()
    }
}