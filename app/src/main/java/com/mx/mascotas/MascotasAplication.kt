package com.mx.mascotas

import android.app.Application
import androidx.room.Room
import com.facebook.stetho.Stetho
import com.google.firebase.FirebaseApp
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mx.mascotas.data.database.AppDataBase
import com.mx.mascotas.data.executor.AppScheduleProvider
import com.mx.mascotas.data.network.service.ApiService
import com.mx.mascotas.data.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

class MascotasAplication: Application() {

    companion object{
        val scheduler by lazy { AppScheduleProvider() }

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

        val executor by lazy { Executors.newSingleThreadExecutor() }

    }

    val database by lazy {
        Room.databaseBuilder(this, AppDataBase::class.java, Constants.Database.DB_NAME)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        application = this
        val stetho = Stetho.newInitializerBuilder(this)
            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
            .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build()

        if (BuildConfig.DEBUG) {
            Stetho.initialize(stetho)
        }
    }


}