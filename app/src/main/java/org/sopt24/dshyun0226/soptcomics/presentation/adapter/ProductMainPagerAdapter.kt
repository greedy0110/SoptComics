package org.sopt24.dshyun0226.soptcomics.presentation.adapter

import org.sopt24.dshyun0226.soptcomics.presentation.view.fragment.ProductFragment

class ProductMainPagerAdapter(fm: androidx.fragment.app.FragmentManager, private val num_fragment: Int) : androidx.fragment.app.FragmentStatePagerAdapter(fm) {
    companion object { // 어뎁터에서 별도로 fragment 를 관리할 수 있다.
        private var allProductFragment: ProductFragment? = null
        private var newProductMainFragment: ProductFragment? = null
        private var endProductMainFragment: ProductFragment? = null

        @Synchronized
        fun getAllProductMainFragment(): ProductFragment {
            if (allProductFragment == null) allProductFragment = ProductFragment("all")
            return allProductFragment!!
        }

        @Synchronized
        fun getEndProductMainFragment(): ProductFragment {
            if (endProductMainFragment == null) endProductMainFragment = ProductFragment("end")
            return endProductMainFragment!!
        }

        @Synchronized
        fun getNewProductMainFragment(): ProductFragment {
            if (newProductMainFragment == null) newProductMainFragment = ProductFragment("new")
            return newProductMainFragment!!
        }
    }

    // 그떄 그때 생성되는게 아니라 어댑터에서 자체적으로 관리한다는 뜻? -> ㄴㄴ 싱글톤 디자인 패턴을 사용해서 최적화 가능
    // 매번 호출 시마다 새로운 생성자 객체 생성하는데? -> 이러먄 기본 adapter 호출에 따라 조정됨
    override fun getItem(p0: Int): androidx.fragment.app.Fragment? {
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