package org.sopt24.dshyun0226.soptcomics.product

import io.reactivex.Observable
import org.junit.Test

import org.junit.Before
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.sopt24.dshyun0226.soptcomics.domain.model.ProductOverviewData
import org.sopt24.dshyun0226.soptcomics.api.response.GetMainProductListResponse
import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.presentation.contract.ProductContract
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.ProductPresenter

class ProductPresenterTest {
    private lateinit var presenter: ProductPresenter

    @Mock private lateinit var view: ProductContract.View
    @Mock private lateinit var api: SoptComicsApi
    private lateinit var mplr: GetMainProductListResponse
    private var productList:ArrayList<ProductOverviewData> = arrayListOf()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        presenter = ProductPresenter(view = view, api = api, kind = "all")
        mplr = GetMainProductListResponse(
            200, true, "sucess", productList
        )

        `when`(api.requestProductList(Matchers.anyString())).thenReturn(
            Observable.just(mplr)
        )
    }

    @Test
    fun onActivityCreatedThenGetProductListAndDrawListView() {
        presenter.onActivityCreated()

        // TODO api가 완료되면 view가 그려줘야한다. (비동기 작업에 대한 테스트이다.)
        // 테스트 환경일때는 비동기 작업을 동기적으로 완수해주는 서버를 제공하면된다!
        // -> 서버의 스케쥴러를 장착하고 상황에따라서 조정 가능하도록 변경해주어야한다!?
        verify(api).requestProductList(presenter.kind)
        verify(view).drawProduct(productList)
    }
}