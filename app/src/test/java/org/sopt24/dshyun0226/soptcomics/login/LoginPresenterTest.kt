package org.sopt24.dshyun0226.soptcomics.login

import io.reactivex.Observable
import org.junit.Test

import org.junit.Before
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.domain.repository.UserDataSource
import org.sopt24.dshyun0226.soptcomics.presentation.login.LoginContract
import org.sopt24.dshyun0226.soptcomics.presentation.login.LoginPresenter

class LoginPresenterTest {
    private lateinit var loginPresenter: LoginPresenter

    // 테스트를 하려다 보니까 실제 데이터를 받아오는 repository 가 인터페이스화 되어야 한다. unit test 에서는 ctx를 넘길 수 가 없다.
    @Mock private lateinit var loginView: LoginContract.View
    @Mock private lateinit var userRepository: UserDataSource
    @Mock private lateinit var api: SoptComicsApi

    @Before
    fun setupLoginPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this)

        `when`(api.requestToken(Matchers.anyString(), Matchers.anyString())).thenReturn(Observable.just("123"))

        loginPresenter = LoginPresenter(
            view = loginView,
            api = api,
            userDataSource = userRepository
        )
    }

    // 로그인 눌렀는데 아이디가 없는 경우 login id 에 포커스 이동
    @Test
    fun loginWithoutIdAndFocusEditID(){
        loginPresenter.login("", "password")

        verify(loginView).focusEditLoginID()
    }

    // 로그인 눌렀는데 비밀번호가 없는 경우 login password 에 포커스 이동
    @Test
    fun loginWithoutPWAndFocusEditPW(){
        loginPresenter.login("id", "")

        verify(loginView).focusEditLoginPW()
    }

    // 로그인 눌렀는데 로그인이 성공하는 경우 토큰이 설정되고 view 종료
    @Test
    fun loginSuccessAndSetTokenAndFinishView() {
        loginPresenter.login("id", "password")

        // 비동기적으로 setUserToken 호출되는 중임
        verify(userRepository).setUserToken(Matchers.anyString())
        verify(loginView).finish()
    }

    // 회원가입 누르면 회원가입 화면으로 이동해야 한다.
    @Test
    fun clickSignupThenGotoSignupScreen() {
        loginPresenter.openSignup()

        verify(loginView).openSignup()
    }
}