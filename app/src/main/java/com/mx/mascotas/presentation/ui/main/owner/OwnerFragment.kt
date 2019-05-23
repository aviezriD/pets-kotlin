package com.mx.mascotas.presentation.ui.main.owner

import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.databinding.FragmentOwnerBinding
import com.mx.mascotas.domain.usecase.owner.OwnerUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment

class OwnerFragment: BaseFragment<FragmentOwnerBinding,OwnerViewModel>(),OwnerContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { OwnerViewModel(scheduler,this,OwnerUseCaseImpl()) }

    override fun getIdLayout(): Int {
        return R.layout.fragment_owner
    }

    override fun getBindingVariable(): Int {
        return BR.ownerViewModel
    }

    override fun getViewModel(): OwnerViewModel {
        return viewModelI
    }
}