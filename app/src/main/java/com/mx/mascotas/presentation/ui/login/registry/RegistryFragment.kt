package com.mx.mascotas.presentation.ui.login.registry

import android.os.Bundle
import android.view.View
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.repository.UserDataRepository
import com.mx.mascotas.databinding.FragmentRegistryBinding
import com.mx.mascotas.domain.usecase.registry.RegistryUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_registry.*

class RegistryFragment : BaseFragment<FragmentRegistryBinding,RegistryViewModel>(),RegistryContract.Navigator{
    private val scheduler by lazy { MascotasAplication.scheduler }

    override fun getIdLayout(): Int {
        return R.layout.fragment_registry
    }

    override fun getBindingVariable(): Int {
        return BR.registryViewModel
    }

    override fun getViewModel(): RegistryViewModel {
        return RegistryViewModel(scheduler,this,RegistryUseCaseImpl(UserDataRepository()))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button2.setOnClickListener {
            getViewModel().register(email.toString(),pwd_register.toString(),name.toString())
        }
    }

}