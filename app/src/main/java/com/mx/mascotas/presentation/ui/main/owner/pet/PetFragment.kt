package com.mx.mascotas.presentation.ui.main.owner.pet

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.core.view.get
import androidx.lifecycle.Observer
import com.mx.mascotas.BR
import com.mx.mascotas.BuildConfig
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.database.entity.CatPet
import com.mx.mascotas.data.database.entity.CatPetSize
import com.mx.mascotas.data.repository.PetDataRepository
import com.mx.mascotas.databinding.FragmentPetBinding
import com.mx.mascotas.domain.usecase.pet.PetUseCaseImpl
import com.mx.mascotas.presentation.base.BaseFragment
import com.mx.mascotas.presentation.ui.utils.Utils
import com.mx.mascotas.presentation.ui.utils.Utils.generaDatePickerDialog
import kotlinx.android.synthetic.main.fragment_pet.*
import kotlinx.android.synthetic.main.fragment_pet.checks
import kotlinx.android.synthetic.main.fragment_pet.view.*
import java.io.File
import java.io.IOException

class PetFragment: BaseFragment<FragmentPetBinding,PetViewModel>(),PetContract.Navigator,
    AdapterView.OnItemSelectedListener {
    private val scheduler by lazy { MascotasAplication.scheduler }
    private val viewModelI by lazy { PetViewModel(scheduler,this,PetUseCaseImpl(PetDataRepository(),MascotasAplication.application.appPreferences)) }
    private var photo = ""
    private val REQUEST_CODE_TAKE_PHOTO = 100
    private var photoFile : File? = null
    private var type = 0
    private var typeSize = 0
    private var sex = false
    private var id = ""

    override fun getIdLayout(): Int {
        return R.layout.fragment_pet
    }

    override fun getBindingVariable(): Int {
        return BR.petViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         arguments?.let {
             id = it.getString("id","")
         }
        subcribeToLiveData()

    }

    override fun getViewModel(): PetViewModel {
        return viewModelI
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        date.setOnTouchListener { v, event ->
            if (v.id == date.id && event.action == 0 )
                generaDatePickerDialog(date,true,view.context)
            true
        }
        button5.setOnClickListener {
            viewModelI.register(
                pet_name.text.toString().trim(),
                pet_race.text.toString().trim(),
                pet_weigth.text.toString().trim(),
                typeSize,// sizeType
                type, //type
                sex ,//sex
                pet_allergy.text.toString().trim(),
                date.text.toString().trim(),
                pet_signs.text.toString().trim(),
                photo
            )
        }
        checks.setOnCheckedChangeListener { group, checkedId ->
            sex = if (checkedId == R.id.m) false else true
        }

        button4.setOnClickListener {

            context?.let {
                val pm = it.packageManager

                if (pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {

                    val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    try {
                        photoFile = Utils.createImageFile()

                    } catch (ex: IOException) {

                        Toast.makeText(it,"Error creando el archivo",Toast.LENGTH_SHORT).show()
                    }

                    photoFile?.let { f1 ->
                        takePictureIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        takePictureIntent.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            FileProvider.getUriForFile(it, BuildConfig.APPLICATION_ID, f1)
                        )

                        startActivityForResult(takePictureIntent, REQUEST_CODE_TAKE_PHOTO)
                    }
                } else {
                    Toast.makeText(it,"La camara no esta disponible",Toast.LENGTH_SHORT).show()
                }
            }
        }

        spinner.onItemSelectedListener = this
        spinner2.onItemSelectedListener = this
        if (id.isNotEmpty())
            viewModelI.getPetById(id)

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        parent?.let {
            when(it.selectedItem ){
                is  CatPet -> type = (it.selectedItem  as CatPet).id
                is CatPetSize -> typeSize = (it.selectedItem  as CatPetSize).id
            }
        }
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
        viewModelI.listCatPatSize.observe(this, Observer {
            it?.let {
                viewModelI.addCatTypeSize(it)
            }
        })

        viewModelI.petEdit.observe(this, Observer {

            it?.let {
                pet_name.append(it.name)
                pet_race.append(it.race)
                pet_weigth.append(it.weight.toString())
                type = it.type
                typeSize = it.typeSize
                sex = it.sex
                if (sex){
                    w.isChecked = true
                }
                pet_allergy.append(it.allergy)
                date.append(Utils.longToDate(it.dateBorn))
                pet_signs.append(it.signs)
                button4?.text = "CAMBIAR FOTO"
                button5?.text = "ACTUALIZAR"
                viewModelI.setIndices(it.type,it.typeSize)
            }
        })
    }

    override fun showMessage(msg: String) {
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_TAKE_PHOTO) run {

            button4?.text = "CAMBIAR FOTO"

            context?.let {
                try {
                    photo = photoFile?.toURI().toString()
                } catch (e: Exception) {
                    e.printStackTrace()
                    Toast.makeText(context,"Ha ocurrido un error ",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun success() {
        activity?.let {
            it.onBackPressed()
        }
    }
}