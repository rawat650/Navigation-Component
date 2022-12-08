package com.example.naviagationcomponent.Repository

import com.example.naviagationcomponent.db.RegisterDb
import com.example.naviagationcomponent.db.RegisterEntity
import com.example.naviagationcomponent.model.Register


class RegisterRepository(private val registerDb: RegisterDb) {

    suspend fun insertAddress(data: Register) {
        val registerEntity = RegisterEntity(
            data.id,
            data.firstname,
            data.lastname,
            data.phonenumber,
            data.email,
            data.gender,
            data.password,
            data.cnfrmpassword
            data.education,
            data.yearOfPassing,
            data.grade,
            data.experience,
            data
                .designation,
            data.domain,
            data.address,
            data.landmark,
            data
                .city,
            data.state,
            data
                .pincode
        )
        registerDb.registerDao().addData(registerEntity)
    }
}