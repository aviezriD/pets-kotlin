package com.mx.mascotas.data.repository.datasource

import com.mx.mascotas.data.database.dao.BaseDao

open class BaseDb<T>(val dao: BaseDao<T>) : BaseData<T,Unit> {

    override fun insert(obj: T) {
        dao.insert(obj)
    }

    override fun update(obj: T) {
        dao.update(obj)
    }

    override fun delete(obj: T) {
        dao.delete(obj)
    }
}