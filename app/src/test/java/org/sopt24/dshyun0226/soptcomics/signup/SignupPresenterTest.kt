package org.sopt24.dshyun0226.soptcomics.signup

import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.api.response.PostSignupResponse
import org.sopt24.dshyun0226.soptcomics.presentation.signup.SignupContract
import org.sopt24.dshyun0226.soptcomics.presentation.signup.SignupPresenter

class SignupPresenterTest {
    private lateinit var signupPresenter: SignupPresenter

    @Mock private lateinit var signupView: SignupContract.View
    @Mock private lateinit var api : SoptComicsApi


    @Before
    fun setupSignupPresenterTest() {
        MockitoAnnotations.initMocks(this)

        `when`(api.requestSignup(Matchers.anyString(), Matchers.anyString(), Matchers.anyString()))
            .thenReturn(Observable.just(
                PostSignupResponse(
                    status = 201, success = true, message = "success"
                )
            ))

        signupPresenter =
            SignupPresenter(view = signupView, api = api)
    }

    // 이름을 입력 안하고 회원가입을 요청하면 이름 입력에 포커스를 준다.
    @Test
    fun requestSignupWithoutNameAndFocusNameEdit(){
        signupPresenter.signup(name = "", id = "123", pw = "123")

        verify(signupView).focusEditSignupName()
    }

    // 아이디 입력을 안하고 회원가입을 요청하면 아이디 입력에 포커스를 준다.
    @Test
    fun requestSignupWithoutIDAndFocusIDEdit(){
        signupPresenter.signup(name = "123", id = "", pw = "123")

        verify(signupView).focusEditSignupID()
    }

    // 비밀번호 입력을 안하고 회원가입을 요청하면 비밀번호 입력에 포커스를 준다.
    @Test
    fun requestSignupWithoutPWAndFocusPWEdit(){
        signupPresenter.signup(name = "123", id = "123", pw = "")

        verify(signupView).focusEditSignupPW()
    }

    // 회원가입을 요청하고 완수되면 뷰를 종료시킨다.
    @Test
    fun successSignupAndFinishView() {
        signupPresenter.signup(name = "123", id = "123", pw = "123")

        verify(api).requestSignup(Matchers.anyString(), Matchers.anyString(), Matchers.anyString())
        verify(signupView).finish()
    }
}