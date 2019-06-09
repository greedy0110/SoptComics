package org.sopt24.dshyun0226.soptcomics.presentation.episode

import io.reactivex.disposables.CompositeDisposable
import org.sopt24.dshyun0226.soptcomics.repository.SoptComicsApi

class EpisodePresenter(
    private val view: EpisodeContract.View,
    private val api: SoptComicsApi
) : EpisodeContract.Presenter {
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(title: String, episodeIndex: Int) {
        view.setTitle(title)

        api.requestEpisodeImageUrl(episodeIndex)
            .subscribe {
                view.updateEpisodeImg(it)
            }.apply { compositeDisposable.add(this) }
    }

    override fun onBackPress() {
        view.finish()
    }

    override fun onClickComment() {
        view.goCommentActivity()
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}