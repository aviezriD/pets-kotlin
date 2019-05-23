package com.mx.mascotas.presentation.ui.main.vet.client

import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.domain.usecase.client.ClientUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment

class ClientFragment: BaseFragment<com.mx.mascotas.databinding.FragmentClientBinding,ClientViewModel>(),ClientContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy {ClientViewModel(scheduler,this,ClientUseCaseImpl())}
    override fun getIdLayout(): Int {
        return R.layout.fragment_client
    }

    override fun getBindingVariable(): Int {
        return BR.clientViewMowel
    }

    override fun getViewModel(): ClientViewModel {
        return viewModelI
    }
}