package org.sopt24.dshyun0226.soptcomics.presentation.comment

import io.reactivex.disposables.CompositeDisposable
import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi

class CommentPresenter (
    private val view: CommentContract.View,
    private val api: SoptComicsApi
): CommentContract.Presenter {
    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(episodeIndex: Int) {
        api.requestComments(episodeIndex)
            .subscribe {
                view.setCommentTitle("댓글 (${it.size})")
                view.updateComments(it)
            }.apply { compositeDisposable.add(this) }
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }

    override fun onClickWriteComment() {
        view.goWriteCommentActivity()
    }

    override fun onBackPress() {
        view.finish()
    }
}