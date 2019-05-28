package org.sopt24.dshyun0226.soptcomics.presentation.view.adapter

import android.os.Bundle
import org.sopt24.dshyun0226.soptcomics.presentation.view.fragment.SliderMainFragment

class ImageMainPagerAdapter(fm: androidx.fragment.app.FragmentManager?, private val num_fragment: Int) : androidx.fragment.app.FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): androidx.fragment.app.Fragment? {
        val fragment = SliderMainFragment()
        val bundle = Bundle(1)

        when(p0) {
            0 -> bundle.putString("background_url", "https://github.com/bumptech/glide/raw/master/static/glide_logo.png")
            1 -> bundle.putString("background_url", "http://pet.chosun.com/images/news/healthchosun_pet_201802/20180205193238_1635_4749_2414.jpg")
            2 -> bundle.putString("background_url", "https://scontent-icn1-1.xx.fbcdn.net/v/t1.0-9/58383648_1714122605401284_8261916106969579520_o.jpg?_nc_cat=107&_nc_ht=scontent-icn1-1.xx&oh=5685d155cc3622b1535485166619daff&oe=5D756045")
        }
        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int {
        return num_fragment
    }
}