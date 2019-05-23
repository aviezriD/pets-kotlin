package com.mx.mascotas.presentation.ui.login.sign

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.repository.UserDataRepository
import com.mx.mascotas.databinding.FragmentSignBinding
import com.mx.mascotas.domain.usecase.sign.SignUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.presentation.ui.login.help.HelpFragment
import com.mx.mascotas.presentation.ui.login.registry.RegistryFragment
import com.mx.mascotas.presentation.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_sign.*

class SignFragment: BaseFragment<FragmentSignBinding,SignViewModel>(),SignContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { SignViewModel(scheduler,this,SignUseCaseImpl(UserDataRepository(),MascotasAplication.executor, MascotasAplication.application.appPreferences)) }
    private var type = 0

    override fun getIdLayout(): Int {
        return R.layout.fragment_sign
    }

    override fun getBindingVariable(): Int {
        return BR.signViewModel
    }

    override fun getViewModel(): SignViewModel {
        return viewModelI
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subcribeToLiveData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registry.setOnClickListener { goFragment(R.id.container,RegistryFragment()) }
        help_sing.setOnClickListener { goFragment(R.id.container,HelpFragment()) }
        button.setOnClickListener {
            viewModelI.login(user_sign.text.toString().trim(),pwd_sign.text.toString().trim(),type)
        }
        checks.setOnCheckedChangeListener { group, checkedId ->
            Log.i("login","${checkedId == R.id.dueno_l}")
            type = if (checkedId == R.id.dueno_l) 0 else 1
        }
    }

    fun subcribeToLiveData(){
        viewModelI.result.observe(this, Observer { tupla ->
            tupla?.let {
            val (type , msg ) = it
                when(type){
                    1 -> {startActivity(Intent(context,MainActivity::class.java));activity?.finish()}
                    else -> Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
                }
            }

        })
        viewModelI.user.observe(this, Observer {
            textInputLayout.error = it
        })
        viewModelI.pwd.observe(this, Observer {
            textInputLayout2.error = it
        })
    }
}