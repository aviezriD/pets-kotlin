package com.mx.mascotas.presentation.ui.main.common.registerdate

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.PetDataRepository
import com.mx.mascotas.data.repository.UserDataRepository
import com.mx.mascotas.data.repository.VetDataRepository
import com.mx.mascotas.databinding.FragmentRegistroCitaDuenoBinding
import com.mx.mascotas.domain.usecase.owner.OwnerUseCaseImpl
import com.mx.mascotas.domain.usecase.registerdate.RegisterDateUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.presentation.ui.main.owner.OwnerViewModel

class RegisterDateFragment : BaseFragment <FragmentRegistroCitaDuenoBinding, RegisterDateViewModel> (),RegisterDateContract.Navigator,AdapterView.OnItemSelectedListener{
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { RegisterDateViewModel(scheduler,this,RegisterDateUseCaseImpl(UserDataRepository(),PetDataRepository(),VetDataRepository(), MascotasAplication.application.appPreferences))}

        override fun getIdLayout(): Int {

        return R.layout.fragment_registro_cita_dueno
    }

    override fun getViewModel(): RegisterDateViewModel {
        return viewModelI
    }

    override fun getBindingVariable(): Int {
        return BR.registerDateViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subcribeToLiveData()
    }

    fun subcribeToLiveData(){
        viewModelI.listPetLive.observe(this, Observer {
            it?.let {
                viewModelI.addPet(it)
            }
        })
        viewModelI.listServiceLive.observe(this, Observer {
            it?.let {
                viewModelI.addCatService(it)
            }
        })
        viewModelI.listVetLive.observe(this, Observer {
            it?.let {
                viewModelI.addUser(it)
            }
        })
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        parent?.let {
            /*when(it.selectedItem ){
                is  User -> type = (it.selectedItem  as CatPet).id
                is Pet -> typeSize = (it.selectedItem  as CatPetSize).id
            }*/
        }
    }
}