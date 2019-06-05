package org.sopt24.dshyun0226.soptcomics.presentation.main


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.sopt24.dshyun0226.soptcomics.presentation.adapter.ProductMainPagerAdapter
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.presentation.login.LoginActivity
import org.sopt24.dshyun0226.soptcomics.presentation.adapter.ImageMainPagerAdapter
import org.sopt24.dshyun0226.soptcomics.presentation.main.MainContract

class MainActivity : AppCompatActivity(), MainContract.View {
    override val presenter: MainContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onCreate()

        // 사용자의 인풋을 받는 부분 세부 내용은 userDataSource 참고해서 view를 변경하는 일
        img_toolbar_main_action.setOnClickListener {
            presenter.clickToolbarMainAction()
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun configureMainTab() {
        vp_main_product.adapter =
            ProductMainPagerAdapter(supportFragmentManager, 3)
        vp_main_product.offscreenPageLimit = 2 // *현재 있는 fragment 기준으로 왼쪽으로 오른쪽으로 몇개의 fragment 정보를 살려준다! -> 2니까 총 5개의 fragment*
        tl_main_category.setupWithViewPager(vp_main_product)

        // tab layout 에 한칸 한칸을 지정해준다
        val navCategoryMainLayout: View = (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.navigation_category_main, null, false)
        tl_main_category.getTabAt(0)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_all) as RelativeLayout
        tl_main_category.getTabAt(1)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_new) as RelativeLayout
        tl_main_category.getTabAt(2)!!.customView = navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_end) as RelativeLayout
    }

    override fun updateBannerImageList(bannerImgUrls: List<String>) {
        vp_main_image.adapter = ImageMainPagerAdapter(supportFragmentManager, bannerImgUrls)
        tl_main_image.setupWithViewPager(vp_main_image)
    }

    override fun setToolbarMainActionButton(isLoggedIn: Boolean) {
        img_toolbar_main_action.isSelected = isLoggedIn
    }

    override fun startLoginActivity() {
        startActivity<LoginActivity>()
    }
}

