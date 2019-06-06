package org.sopt24.dshyun0226.soptcomics.comment

import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.presentation.comment.CommentContract
import org.sopt24.dshyun0226.soptcomics.presentation.comment.CommentPresenter

class CommentPresenterTest {
    private lateinit var presenter: CommentContract.Presenter
    @Mock lateinit var view: CommentContract.View
    @Mock lateinit var api: SoptComicsApi

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        presenter = CommentPresenter(
            view = view,
            api = api
        )

        `when`(api.requestComments(Matchers.anyInt())).thenReturn(
            Observable.just(listOf())
        )
    }

    @Test
    fun onCreateThenUpdateCommentsList() {
        presenter.onCreate(1)

        verify(api).requestComments(1)
        verify(view).setCommentTitle(Matchers.anyString())
        verify(view).updateComments(listOf())
    }

    @Test
    fun onCreateThenUpdateCommentsCount(){
        presenter.onCreate(1)

        verify(view).setCommentTitle(Matchers.anyString())
    }

    @Test
    fun onClickWriteCommentThenGotoWriteCommentActivity(){
        presenter.onClickWriteComment()

        verify(view).goWriteCommentActivity()
    }

    @Test
    fun onClickBackPressThenFinish() {
        presenter.onBackPress()

        verify(view).finish()
    }
}