package org.sopt24.dshyun0226.soptcomics.presentation.comics_episode_overview

import org.sopt24.dshyun0226.soptcomics.domain.model.ComicsEpisodeOverviewData
import org.sopt24.dshyun0226.soptcomics.presentation.BaseView

interface ComicsEpisodeOverviewContract {
    interface View: BaseView<Presenter> {
        var isLikeButtonSelected: Boolean

        fun setTitle(title: String)
        fun setUnlike()
        fun setLike()
        fun finish()
        fun updateComicsEpisodeOverviewList(episodeOverviewList: List<ComicsEpisodeOverviewData>)
    }

    interface Presenter {
        fun onCreate(title: String, comicsIdx: Int)
        fun onClickLike()
        fun onBackPress()
        fun onDestroy()
    }
}