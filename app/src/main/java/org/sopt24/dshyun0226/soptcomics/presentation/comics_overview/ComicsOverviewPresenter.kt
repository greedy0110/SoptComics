package org.sopt24.dshyun0226.soptcomics.presentation.comics_overview

import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi

class ComicsOverviewPresenter(
    private val view: ComicsOverviewContract.View,
    private val api: SoptComicsApi,
    override val kind: String
): ComicsOverviewContract.Presenter {
    override fun onActivityCreated() {
        // TODO 이 참조 정리 언제하지?
        api.requestComicsOverviewList(kind)
            .subscribe {
                view.updateComicsOverviewList(it.data!!)
            }
    }
}