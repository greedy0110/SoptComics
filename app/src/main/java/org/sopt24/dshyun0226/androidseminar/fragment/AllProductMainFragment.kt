package org.sopt24.dshyun0226.androidseminar.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_all_product_main.*

import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.SoptApplication
import org.sopt24.dshyun0226.androidseminar.adapter.ProductOverviewRecyclerViewAdapter
import org.sopt24.dshyun0226.androidseminar.data.ProductOverviewData
import org.sopt24.dshyun0226.androidseminar.network.get.GetMainProductListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllProductMainFragment : Fragment() {

    private lateinit var adapter: ProductOverviewRecyclerViewAdapter

    private val networkService by lazy { SoptApplication.instance.networkService }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_product_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var dataList: ArrayList<ProductOverviewData> = ArrayList()

        adapter = ProductOverviewRecyclerViewAdapter(context!!, dataList)
        rv_product_overview_all.adapter = adapter
        rv_product_overview_all.layoutManager = GridLayoutManager(context!!, 3)
        // 서버와의 통신을 통해 dataList를 Update 해준다.
        getMainProductListResponse()
    }

    private fun getMainProductListResponse() {
        val getMainProductListResponse = networkService.getMainProductListResponse("application/json", 1)
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
