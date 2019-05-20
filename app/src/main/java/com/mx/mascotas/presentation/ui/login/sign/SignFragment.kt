package com.mx.mascotas.presentation.ui.login.sign

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.databinding.FragmentSignBinding
import com.mx.mascotas.domain.usecase.sign.SignUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.presentation.ui.login.help.HelpFragment
import com.mx.mascotas.presentation.ui.login.registry.RegistryFragment
import com.mx.mascotas.presentation.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_sign.*

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registry.setOnClickListener { goFragment(R.id.container,RegistryFragment()) }
        help_sing.setOnClickListener { goFragment(R.id.container,HelpFragment()) }
        button.setOnClickListener {
            val intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
        }
    }
}