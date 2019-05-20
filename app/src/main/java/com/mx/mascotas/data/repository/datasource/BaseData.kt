package com.mx.mascotas.data.repository.datasource

interface BaseData<T,R> {
    fun insert(obj: T):R
    fun update(obj: T): R
    fun delete(obj: T): R
}