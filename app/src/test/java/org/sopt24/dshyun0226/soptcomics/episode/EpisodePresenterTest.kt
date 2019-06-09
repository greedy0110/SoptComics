package org.sopt24.dshyun0226.soptcomics.episode

import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.sopt24.dshyun0226.soptcomics.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.presentation.episode.EpisodeContract
import org.sopt24.dshyun0226.soptcomics.presentation.episode.EpisodePresenter

class EpisodePresenterTest {
    private lateinit var presenter: EpisodeContract.Presenter
    @Mock private lateinit var view: EpisodeContract.View
    @Mock private lateinit var api: SoptComicsApi

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)

        presenter = EpisodePresenter(
            view = view,
            api = api
        )

        `when`(api.requestEpisodeImageUrl(Matchers.anyInt())).thenReturn(
            Observable.just("")
        )
    }

    @Test
    fun onCreateThenSettingTitle() {
        presenter.onCreate("title", 1)

        verify(view).setTitle("title")
    }

    @Test
    fun onCreateThenLoadEpisodeImage() {
        presenter.onCreate("title", 1)

        verify(api).requestEpisodeImageUrl(1)
        verify(view).updateEpisodeImg(Matchers.anyString())
    }

    @Test
    fun onBackPressThenFinish() {
        presenter.onBackPress()

        verify(view).finish()
    }

    @Test
    fun onClickCommentThenGotoCommentActivity() {
        presenter.onClickComment()

        verify(view).goCommentActivity()
    }
}