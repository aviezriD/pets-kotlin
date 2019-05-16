package com.mx.mascotas.data.network.service

import retrofit2.Retrofit

class ApiService(private var retrofit : Retrofit) {

    fun <T> getApiClient(type: Class<T>): T {
        return retrofit.create(type)
    }
}