package com.mx.mascotas.presentation.base

import androidx.lifecycle.ViewModel
import com.mx.mascotas.data.repository.ScheduleProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<N,U>(var scheduleProvider: ScheduleProvider, var navigator: N, var useCase : U): ViewModel() {
    protected val compositeDisposable by lazy {
        CompositeDisposable()
    }

    protected fun onClean(){
        compositeDisposable.let { it.dispose() }
    }
}