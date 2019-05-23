package com.mx.mascotas.presentation.ui.login.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.databinding.FragmentSplashBinding
import com.mx.mascotas.domain.usecase.splash.SplashUseCaseImpl
import com.mx.mascotas.presentation.ui.login.sign.SignFragment
import kotlinx.android.synthetic.main.fragment_splash.*


class SplashFragment: BaseFragment<FragmentSplashBinding,SplashViewModel>(), SplashContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val SPLASH_TIME_OUT = 3000L

    override fun getIdLayout(): Int {
        return R.layout.fragment_splash
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getViewModel(): SplashViewModel {
        return SplashViewModel(scheduler,this,SplashUseCaseImpl())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadAnimation()
        Handler().postDelayed({ goFragmentNotBack(R.id.container,SignFragment()) },SPLASH_TIME_OUT)
    }

    private fun loadAnimation(){
        val anim = AnimationUtils.loadAnimation(context, R.anim.alpha)
        val anim2 = AnimationUtils.loadAnimation(context, R.anim.translate)
        setAnimation( splash, anim)
        setAnimation( splash_logo, anim2)
    }

    private fun setAnimation(view : View, anim : Animation){
        anim.reset()
        view.clearAnimation()
        view.startAnimation(anim)
    }
}