package com.mx.mascotas

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.facebook.stetho.Stetho
import com.google.firebase.FirebaseApp
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mx.mascotas.data.database.AppDataBase
import com.mx.mascotas.data.database.entity.*
import com.mx.mascotas.data.executor.AppScheduleProvider
import com.mx.mascotas.data.network.service.ApiService
import com.mx.mascotas.data.repository.AppPreferenceRepository
import com.mx.mascotas.data.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

class MascotasAplication: Application() {

    companion object{
        val executor by lazy {    Executors.newFixedThreadPool( Runtime.getRuntime().availableProcessors() + 1) }
        val scheduler by lazy { AppScheduleProvider(executor) }

        lateinit var application : MascotasAplication


        private val apiClientConfig by lazy{
            Retrofit.Builder()
                .baseUrl(Constants.Routes.URL)
//                .client(TrustOkHttpClient.getUnsafeOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }

        val apiService  by lazy { ApiService(apiClientConfig) }

    }

    val database by lazy {
        Room.databaseBuilder(this, AppDataBase::class.java, Constants.Database.DB_NAME)
            .build()

    }

    val appPreferences by lazy { AppPreferenceRepository(applicationContext.getSharedPreferences("mascotas" ,Context.MODE_PRIVATE)) }

    override fun onCreate() {
        super.onCreate()
        application = this
        val stetho = Stetho.newInitializerBuilder(this)
            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
            .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build()

        if (BuildConfig.DEBUG) {
            Stetho.initialize(stetho)
        }
        generate()
    }

    private fun generate(){
        if (!appPreferences.getIsPreLoad()){
            executor.execute {
                database.roleDao().insert(Role(name = "Dueño"))
                database.roleDao().insert(Role(1,"Veterinario"))

                database.catPetDao().insert(CatPet(0,"Perro"))
                database.catPetDao().insert(CatPet(1,"Gato"))
                database.catPetDao().insert(CatPet(2,"Otro"))

                database.catPetSizeDao().insert(CatPetSize(0,"Miniatura"))
                database.catPetSizeDao().insert(CatPetSize(1,"Pequeño"))
                database.catPetSizeDao().insert(CatPetSize(2,"Mediano"))
                database.catPetSizeDao().insert(CatPetSize(3,"Grande"))
                database.catPetSizeDao().insert(CatPetSize(4,"Gigante"))

                database.catDateStatusDao().insert(CatDateStatus (0, "Pendiente"))
                database.catDateStatusDao().insert(CatDateStatus (1, "Cancelada"))
                database.catDateStatusDao().insert(CatDateStatus (2, "Finalizada"))


                database.catServicesDao().insert(CatService(0, "Veterinario"))
                database.catServicesDao().insert(CatService(1, "Higiene"))
                database.catServicesDao().insert(CatService(2, "Vacuna"))

                appPreferences.setPreLoad(true)
            }
        }
    }


}