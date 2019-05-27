package com.mx.mascotas.presentation.ui.main.owner

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.repository.PetDataRepository
import com.mx.mascotas.databinding.FragmentOwnerBinding
import com.mx.mascotas.domain.usecase.owner.OwnerUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.presentation.ui.main.owner.pet.PetFragment
import com.mx.mascotas.presentation.ui.main.owner.pet.adapter.PetAdapter
import kotlinx.android.synthetic.main.fragment_owner.*

class OwnerFragment: BaseFragment<FragmentOwnerBinding,OwnerViewModel>(),OwnerContract.Navigator {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { OwnerViewModel(scheduler,this,OwnerUseCaseImpl(PetDataRepository(),MascotasAplication.application.appPreferences)) }
    private val adapter by lazy { PetAdapter(emptyList()) }

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
        owner_pet.layoutManager = LinearLayoutManager(context)
        owner_pet.itemAnimator = DefaultItemAnimator()
        owner_pet.setHasFixedSize(true)
        owner_pet.adapter = adapter

        adapter.setOnclickInterface(object : PetAdapter.OnclickPetListener{
            override fun action(id: String, operation: Int) {
                when(operation){
                    0 ->viewModelI.deletePet(id)
                    1 -> goDetail(id)
                }
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subcribeToLiveData()
    }

    fun subcribeToLiveData(){
        viewModelI.listPets.observe(this, Observer {
            it?.let {
                viewModelI.addPets(it)
            }
        })
    }

    override fun goDetail(id: String) {
            goFragment(R.id.container_main,PetFragment().apply {
                val args = Bundle()
                args.putCharSequence("id", id)
                this.arguments = args
            })
    }
}