package org.sopt24.dshyun0226.androidseminar.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_all_product_main.*
import kotlinx.android.synthetic.main.fragment_end_product.*

import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.SoptApplication
import org.sopt24.dshyun0226.androidseminar.adapter.ProductOverviewRecyclerViewAdapter
import org.sopt24.dshyun0226.androidseminar.data.ProductOverviewData
import org.sopt24.dshyun0226.androidseminar.network.get.GetMainProductListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EndProductFragment : Fragment() {

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
        rv_end_product_overall.layoutManager = GridLayoutManager(context!!, 3)
        // 서버와의 통신을 통해 dataList를 Update 해준다.
        getMainProductListResponse()
    }

    private fun getMainProductListResponse() {
        val getMainProductListResponse = networkService.getMainProductListResponse("application/json", 2)
        getMainProductListResponse.enqueue(object : Callback<GetMainProductListResponse> {
            override fun onFailure(call: Call<GetMainProductListResponse>, t: Throwable) {
                Log.e("list failed", t.toString())
            }

            override fun onResponse(
                call: Call<GetMainProductListResponse>,
                response: Response<GetMainProductListResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.status == 200) {
                        val tmp = response.body()!!.data!!
                        adapter.dataList = tmp
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }
}
