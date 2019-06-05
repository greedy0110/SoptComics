package org.sopt24.dshyun0226.soptcomics.comics_episode_overview

import io.reactivex.Observable
import org.junit.Test

import org.junit.Before
import org.mockito.Matchers
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.presentation.comics_episode_overview.ComicsEpisodeOverviewContract
import org.sopt24.dshyun0226.soptcomics.presentation.comics_episode_overview.ComicsEpisodeOverviewPresenter

class ComicsEpisodeOverviewPresenterTest {
    private lateinit var presenter: ComicsEpisodeOverviewContract.Presenter
    @Mock private lateinit var view: ComicsEpisodeOverviewContract.View
    @Mock private lateinit var api: SoptComicsApi

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)

        presenter = ComicsEpisodeOverviewPresenter(
            view = view,
            api = api
        )
    }

    @Test
    fun onCreateThenSettingTitle(){
        presenter.onCreate("title")

        verify(view).setTitle("title")
    }

    @Test
    fun onClickLikeThenUpdateLikeButtonSelected(){
        `when`(view.isLikeButtonSelected).thenReturn(true)
        presenter.onClickLike()
        verify(view).setUnlike()
        verify(view).isLikeButtonSelected = false

        `when`(view.isLikeButtonSelected).thenReturn(false)
        presenter.onClickLike()
        verify(view).setLike()
        verify(view).isLikeButtonSelected = true
    }

    @Test
    fun onBackPressThenFinish() {
        presenter.onBackPress()

        verify(view).finish()
    }

    @Test
    fun onCreateThenInitEpisodeOverviewList(){
        presenter.onCreate("title")

        verify(api).requestComicsEpisodeOverviewList()
        verify(view).updateComicsEpisodeOverviewList()
    }
}