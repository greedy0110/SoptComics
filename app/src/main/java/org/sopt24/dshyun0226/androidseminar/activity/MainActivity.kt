package org.sopt24.dshyun0226.androidseminar.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

import org.jetbrains.anko.startActivity
import org.sopt24.dshyun0226.androidseminar.adapter.ProductMainPagerAdapter
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.adapter.ImageMainPagerAdapter
import org.sopt24.dshyun0226.androidseminar.db.SharedPreferenceController
import org.sopt24.dshyun0226.androidseminar.login.LoginActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureTitleBar()
        configureMainImageTab()
        configureMainTab()

        img_toolbar_main_action.setOnClickListener {
            if (SharedPreferenceController.getUserToken(this).isEmpty()) {
                startActivity<LoginActivity>()
            }
            else {
                // 로그아웃
                SharedPreferenceController.clearUserToken(this)
                configureTitleBar()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        configureTitleBar()
    }

    private fun configureTitleBar() {
        img_toolbar_main_action.isSelected = !SharedPreferenceController.getUserToken(this).isEmpty()
    }

    private fun configureMainTab() {
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

    private fun configureMainImageTab() {
        vp_main_image.adapter = ImageMainPagerAdapter(supportFragmentManager, 3)
        tl_main_image.setupWithViewPager(vp_main_image)
    }
}

