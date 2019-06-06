package org.sopt24.dshyun0226.soptcomics.presentation.comment

import org.sopt24.dshyun0226.soptcomics.domain.model.CommentData
import org.sopt24.dshyun0226.soptcomics.presentation.BaseView

interface CommentContract{
    interface View: BaseView<Presenter> {
        fun updateComments(comments: List<CommentData>)
        fun goWriteCommentActivity()
        fun finish()
        fun setCommentTitle(commentTitle: String)
    }

    interface Presenter {
        fun onCreate(episodeIndex: Int)
        fun onDestroy()
        fun onClickWriteComment()
        fun onBackPress()
    }
}