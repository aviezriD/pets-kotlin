package com.mx.mascotas.presentation.ui.main.common.registerdate

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.Observer
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.database.entity.CatService
import com.mx.mascotas.data.database.entity.Pet
import com.mx.mascotas.data.database.entity.User
import com.mx.mascotas.data.repository.DateDataRepository
import com.mx.mascotas.data.repository.PetDataRepository
import com.mx.mascotas.data.repository.UserDataRepository
import com.mx.mascotas.data.repository.VetDataRepository
import com.mx.mascotas.databinding.FragmentRegistroCitaDuenoBinding
import com.mx.mascotas.domain.usecase.owner.OwnerUseCaseImpl
import com.mx.mascotas.domain.usecase.registerdate.RegisterDateUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.presentation.ui.main.owner.OwnerViewModel
import kotlinx.android.synthetic.main.fragment_registro_cita_dueno.*

class RegisterDateFragment : BaseFragment <FragmentRegistroCitaDuenoBinding, RegisterDateViewModel> (),RegisterDateContract.Navigator,AdapterView.OnItemSelectedListener{
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { RegisterDateViewModel(scheduler,this,RegisterDateUseCaseImpl(UserDataRepository(),PetDataRepository(),VetDataRepository(), MascotasAplication.application.appPreferences,DateDataRepository()))}
    var idPet = 0
    var namePet =""
    var service = ""
    var subService = ""
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkbox_bano.setOnCheckedChangeListener { buttonView, isChecked ->
            run {
                checkbox_corte.isChecked = false
                checkbox_oidos.isChecked = false
                subService ="Baño"
            }
        }
        checkbox_corte.setOnCheckedChangeListener { buttonView, isChecked -> run {
            checkbox_bano.isChecked = false
            checkbox_oidos.isChecked = false
            subService ="Corte de pelo"
        }  }
        checkbox_oidos.setOnCheckedChangeListener { buttonView, isChecked ->  }
        run {
            checkbox_bano.isChecked = false
            checkbox_oidos.isChecked = false
            subService ="Limpieza de oídos"
        }

        button2.setOnClickListener {
            viewModelI.registerDate(idPet,namePet,service,subService,"","","","",description_register.text.toString().trim())
        }
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
        viewModelI.listVetDayLive.observe(this, Observer {
            it?.let {
                viewModelI.addCatVetDia(it)
            }
        })
        viewModelI.listVetHourLive.observe(this, Observer {
            it?.let {
                viewModelI.addCatVetHoras(it)
            }
        })
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        parent?.let {

            val temp = it.selectedItem
            when(temp ){
                is CatService ->{service =  (temp as CatService).name}
                is Pet -> { val cota = temp as Pet ; namePet = cota.name ; }
            }
        }
    }
}