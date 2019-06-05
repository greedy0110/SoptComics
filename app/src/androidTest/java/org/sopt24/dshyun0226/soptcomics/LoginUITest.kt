package org.sopt24.dshyun0226.soptcomics

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.sopt24.dshyun0226.soptcomics.presentation.login.LoginActivity


// 1. Find a view -> 2. Perform an action -> 3. Inspect the result
@RunWith(AndroidJUnit4::class)
class LoginUITest {
    // 메 test마다 해당 activity를 실행 할 것이다.
    @get:Rule
    var activityTestRule = ActivityTestRule(LoginActivity::class.java, true, true)

    @Test
    fun typeNothingAndClickLoginButtonThenFocusEditID() {
        onView(withId(R.id.btnLoginSubmit)).perform(click())
        onView(withId(R.id.edtLoginID)).check(matches(hasFocus()))
    }

    @Test
    fun onlyTypeIDAndClickLoginButtonThenFocusEditPW() {
        onView(withId(R.id.edtLoginID)).perform(typeText("greedy0110"))
        Espresso.closeSoftKeyboard() // 이게 없으면 btnLoginSubmit 클릭을 못하네!
        onView(withId(R.id.btnLoginSubmit)).perform(click())
        onView(withId(R.id.edtLoginPW)).check(matches(hasFocus()))
    }

    @Test
    fun correctIDAndPWAndClickLoginButtonThenFinishActivity() {
        // TODO 이 데이터들은 어떤식으로 correct 한걸 항상 유지할 수 있을까? -> mock 서버의 데이터를 사용하면 된다.
        onView(withId(R.id.edtLoginID)).perform(typeText("greedy0110"))
        onView(withId(R.id.edtLoginPW)).perform(typeText("1234"))
        Espresso.closeSoftKeyboard()

        // TODO 통신을 요청하게 되는데 이 부분이 서버 릴리즈 상태에 따라서 로그인 실패할 수 도 있잖아. -> mock 서버를 넘겨줘야한다. 생성시에, 따라서 di를 적용해서 여기서 di를 해주자.
        onView(withId(R.id.btnLoginSubmit)).perform(click())

        // TODO Activity 가 종료한걸 어떻게 테스트할 수 있을까? 혹은 종료하기전에 toast 메시지를 띄워주는 것? -> toast 메시지를 띄우는 것으로 하자. ToastMatcher 구현은 어떤식으로?
    }
}