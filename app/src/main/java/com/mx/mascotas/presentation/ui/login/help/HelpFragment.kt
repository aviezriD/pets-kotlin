package com.mx.mascotas.presentation.ui.login.help

import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.databinding.FragmentHelpBinding
import com.mx.mascotas.domain.usecase.help.HelpUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment

class HelpFragment: BaseFragment<FragmentHelpBinding,HelpViewModel>(),HelpContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }

    override fun getIdLayout(): Int {
        return R.layout.fragment_help
    }

    override fun getBindingVariable(): Int {
        return  BR.helpViewModel
    }

    override fun getViewModel(): HelpViewModel {
        return HelpViewModel(scheduler,this,HelpUseCaseImpl())
    }
}