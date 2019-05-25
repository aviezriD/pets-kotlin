package com.mx.mascotas.presentation.ui.login.registry

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.repository.UserDataRepository
import com.mx.mascotas.databinding.FragmentRegistryBinding
import com.mx.mascotas.domain.usecase.registry.RegistryUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.presentation.ui.utils.Constants
import kotlinx.android.synthetic.main.fragment_registry.*

class RegistryFragment : BaseFragment<FragmentRegistryBinding,RegistryViewModel>(),RegistryContract.Navigator{
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { RegistryViewModel(scheduler,this,RegistryUseCaseImpl(UserDataRepository())) }
    private var type = 0

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
                user_register.text.toString().trim() ,
                email_register.text.toString().trim(),
                pwd_register.text.toString().trim(),
                pwd_register2.text.toString().trim(),
                name.text.toString().trim(),
                last_name.text.toString().trim(),
                phone.text.toString().trim(),
                type
            )
        }

        checks.setOnCheckedChangeListener { group, checkedId ->
            type =  if (checkedId== R.id.dueno) 0 else 1
        }
    }

    fun subcribeToLiveData(){
        viewModelI.validatePassword.observe(this, Observer {
            textInputLayout6?.error = it
            textInputLayout7?.error = it
        })

        viewModelI.email.observe(this, Observer {
            textInputLayout5?.error = it
        })
        viewModelI.name.observe(this, Observer {
            textInputLayout4?.error = it
        })
        viewModelI.user.observe(this, Observer {
            textInputLayout3?.error = it
        })
        viewModelI.lastName.observe(this, Observer {
            textInputLayout27?.error = it
        })
        viewModelI.phone.observe(this, Observer {
                    textInputLayout28?.error = it
                })

        viewModelI.result.observe(this, Observer {
            it.let {
                val (type , msg ) = it
                when(type){
                    0 ->{Toast.makeText(context,msg,Toast.LENGTH_LONG).show(); activity?.onBackPressed()}
                    else -> Toast.makeText(context,Constants.REGISTRY.ERROR,Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}