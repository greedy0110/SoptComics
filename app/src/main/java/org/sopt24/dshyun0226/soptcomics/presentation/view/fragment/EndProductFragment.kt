package org.sopt24.dshyun0226.soptcomics.presentation.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_end_product.*

import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.SoptApplication
import org.sopt24.dshyun0226.soptcomics.presentation.view.adapter.ProductOverviewRecyclerViewAdapter
import org.sopt24.dshyun0226.soptcomics.domain.model.ProductOverviewData

class EndProductFragment : androidx.fragment.app.Fragment() {

    private lateinit var adapter: ProductOverviewRecyclerViewAdapter

    private val networkService by lazy { SoptApplication.instance.networkService }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_end_product, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var dataList: ArrayList<ProductOverviewData> = ArrayList()

        adapter = ProductOverviewRecyclerViewAdapter(context!!, dataList)
        rv_end_product_overall.adapter = adapter
        rv_end_product_overall.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context!!, 3)
        // 서버와의 통신을 통해 dataList를 Update 해준다.
        getMainProductListResponse()
    }

    private fun getMainProductListResponse() {
        val getMainProductListResponse = networkService.getMainProductListResponse("application/json", 3)
        getMainProductListResponse
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
            if (it.status == 200) {
                val tmp = it.data!!
                adapter.dataList = tmp
                adapter.notifyDataSetChanged()
            }
        }
    }
}
