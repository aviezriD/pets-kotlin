package com.mx.mascotas.presentation.ui.utils


import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.annotation.MenuRes
import androidx.appcompat.widget.AppCompatSpinner
import androidx.appcompat.widget.Toolbar
import androidx.core.content.FileProvider
import com.google.android.material.textfield.TextInputLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.mx.mascotas.BuildConfig
import com.mx.mascotas.R
import com.mx.mascotas.data.database.entity.CatPet
import com.mx.mascotas.data.database.entity.CatPetSize
import com.mx.mascotas.domain.entity.ItemPet
import com.mx.mascotas.presentation.ui.main.owner.pet.adapter.PetAdapter
import java.lang.Exception


@BindingAdapter("errorValidation")
    fun setErrorMessage(view: TextInputLayout?, string: String?) {
        Log.i("errorText","msg -> $string")
        view?.let {
            it.error
            string?.let { it2->
                if (!it2.isEmpty())
                    it.error = it2
            }
        }

    }

    @BindingAdapter("validation", "errorMsg")
    fun setErrorEnable(textInputLayout: TextInputLayout?, stringRule: StringRule?, errorMsg: String?) {
        textInputLayout?.let {
            it.editText?.let {
                edi ->
                if (stringRule?.validate(edi)== true)
                    it.error = errorMsg
            }
        }
    }

    @BindingAdapter("setMenu")
    fun setMenuNavigationView(navigationView: NavigationView?, enable :Boolean?){
        Log.i("setMenu"," $enable")
        navigationView?.let {
            it.menu.clear()
            enable?.let { ena ->
                if (ena)
                    it.inflateMenu(R.menu.activity_main_drawer_dueno)
                else
                    it.inflateMenu(R.menu.activity_main_drawer_veterinario)
            }
        }

    }

    @BindingAdapter("setMenuTool")
    fun setMenuToolbar(toolbar: Toolbar, @MenuRes idResMenu: Int?){
        toolbar?.let {
            idResMenu?.let { id ->
                it.inflateMenu(id)

            }
        }
    }

    @BindingAdapter("app:adapter")
    fun setListCatPet(spinner: Spinner?, list: List<CatPet>){
    spinner?.adapter = ArrayAdapter<CatPet>(spinner?.context,R.layout.support_simple_spinner_dropdown_item,list)
    }
    @BindingAdapter("app:adapter")
    fun setListCatPetSize(spinner: Spinner?, list: List<CatPetSize>){
    spinner?.adapter = ArrayAdapter<CatPetSize>(spinner?.context,R.layout.support_simple_spinner_dropdown_item,list)

    }

    @BindingAdapter("adapter")
    fun setDataKpi(recyclerView: RecyclerView?, list: List<ItemPet>?){
        val adapter : PetAdapter? = try { recyclerView?.adapter as PetAdapter } catch (e : Exception){null}
        adapter?.let {
            list?.let {
                adapter.list = it
            }
            it.notifyDataSetChanged()
        }
    }
    @BindingAdapter("android:src")
    fun setImageUri(view: ImageView?, path: String?) {
        path?.let {
            if (it.isNotEmpty()){
                view?.let {v ->

                    Glide
                        .with(view)
                        .load(Uri.parse(path))
                        .centerCrop()
                        .placeholder(R.drawable.ic_icon_launcher_black)
                        .into(view)
//                    v.setImageURI(Uri.parse(path))
                }
            }
        }
    }
    @BindingAdapter("app:selection")
    fun setItemSelect (spinner: Spinner?, position: Int){
        spinner?.setSelection(position,true)
    }
    @BindingAdapter( "app:visible")
    fun setCedula (TextInputLayout: TextInputLayout?, enable: Boolean?){
        TextInputLayout?.let { it.visibility=if(enable==true){
            View.VISIBLE
        } else View.GONE
        }
    }
