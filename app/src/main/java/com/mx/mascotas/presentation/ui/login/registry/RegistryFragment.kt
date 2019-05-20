package com.mx.mascotas.presentation.ui.login.registry

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
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
    private val viewModelI by lazy { RegistryViewModel(scheduler,this,RegistryUseCaseImpl(UserDataRepository())) }

    override fun getIdLayout(): Int {
        return R.layout.fragment_registry
    }

    override fun getBindingVariable(): Int {
        return BR.registryViewModel
    }

    override fun getViewModel(): RegistryViewModel {
        return  RegistryViewModel(scheduler,this,RegistryUseCaseImpl(UserDataRepository()))

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subcribeToLiveData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button2.setOnClickListener {
            viewModelI.register(
                user_register.text.toString() ,
                email_register.text.toString(),
                pwd_register.text.toString(),
                pwd_register2.text.toString(),
                name.text.toString()
            )
        }
    }

    fun subcribeToLiveData(){
        viewModelI.mutable.observe(this, Observer {
            it?.let {

            }
        })
    }

}