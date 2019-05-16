package com.mx.mascotas.presentation.ui.login.sign

import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.databinding.FragmentSignBinding
import com.mx.mascotas.domain.usecase.sign.SignUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment

class SignFragment: BaseFragment<FragmentSignBinding,SignViewModel>(),SignContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }

    override fun getIdLayout(): Int {
        return R.layout.fragment_sign
    }

    override fun getBindingVariable(): Int {
        return BR.signViewModel
    }

    override fun getViewModel(): SignViewModel {
        return SignViewModel(scheduler,this,SignUseCaseImpl())
    }
}