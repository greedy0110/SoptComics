package org.sopt24.dshyun0226.soptcomics.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 앱에 필요한 사전 로딩작업을 해야한다.

        startActivity<MainActivity>() // 로딩이 끝나고 다음 화면으로 넘어간다.
        finish()
    }
}
