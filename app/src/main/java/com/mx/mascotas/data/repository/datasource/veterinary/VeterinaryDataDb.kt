package com.mx.mascotas.data.repository.datasource.veterinary

import com.mx.mascotas.data.database.dao.VeterinaryDao
import com.mx.mascotas.data.database.entity.Veterinary
import com.mx.mascotas.data.repository.datasource.BaseDb

class VeterinaryDataDb(var veterinaryDao: VeterinaryDao):VeterinaryData<Unit>, BaseDb<Veterinary>(veterinaryDao) {
}