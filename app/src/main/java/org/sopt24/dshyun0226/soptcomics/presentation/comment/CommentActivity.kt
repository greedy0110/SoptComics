package org.sopt24.dshyun0226.soptcomics.presentation.comment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import khronos.Dates
import kotlinx.android.synthetic.main.activity_comment.*
import kotlinx.android.synthetic.main.toolbar_comment.*
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.presentation.adapter.CommentAdapter
import org.sopt24.dshyun0226.soptcomics.domain.model.CommentData
import org.sopt24.dshyun0226.soptcomics.presentation.view.activity.WriteCommentActivity

class CommentActivity : AppCompatActivity(), CommentContract.View {

    override fun setCommentTitle(commentTitle: String) {
        txt_toolbar_comment_title.text = commentTitle
    }

    override fun updateComments(comments: List<CommentData>) {
        adapter.data = comments
        adapter.notifyDataSetChanged()
    }

    override fun goWriteCommentActivity() {
        startActivity<WriteCommentActivity>()
    }

    override val presenter: CommentContract.Presenter by inject { parametersOf(this) }

    lateinit var adapter: CommentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comment)

        adapter = CommentAdapter(this, listOf())
        rv_comment_activity.adapter = adapter
        rv_comment_activity.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

        btn_comment_write_comment.setOnClickListener {
            presenter.onClickWriteComment()
        }

        btn_toolbar_comment_back.setOnClickListener {
            presenter.onBackPress()
        }
    }
}
