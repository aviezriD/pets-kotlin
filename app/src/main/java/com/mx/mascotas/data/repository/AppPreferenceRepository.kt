package com.mx.mascotas.data.repository

import android.content.SharedPreferences
import com.mx.mascotas.domain.repository.PreferenceRepository

class AppPreferenceRepository(private val sharedPreferences: SharedPreferences) : PreferenceRepository {
    private val ID_USER = "ID_USER"
    private val USER_NAME = "USER_NAME"
    private val PRELOAD = "PRELOAD"
    private val ROLE = "ROLE"

    override fun getIsPreLoad(): Boolean {
        return sharedPreferences.getBoolean(PRELOAD, false)
    }

    override fun setPreLoad(enable: Boolean) {
        sharedPreferences.edit().putBoolean(PRELOAD, enable).apply()
    }

    override fun getIdUser(): Int {
        return sharedPreferences.getInt(ID_USER, -1)
    }

    override fun setIdUser(idUser: Int) {
        sharedPreferences.edit().putInt(ID_USER, idUser).apply()
    }

    override fun getUserName(): String {
        return sharedPreferences.getString(USER_NAME, "")
    }

    override fun setUserName(userName: String) {
        sharedPreferences.edit().putString(USER_NAME, userName).apply()
    }

    override fun getRole(): Int {
        return sharedPreferences.getInt(ROLE,-1)
    }

    override fun setRole(idRole: Int) {
        sharedPreferences.edit().putInt(ROLE, idRole).apply()
    }
}