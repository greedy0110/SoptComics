package org.sopt24.dshyun0226.soptcomics.presentation.comics_episode_overview

import org.sopt24.dshyun0226.soptcomics.presentation.view.BaseView

interface ComicsEpisodeOverviewContract {
    interface View: BaseView<Presenter>{
        var isLikeButtonSelected: Boolean

        fun setTitle(title: String)
        fun setUnlike()
        fun setLike()
        fun finish()
        fun updateComicsEpisodeOverviewList()
    }

    interface Presenter {
        fun onCreate(title: String)
        fun onClickLike()
        fun onBackPress()
    }
}