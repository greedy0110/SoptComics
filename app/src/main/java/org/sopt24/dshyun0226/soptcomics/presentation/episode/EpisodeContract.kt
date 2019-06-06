package org.sopt24.dshyun0226.soptcomics.presentation.episode

import org.sopt24.dshyun0226.soptcomics.presentation.BaseView

interface EpisodeContract {
    interface View: BaseView<Presenter> {
        fun setTitle(title: String)
        fun updateEpisodeImg(episodeUrl: String)
        fun finish()
        fun goCommentActivity()
    }

    interface Presenter {
        fun onCreate(title: String, episodeIndex: Int)
        fun onBackPress()
        fun onClickComment()
        fun onDestroy()
    }
}