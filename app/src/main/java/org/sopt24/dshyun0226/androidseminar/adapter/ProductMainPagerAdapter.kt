package org.sopt24.dshyun0226.androidseminar.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import org.sopt24.dshyun0226.androidseminar.fragment.AllProductMainFragment
import org.sopt24.dshyun0226.androidseminar.fragment.EndProductFragment
import org.sopt24.dshyun0226.androidseminar.fragment.NewProductMainFragment

class ProductMainPagerAdapter(fm: FragmentManager, private val num_fragment: Int) : FragmentStatePagerAdapter(fm) {
    companion object { // 어뎁터에서 별도로 fragment 를 관리할 수 있다.
        private var allProductFragment: AllProductMainFragment? = null
        private var newProductMainFragment: NewProductMainFragment? = null
        private var endProductMainFragment: EndProductFragment? = null

        @Synchronized
        fun getAllProductMainFragment(): AllProductMainFragment {
            if (allProductFragment == null) allProductFragment = AllProductMainFragment()
            return allProductFragment!!
        }

        @Synchronized
        fun getEndProductMainFragment(): EndProductFragment {
            if (endProductMainFragment == null) endProductMainFragment = EndProductFragment()
            return endProductMainFragment!!
        }

        @Synchronized
        fun getNewProductMainFragment(): NewProductMainFragment {
            if (newProductMainFragment == null) newProductMainFragment = NewProductMainFragment()
            return newProductMainFragment!!
        }
    }

    // 그떄 그때 생성되는게 아니라 어댑터에서 자체적으로 관리한다는 뜻? -> ㄴㄴ 싱글톤 디자인 패턴을 사용해서 최적화 가능
    // 매번 호출 시마다 새로운 생성자 객체 생성하는데? -> 이러먄 기본 adapter 호출에 따라 조정됨
    override fun getItem(p0: Int): Fragment? {
        return when (p0) {
            0 -> getAllProductMainFragment()
            1 -> getNewProductMainFragment()
            2 -> getEndProductMainFragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return num_fragment
    }
}