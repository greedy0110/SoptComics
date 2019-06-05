package org.sopt24.dshyun0226.soptcomics.presentation.comics_episode_overview

import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi

class ComicsEpisodeOverviewPresenter(
    private val view: ComicsEpisodeOverviewContract.View,
    val api: SoptComicsApi
): ComicsEpisodeOverviewContract.Presenter{
    override fun onCreate(title: String, comicsIdx: Int) {
        view.setTitle(title)

        api.requestComicsEpisodeOverviewList(comicsIdx)
            .subscribe {
                view.isLikeButtonSelected = it.first
                view.updateComicsEpisodeOverviewList(it.second)
            }
    }

    override fun onClickLike() {
        if (view.isLikeButtonSelected) {
            view.isLikeButtonSelected = false
            view.setUnlike()
        }
        else {
            view.isLikeButtonSelected = true
            view.setLike()
        }
    }

    override fun onBackPress() {
        view.finish()
    }
}