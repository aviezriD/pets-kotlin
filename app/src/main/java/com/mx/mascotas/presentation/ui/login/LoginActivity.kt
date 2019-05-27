package com.mx.mascotas.presentation.ui.login

import android.Manifest
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.databinding.ActivityLoginBinding
import com.mx.mascotas.domain.usecase.login.LoginUseCaseImpl
import com.mx.mascotas.presentation.base.BaseActivity
import com.mx.mascotas.presentation.ui.login.splash.SplashFragment
import com.tbruyelle.rxpermissions2.RxPermissions
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity: BaseActivity<ActivityLoginBinding, LoginViewModel>(), LoginContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val compositeDisposable by lazy { CompositeDisposable() }

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

        compositeDisposable.add(
            RxPermissions(this)
                .request(Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_NETWORK_STATE
                )
                .subscribe { aBoolean ->
                    if (aBoolean!!) {
                        goFragmentNotBack(container.id, SplashFragment())
                    } else {
                        Toast.makeText(this, "Te sugerimos aceptar los permisos para registar la app",Toast.LENGTH_SHORT).show()
                        Handler().postAtTime({ finish()},3000)
                    }
                }
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}