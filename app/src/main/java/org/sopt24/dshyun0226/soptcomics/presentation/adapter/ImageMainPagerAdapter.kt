package org.sopt24.dshyun0226.soptcomics.presentation.adapter

import android.os.Bundle
import org.sopt24.dshyun0226.soptcomics.presentation.view.fragment.SliderMainFragment

class ImageMainPagerAdapter(fm: androidx.fragment.app.FragmentManager?, private val bannerImgUrls: List<String>) : androidx.fragment.app.FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): androidx.fragment.app.Fragment? {
        val fragment = SliderMainFragment()
        val bundle = Bundle(1)

        bundle.putString("background_url", bannerImgUrls[p0])

        fragment.arguments = bundle
        return fragment
    }

    override fun getCount(): Int = bannerImgUrls.size
}