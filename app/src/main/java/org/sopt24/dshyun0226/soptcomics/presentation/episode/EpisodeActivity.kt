package org.sopt24.dshyun0226.soptcomics.presentation.episode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_episode.*
import kotlinx.android.synthetic.main.toolbar_webtoon.*
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.presentation.view.activity.CommentActivity

class EpisodeActivity : AppCompatActivity(), EpisodeContract.View {
    override val presenter: EpisodeContract.Presenter by inject { parametersOf(this) }

    override fun setTitle(title: String) {
        txt_toolbar_webtoon_title.text = title
    }

    override fun updateEpisodeImg(episodeUrl: String) {
        Glide.with(this)
            .load(episodeUrl)
            .into(img_episode)
    }

    override fun goCommentActivity() {
        startActivity<CommentActivity>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode)

        val title: String = intent.getStringExtra("title")
        val e_idx: Int = intent.getIntExtra("e_idx", -1)

        presenter.onCreate(title, e_idx)

        btn_toolbar_webtoon_back.setOnClickListener {
            presenter.onBackPress()
        }

        btn_toolbar_webtoon_comment.setOnClickListener {
            presenter.onClickComment()
        }
    }
}
