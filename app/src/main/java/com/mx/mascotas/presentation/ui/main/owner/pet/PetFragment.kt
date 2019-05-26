package com.mx.mascotas.presentation.ui.main.owner.pet

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.repository.PetDataRepository
import com.mx.mascotas.databinding.FragmentPetBinding
import com.mx.mascotas.domain.usecase.pet.PetUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_pet.*

class PetFragment: BaseFragment<FragmentPetBinding,PetViewModel>(),PetContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { PetViewModel(scheduler,this,PetUseCaseImpl(PetDataRepository())) }

    override fun getIdLayout(): Int {
        return R.layout.fragment_pet
    }

    override fun getBindingVariable(): Int {
        return BR.petViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subcribeToLiveData()
    }

    override fun getViewModel(): PetViewModel {
        return viewModelI
    }
    fun subcribeToLiveData(){

        viewModelI.userLiveData.observe(this, Observer {
            textInputLayout9.error = it
        })
        viewModelI.raceLiveData.observe(this, Observer {
            textInputLayout10.error = it
        })
        viewModelI.weightLiveData.observe(this, Observer {
            textInputLayout11.error = it
        })
        viewModelI.dateBornLiveData.observe(this, Observer {
            textInputLayout12.error = it
        })
        viewModelI.signsLiveData.observe(this, Observer {
            textInputLayout15.error = it
        })
        viewModelI.allergyLiveData.observe(this, Observer {
            textInputLayout18.error = it
        })
        viewModelI.listCatPat.observe(this, Observer {
            it?.let {
                viewModelI.addCatType(it)
            }
        })
    }

    override fun showMessage(msg: String) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }
}