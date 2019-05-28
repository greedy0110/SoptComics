package org.sopt24.dshyun0226.soptcomics.presentation.presenter

import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.presentation.contract.ProductContract

class ProductPresenter(
    private val view: ProductContract.View,
    private val api: SoptComicsApi,
    override val kind: String
): ProductContract.Presenter {
    override fun onActivityCreated() {
        // TODO 이 참조 정리 언제하지?
        api.requestProductList(kind)
            .subscribe {
                view.drawProduct(it.data!!)
            }
    }
}