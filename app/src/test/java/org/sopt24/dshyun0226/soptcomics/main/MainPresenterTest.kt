package org.sopt24.dshyun0226.soptcomics.main

import org.junit.Test
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.sopt24.dshyun0226.soptcomics.domain.repository.UserDataSource
import org.sopt24.dshyun0226.soptcomics.presentation.main.MainContract
import org.sopt24.dshyun0226.soptcomics.presentation.main.MainPresenter

class MainPresenterTest {
    private lateinit var mainPresenter: MainPresenter

    @Mock private lateinit var mainView: MainContract.View
    // 얘를 mocking을 안하면 안드로이드 종속성 (userRepository의 Shared .) 가 들어간다.
    @Mock private lateinit var userDataSource: UserDataSource

    @Before
    fun setupMainPresenter() {
        MockitoAnnotations.initMocks(this)

        mainPresenter = MainPresenter(
            view = mainView,
            userDataSource = userDataSource
        )
    }

    @Test
    fun clickToolbarMainActionAndIfAlreadyLoggedInThenLogout() {
        // already logged in
        `when`(userDataSource.getUserToken()).thenReturn("token")

        mainPresenter.clickToolbarMainAction()

        verify(userDataSource).clearUserToken() // then logout
        verify(mainView).setToolbarMainActionButton(false)
    }

    @Test
    fun clickToolbarMainActionAndIfAlreadyLoggedOutThenStartLogin() {
        // already logged out
        `when`(userDataSource.getUserToken()).thenReturn("")

        mainPresenter.clickToolbarMainAction()

        verify(mainView).startLoginActivity()
    }

    @Test
    fun onCreateThenConfigureUI() {
        mainPresenter.onCreate()

        verify(mainView).configureMainTab()
        verify(mainView).configureMainImageTab()
    }

    @Test
    fun onResumeThenConfigureToolbarMainActionButton() {
        // already logged in
        `when`(userDataSource.getUserToken()).thenReturn("token")

        mainPresenter.onResume()

        verify(mainView).setToolbarMainActionButton(true)
    }
}