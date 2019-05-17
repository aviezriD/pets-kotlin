package com.mx.mascotas.presentation.ui.main

import android.os.Bundle
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.databinding.ActivityMainBinding
import com.mx.mascotas.domain.usecase.main.MainUseCaseImpl
import com.mx.mascotas.presentation.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(),MainContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getBindingVariable(): Int {
        return BR.mainViewModel
    }

    override fun getIdLayout(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        return MainViewModel(scheduler,this,MainUseCaseImpl())
    }
}
