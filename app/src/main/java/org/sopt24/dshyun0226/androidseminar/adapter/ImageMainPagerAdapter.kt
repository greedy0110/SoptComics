package org.sopt24.dshyun0226.androidseminar.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import org.sopt24.dshyun0226.androidseminar.fragment.Image1Fragment
import org.sopt24.dshyun0226.androidseminar.fragment.Image2Fragment
import org.sopt24.dshyun0226.androidseminar.fragment.Image3Fragment

class ImageMainPagerAdapter(fm: FragmentManager?, private val num_fragment: Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment? {
        return when(p0) {
            0 -> Image1Fragment()
            1 -> Image2Fragment()
            2 -> Image3Fragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return num_fragment
    }
}