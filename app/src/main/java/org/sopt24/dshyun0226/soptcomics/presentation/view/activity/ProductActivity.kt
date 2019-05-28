package org.sopt24.dshyun0226.soptcomics.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import khronos.Dates
import kotlinx.android.synthetic.main.activity_product.*
import kotlinx.android.synthetic.main.toolbar_product.*
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.presentation.adapter.WebtoonListAdapter
import org.sopt24.dshyun0226.soptcomics.domain.model.WebToonData
import java.util.*

class ProductActivity : AppCompatActivity() {

    lateinit var adapter: WebtoonListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val title = intent.getStringExtra("title")
        txt_toolbar_product_title.text = title

        btn_toolbar_product_like.setOnClickListener {
            btn_toolbar_product_like.isSelected = !btn_toolbar_product_like.isSelected
        }

        btn_toolbar_product_back.setOnClickListener {
            finish()
        }

        initWebtoonList()
    }

    private fun initWebtoonList() {
        val data = ArrayList<WebToonData>()

        // api 콜로 대체될 것이다.
        data.add(
            WebToonData(
                0,
                "https://upload.wikimedia.org/wikipedia/commons/6/66/180524_%EA%B9%80%ED%8F%AC%EA%B3%B5%ED%95%AD_%ED%8A%B8%EC%99%80%EC%9D%B4%EC%8A%A4_%EC%82%AC%EB%82%98.jpg",
                "1화. 문어지지 말자!",
                130000,
                Dates.of(year = 2019, month = 3, day = 25)
            )
        )
        data.add(
            WebToonData(
                1,
                "https://upload.wikimedia.org/wikipedia/commons/6/66/180524_%EA%B9%80%ED%8F%AC%EA%B3%B5%ED%95%AD_%ED%8A%B8%EC%99%80%EC%9D%B4%EC%8A%A4_%EC%82%AC%EB%82%98.jpg",
                "2화. 문어지지 말자 우리!",
                130000,
                Dates.of(year = 2019, month = 3, day = 26)
            )
        )
        data.add(
            WebToonData(
                2,
                "https://upload.wikimedia.org/wikipedia/commons/6/66/180524_%EA%B9%80%ED%8F%AC%EA%B3%B5%ED%95%AD_%ED%8A%B8%EC%99%80%EC%9D%B4%EC%8A%A4_%EC%82%AC%EB%82%98.jpg",
                "3화. 타코야끼를 먹다.",
                130000,
                Dates.of(year = 2019, month = 3, day = 27)
            )
        )
        data.add(
            WebToonData(
                3,
                "https://upload.wikimedia.org/wikipedia/commons/6/66/180524_%EA%B9%80%ED%8F%AC%EA%B3%B5%ED%95%AD_%ED%8A%B8%EC%99%80%EC%9D%B4%EC%8A%A4_%EC%82%AC%EB%82%98.jpg",
                "4화. 문어숙회를 먹다.",
                130000,
                Dates.of(year = 2019, month = 3, day = 28)
            )
        )
        data.add(
            WebToonData(
                4,
                "https://upload.wikimedia.org/wikipedia/commons/6/66/180524_%EA%B9%80%ED%8F%AC%EA%B3%B5%ED%95%AD_%ED%8A%B8%EC%99%80%EC%9D%B4%EC%8A%A4_%EC%82%AC%EB%82%98.jpg",
                "5화. 문어빵을 먹다.",
                130000,
                Dates.of(year = 2019, month = 3, day = 29)
            )
        )
        data.add(
            WebToonData(
                5,
                "https://upload.wikimedia.org/wikipedia/commons/6/66/180524_%EA%B9%80%ED%8F%AC%EA%B3%B5%ED%95%AD_%ED%8A%B8%EC%99%80%EC%9D%B4%EC%8A%A4_%EC%82%AC%EB%82%98.jpg",
                "6화 배부른 문어",
                130000,
                Dates.of(year = 2019, month = 3, day = 30)
            )
        )

        adapter = WebtoonListAdapter(this, data)
        rv_product_activity.adapter = adapter
        rv_product_activity.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
    }
}
