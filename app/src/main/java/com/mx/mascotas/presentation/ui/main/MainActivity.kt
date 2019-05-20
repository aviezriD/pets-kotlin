package com.mx.mascotas.presentation.ui.main

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.databinding.ActivityMainBinding
import com.mx.mascotas.domain.usecase.main.MainUseCaseImpl
import com.mx.mascotas.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(),MainContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_nav, toolbar, R.string.drawer_open, R.string.drawer_close
        )
        drawer_nav.addDrawerListener(toggle)
        toggle.syncState()
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
