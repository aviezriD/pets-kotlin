package com.mx.mascotas.presentation.ui.main.owner.pet

import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.databinding.FragmentPetBinding
import com.mx.mascotas.domain.usecase.pet.PetUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment

class PetFragment: BaseFragment<FragmentPetBinding,PetViewModel>(),PetContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { PetViewModel(scheduler,this,PetUseCaseImpl()) }

    override fun getIdLayout(): Int {
        return R.layout.fragment_pet
    }

    override fun getBindingVariable(): Int {
        return BR.petViewModel
    }

    override fun getViewModel(): PetViewModel {
        return viewModelI
    }
}