package org.sopt24.dshyun0226.soptcomics.presentation.comics_episode_overview

class ComicsEpisodeOverviewPresenter(
    private val view: ComicsEpisodeOverviewContract.View
): ComicsEpisodeOverviewContract.Presenter{
    override fun onCreate(title: String) {
        view.setTitle(title)
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