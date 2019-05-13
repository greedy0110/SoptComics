package org.sopt24.dshyun0226.androidseminar.login

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.Mockito.anyString
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.sopt24.dshyun0226.androidseminar.data.source.TokenApi
import org.sopt24.dshyun0226.androidseminar.data.source.TokenLocalApi
import org.sopt24.dshyun0226.androidseminar.data.source.UserDataSource

class LoginPresenterTest {
    private lateinit var loginPresenter: LoginPresenter

    @Mock private lateinit var loginView: LoginContract.View
    @Mock private lateinit var userRepository: UserDataSource
    private lateinit var tokenApi: TokenApi

    @Before
    fun setupLoginPresenter() {
        // Mockito has a very convenient way to inject mocks by using the @Mock annotation. To
        // inject the mocks in the test the initMocks method needs to be called.
        MockitoAnnotations.initMocks(this)

        // Demo용 Token Api
        tokenApi = TokenLocalApi()

        loginPresenter = LoginPresenter(tokenApi, userRepository, loginView)
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

        // TODO 우리가 원하는 정확한 값의 token 이 설정되었는지는 검증되지 않는다.
        // 비동기적으로 setUserToken이 호출되는 중임
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