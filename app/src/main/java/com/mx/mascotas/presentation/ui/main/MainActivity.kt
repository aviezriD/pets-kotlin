package com.mx.mascotas.presentation.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.navigation.NavigationView
import com.mx.mascotas.BR
import com.mx.mascotas.MascotasAplication
import com.mx.mascotas.R
import com.mx.mascotas.data.repository.UserDataRepository
import com.mx.mascotas.databinding.ActivityMainBinding
import com.mx.mascotas.domain.usecase.main.MainUseCaseImpl
import com.mx.mascotas.presentation.base.BaseActivity
import com.mx.mascotas.presentation.ui.login.LoginActivity
import com.mx.mascotas.presentation.ui.main.common.profile.ProfileFragment
import com.mx.mascotas.presentation.ui.main.common.registerdate.RegisterDateFragment
import com.mx.mascotas.presentation.ui.main.owner.OwnerFragment
import com.mx.mascotas.presentation.ui.main.owner.pet.PetFragment
import com.mx.mascotas.presentation.ui.main.vet.date.DateFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : BaseActivity<ActivityMainBinding,MainViewModel>(),MainContract.Navigator, NavigationView.OnNavigationItemSelectedListener {
    private val scheduler by lazy { MascotasAplication.scheduler }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_nav, toolbar, R.string.drawer_open, R.string.drawer_close
        )
        drawer_nav.addDrawerListener(toggle)
        toggle.syncState()
        nav_menu.setNavigationItemSelectedListener(this)
        goFragment(R.id.container_main, OwnerFragment())


    }

    override fun getBindingVariable(): Int {
        return BR.mainViewModel
    }

    override fun getIdLayout(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        return MainViewModel(scheduler,this,MainUseCaseImpl(UserDataRepository(),MascotasAplication.application.appPreferences))
    }




    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.close -> {finish(); startActivity(Intent(this,LoginActivity::class.java))}
            R.id.misMascotas -> goFragment(R.id.container_main, OwnerFragment())

            R.id.proximasCitas -> Log.i("menu","citas")
            //R.id.promociones -> Log.i("menu","promo")
            R.id.agendarCitas -> goFragment(R.id.container_main, RegisterDateFragment())
            R.id.miPerfil -> goFragment(R.id.container_main,ProfileFragment())
            R.id.misCitas -> goFragment(R.id.container_main, DateFragment())
           // R.id.vinculacion -> Log.i("menu","vinculacion")
           // R.id.historial -> Log.i("menu","historial")
            R.id.infoCliente -> Log.i("menu","clientes")
            else -> Log.i("menu","other")
        }

        drawer_nav.closeDrawer(GravityCompat.START)
        return true
    }
}
