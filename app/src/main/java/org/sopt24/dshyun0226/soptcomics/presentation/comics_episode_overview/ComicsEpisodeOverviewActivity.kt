package org.sopt24.dshyun0226.soptcomics.presentation.comics_episode_overview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.toolbar_product.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.presentation.adapter.WebtoonListAdapter
import org.sopt24.dshyun0226.soptcomics.domain.model.ComicsEpisodeOverviewData

class ComicsEpisodeOverviewActivity : AppCompatActivity(), ComicsEpisodeOverviewContract.View {

    override var isLikeButtonSelected: Boolean = false

    override fun setTitle(title: String) {
        txt_toolbar_product_title.text = title
    }

    override fun setUnlike() {
        btn_toolbar_product_like.isSelected = false
    }

    override fun setLike() {
        btn_toolbar_product_like.isSelected = true
    }

    override fun updateComicsEpisodeOverviewList(episodeOverviewList: List<ComicsEpisodeOverviewData>) {
        adapter.data = episodeOverviewList
        adapter.notifyDataSetChanged()
    }

    override val presenter: ComicsEpisodeOverviewContract.Presenter by inject { parametersOf(this) }

    lateinit var adapter: WebtoonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        initWebtoonList()

        val title = intent.getStringExtra("title")
        val c_idx = intent.getIntExtra("idx", 0)

        presenter.onCreate(title, c_idx)

        btn_toolbar_product_like.setOnClickListener {
            presenter.onClickLike()
        }

        btn_toolbar_product_back.setOnClickListener {
            presenter.onBackPress()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun initWebtoonList() {
        adapter = WebtoonListAdapter(this, listOf())
        rv_product_activity.adapter = adapter
        rv_product_activity.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
    }
}
