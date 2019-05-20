package com.mx.mascotas.presentation.ui.login

import android.os.Bundle
import android.view.WindowManager
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.databinding.ActivityLoginBinding
import com.mx.mascotas.domain.usecase.login.LoginUseCaseImpl
import com.mx.mascotas.presentation.base.BaseActivity
import com.mx.mascotas.presentation.ui.login.splash.SplashFragment
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }

    override fun getIdLayout(): Int {
        return R.layout.activity_login
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): LoginViewModel {
        return LoginViewModel(scheduler,this,LoginUseCaseImpl())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        super.onCreate(savedInstanceState)
        goFragment(container.id, SplashFragment())
    }

}