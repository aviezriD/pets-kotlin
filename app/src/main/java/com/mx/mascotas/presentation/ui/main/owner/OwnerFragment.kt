package com.mx.mascotas.presentation.ui.main.owner

import android.os.Bundle
import android.view.View
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.repository.PetDataRepository
import com.mx.mascotas.databinding.FragmentOwnerBinding
import com.mx.mascotas.domain.usecase.owner.OwnerUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.presentation.ui.main.owner.pet.PetFragment
import kotlinx.android.synthetic.main.fragment_owner.*

class OwnerFragment: BaseFragment<FragmentOwnerBinding,OwnerViewModel>(),OwnerContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { OwnerViewModel(scheduler,this,OwnerUseCaseImpl(PetDataRepository(),MascotasAplication.application.appPreferences)) }

    override fun getIdLayout(): Int {
        return R.layout.fragment_owner
    }

    override fun getBindingVariable(): Int {
        return BR.ownerViewModel
    }

    override fun getViewModel(): OwnerViewModel {
        return viewModelI
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        floatingActionButton.setOnClickListener {
            goFragment(R.id.container_main,PetFragment())
        }
    }
}