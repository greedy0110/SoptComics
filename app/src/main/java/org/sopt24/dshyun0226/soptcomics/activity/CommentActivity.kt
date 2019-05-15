package org.sopt24.dshyun0226.soptcomics.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import khronos.Dates
import kotlinx.android.synthetic.main.activity_comment.*
import kotlinx.android.synthetic.main.toolbar_comment.*
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.adapter.CommentAdapter
import org.sopt24.dshyun0226.soptcomics.data.CommentData

class CommentActivity : AppCompatActivity() {

    lateinit var adapter: CommentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        btn_comment_write_comment.setOnClickListener {
            // TODO 댓글쓰는 화면으로 이동되어야한다.
        }

        btn_toolbar_comment_back.setOnClickListener {
            finish()
        }

        initCommentList()
    }

    private fun initCommentList() {
        val data = ArrayList<CommentData>()

        data.add(
            CommentData(0, "https://avatars1.githubusercontent.com/u/16049092?s=460&v=4",
                "솝러버", Dates.of(year = 2019, month = 3, day = 25, hour = 23, minute = 21, second = 38),
                "문어에 대한 내용이 아주 유익하네요. 추천드려요! 다들 꼭 보시길~ ^^")
        )
        data.add(
            CommentData(0, "https://avatars1.githubusercontent.com/u/16049092?s=460&v=4",
                "솝맘", Dates.of(year = 2019, month = 3, day = 25, hour = 23, minute = 21, second = 38),
                "타코야끼가 생각나는 웹툰이에요 :) 타코야끼 먹으면서 읽는 거 추천!")
        )
        data.add(
            CommentData(0, "https://avatars1.githubusercontent.com/u/16049092?s=460&v=4",
                "조총무", Dates.of(year = 2019, month = 3, day = 25, hour = 23, minute = 21, second = 38),
                "심심할 때 할 게 없다면 이 웹툰을 읽어보세요!!! _맑고 깨끗한 조총무")
        )
        data.add(
            CommentData(0, "https://avatars1.githubusercontent.com/u/16049092?s=460&v=4",
                "김스윗", Dates.of(year = 2019, month = 3, day = 25, hour = 23, minute = 21, second = 38),
                "감동적인 이야기 입니다... 아주 스윗한 웹툰이네요ㅠㅋㅋㅋㅋㅋ")
        )
        data.add(
            CommentData(0, "https://avatars1.githubusercontent.com/u/16049092?s=460&v=4",
                "신승민", Dates.of(year = 2019, month = 3, day = 25, hour = 23, minute = 21, second = 38),
                "으아아아아 으아아아아아아으아아아아 으아아아아아아으아아아아 으아아아아아아으아아아아 으아아아아아아으아아아아 으아아아아아아으아아아아 으아아아아아아으아아아아 으아아아아아아으아아아아 으아아아아아아으아아아아 으아아아아아아으아아아아 으아아아아아아으아아아아 으아아아아아아으아아아아 으아아아아아아")
        )

        // toolbar에 댓글 총 갯수를 명시하자
        txt_toolbar_comment_title.text = "댓글 (${data.size})"

        adapter = CommentAdapter(this, data)
        rv_comment_activity.adapter = adapter
        rv_comment_activity.layoutManager = LinearLayoutManager(this)
    }
}
