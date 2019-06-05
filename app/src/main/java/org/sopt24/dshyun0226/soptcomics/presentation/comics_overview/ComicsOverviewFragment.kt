package org.sopt24.dshyun0226.soptcomics.presentation.comics_overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_product.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.domain.model.ProductOverviewData
import org.sopt24.dshyun0226.soptcomics.presentation.adapter.ProductOverviewRecyclerViewAdapter

class ComicsOverviewFragment(private val kind: String) : androidx.fragment.app.Fragment(), ComicsOverviewContract.View {

    override fun updateComicsOverviewList(list: ArrayList<ProductOverviewData>) {
        adapter.dataList = list
        adapter.notifyDataSetChanged()
    }

    override val presenter: ComicsOverviewContract.Presenter by inject { parametersOf(this, kind) }

    private lateinit var adapter: ProductOverviewRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var dataList: ArrayList<ProductOverviewData> = ArrayList()

        adapter = ProductOverviewRecyclerViewAdapter(context!!, dataList)
        rv_product_overview_all.adapter = adapter
        rv_product_overview_all.layoutManager = GridLayoutManager(context!!, 3)

        presenter.onActivityCreated()
    }
}