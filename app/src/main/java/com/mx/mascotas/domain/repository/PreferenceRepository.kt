package com.mx.mascotas.domain.repository

interface PreferenceRepository {
    fun getIdUser(): Int
    fun setIdUser(idUser: Int)

    fun getUserName(): String
    fun setUserName(userName: String)

    fun getIsPreLoad(): Boolean
    fun setPreLoad(enable: Boolean)

    fun getRole(): Int
    fun setRole(idRole : Int)
}