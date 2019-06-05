package org.sopt24.dshyun0226.soptcomics.presentation.comics_overview

import org.sopt24.dshyun0226.soptcomics.domain.model.ComicsOverviewData
import org.sopt24.dshyun0226.soptcomics.presentation.view.BaseView

interface ComicsOverviewContract {
    interface View: BaseView<Presenter>{
        fun updateComicsOverviewList(productList: List<ComicsOverviewData>)
    }

    interface Presenter {
        val kind: String
        fun onActivityCreated()
    }
}