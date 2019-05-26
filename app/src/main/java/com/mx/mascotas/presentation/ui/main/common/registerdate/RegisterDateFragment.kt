package com.mx.mascotas.presentation.ui.main.common.registerdate

import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.databinding.FragmentRegistroCitaDuenoBinding
import com.mx.mascotas.domain.usecase.owner.OwnerUseCaseImpl
import com.mx.mascotas.domain.usecase.registerdate.RegisterDateUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.presentation.ui.main.owner.OwnerViewModel

class RegisterDateFragment : BaseFragment <FragmentRegistroCitaDuenoBinding, RegisterDateViewModel> (),RegisterDateContract.Navigator{
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { RegisterDateViewModel(scheduler,this,RegisterDateUseCaseImpl())}

        override fun getIdLayout(): Int {

        return R.layout.fragment_registro_cita_dueno
    }

    override fun getViewModel(): RegisterDateViewModel {
        return viewModelI
    }

    override fun getBindingVariable(): Int {
        return BR.registerDateViewModel
    }
}