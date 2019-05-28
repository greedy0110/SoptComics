package org.sopt24.dshyun0226.soptcomics.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar_webtoon.*
import org.jetbrains.anko.startActivity
import org.sopt24.dshyun0226.soptcomics.R

class WebtoonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webtoon)

        val title = intent.getStringExtra("title")

        txt_toolbar_webtoon_title.text = title

        btn_toolbar_webtoon_back.setOnClickListener {
            finish()
        }

        btn_toolbar_webtoon_comment.setOnClickListener {
            // TODO 댓글 액티비티로 정보를 넘기며 시작
            startActivity<CommentActivity>()
        }
    }
}
