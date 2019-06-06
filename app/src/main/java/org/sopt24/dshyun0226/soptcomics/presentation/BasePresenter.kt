package org.sopt24.dshyun0226.soptcomics.presentation

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter {
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disp: Disposable) {
        compositeDisposable.add(disp)
    }

    fun onDestroy(){
        compositeDisposable.clear()
    }
}