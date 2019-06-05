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

                database.catVetDiaDao().insert(CatVetDia(0, "Lunes"))
                database.catVetDiaDao().insert(CatVetDia(1, "Martes"))
                database.catVetDiaDao().insert(CatVetDia(2, "Miércoles"))
                database.catVetDiaDao().insert(CatVetDia(3, "Jueves"))
                database.catVetDiaDao().insert(CatVetDia(4, "Viernes"))
                database.catVetDiaDao().insert(CatVetDia(5, "Sábado"))



                database.catVetHorasDao().insert(CatVetHoras(0,"9:00-10:00", true ))
                database.catVetHorasDao().insert(CatVetHoras(1, "10:00-11:00", true))
                database.catVetHorasDao().insert(CatVetHoras(2, "11:00-12:00", true))
                database.catVetHorasDao().insert(CatVetHoras(3, "12:00-13:00", true ))
                database.catVetHorasDao().insert(CatVetHoras(4, "13:00-14:00", true))
                database.catVetHorasDao().insert(CatVetHoras(5, "14:00-15:00", true))
                database.catVetHorasDao().insert(CatVetHoras(5, "15:00-16:00", true))
                database.catVetHorasDao().insert(CatVetHoras(5, "16:00-17:00", true ))
                database.catVetHorasDao().insert(CatVetHoras(5, "17:00-18:00", true))

                database.catSubserviceDao().insert(CatSubService( 0, 1, "Baño"))
                database.catSubserviceDao().insert(CatSubService( 1,1, "Corte de pelo"))
                database.catSubserviceDao().insert(CatSubService( 2,1, "Limpieza de oídos"))

                database.catVetMonthDao().insert(CatVetMonth(0, "Junio"))

                database.catDayLabDao().insert(CatDayLab(0, "Miércoles 5"))
                database.catDayLabDao().insert(CatDayLab(1, "Jueves 6"))
                database.catDayLabDao().insert(CatDayLab(2, "Viernes 7"))
                database.catDayLabDao().insert(CatDayLab(3, "Sábado 8"))
                database.catDayLabDao().insert(CatDayLab(4, "Domingo 9"))
                database.catDayLabDao().insert(CatDayLab(5, "Lunes 10"))
                database.catDayLabDao().insert(CatDayLab(6, "Martes 11"))
                database.catDayLabDao().insert(CatDayLab(7, "Miércoles 12"))
                database.catDayLabDao().insert(CatDayLab(8, "Jueves 13"))
                database.catDayLabDao().insert(CatDayLab(9, "Viernes 14"))
                database.catDayLabDao().insert(CatDayLab(10, "Sábado 15"))
                database.catDayLabDao().insert(CatDayLab(11, "Domingo 16"))
                database.catDayLabDao().insert(CatDayLab(12, "Lunes 17"))
                database.catDayLabDao().insert(CatDayLab(13, "Martes 18"))
                database.catDayLabDao().insert(CatDayLab(14, "Miércoles 19"))
                database.catDayLabDao().insert(CatDayLab(15, "Jueves 20"))
                database.catDayLabDao().insert(CatDayLab(16, "Viernes 21"))
                database.catDayLabDao().insert(CatDayLab(17, "Sábado 22"))
                database.catDayLabDao().insert(CatDayLab(18, "Domingo 23"))
                database.catDayLabDao().insert(CatDayLab(19, "Lunes 24"))
                database.catDayLabDao().insert(CatDayLab(20, "Martes 25"))
                database.catDayLabDao().insert(CatDayLab(21, "Miércoles 26"))
                database.catDayLabDao().insert(CatDayLab(22, "Jueves 27"))
                database.catDayLabDao().insert(CatDayLab(23, "Viernes 28"))
                database.catDayLabDao().insert(CatDayLab(24, "Sábado 29"))
                database.catDayLabDao().insert(CatDayLab(25, "Domingo 30"))

                database.catVaccinationDao().insert(CatVaccination(0, "DAG9402","01PACJ0916", true))
                database.catVaccinationDao().insert(CatVaccination(1, "CAT9912","02AOC12032", true))
                database.catVaccinationDao().insert(CatVaccination(2, "NASH810","03IFL130208", true))
                database.catVaccinationDao().insert(CatVaccination(3, "NDT1002","04ALN06111 ", true))
                database.catVaccinationDao().insert(CatVaccination(4, "SIS0408","05GOGE6409", true))



                appPreferences.setPreLoad(true)
            }
        }
    }


}