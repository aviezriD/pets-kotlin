package com.mx.mascotas.presentation.ui.main.common.profile

import android.os.Bundle
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.repository.UserDataRepository
import com.mx.mascotas.domain.repository.PreferenceRepository
import com.mx.mascotas.domain.repository.UserRepository
import com.mx.mascotas.domain.usecase.profile.ProfileUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment

class ProfileFragment:BaseFragment<com.mx.mascotas.databinding.FragmentProfileBinding,ProfileViewModel>(),ProfileContract.Navigator {

    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy {ProfileViewModel(scheduler,this,ProfileUseCaseImpl(UserDataRepository(),MascotasAplication.application.appPreferences))}
    override fun getIdLayout(): Int {
        return R.layout.fragment_profile
    }

    override fun getBindingVariable(): Int {
        return BR.profileViewModel
    }

    override fun getViewModel(): ProfileViewModel {
        return viewModelI
    }


}