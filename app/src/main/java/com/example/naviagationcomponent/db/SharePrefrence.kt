package com.example.naviagationcomponent.db

import android.content.Context
import com.example.naviagationcomponent.model.Register

class SharePrefrence private constructor(private val mcontext : Context) {



    val data: Register
        get() {
            val sharedPreferences = mcontext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
            return Register(
                sharedPreferences.getInt("id",-1),
                sharedPreferences.getString("firstname",null)!!,
                sharedPreferences.getString("lastname",null)!!,
                sharedPreferences.getInt("phonenumber",-1)!!,
                sharedPreferences.getString("email",null)!!,
                sharedPreferences.getString("gender","")!!,
                sharedPreferences.getString("password","")!!,
                sharedPreferences.getString("cnfrmpassword","")!!,
        /*        sharedPreferences.getString("education","")!!,
                sharedPreferences.getInt("yearOfPassing",-1)!!,
                sharedPreferences.getString("grade","")!!,
                sharedPreferences.getInt("experience",-1)!!,
                sharedPreferences.getString("desigantion","")!!,
                sharedPreferences.getString("domain","")!!,
                sharedPreferences.getString("address","")!!,
                sharedPreferences.getString("landmark","")!!,
                sharedPreferences.getString("city","")!!,
                sharedPreferences.getString("state","")!!,
                sharedPreferences.getInt("pincode",-1)*/



            )
        }




    fun saveUser(data: Register){
        val sharedPreferences = mcontext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt("id",data.id)
        editor.putString("firstname",data.firstname)
        editor.putString("lastname",data.lastname)
        editor.putInt("phonenumber",data.phonenumber)
        editor.putString("email",data.email)
        editor.putString("gender",data.gender)
        editor.putString("password",data.password)
        editor.putString("cnfrmpassword",data.cnfrmpassword)
    /*    editor.putString("education",data.education)
        editor.putInt("yearOfPassing",data.yearOfPassing)
        editor.putString("grade",data.grade)
        editor.putInt("experience",data.experience)
        editor.putString("designation",data.designation)
        editor.putString("domain",data.domain)
        editor.putString("address",data.address)
        editor.putString("landmark",data.landmark)

        editor.putString("city",data.city)
        editor.putString("state",data.state)
        editor.putInt("pincode",data.pincode)
*/




        editor.apply()
    }

    fun clear() {
        val sharedPreferences = mcontext.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object{
        private  val SHARED_PREFERENCE_NAME = "my_private_sharedpref"
        private var mInstance:SharePrefrence?= null

        @Synchronized
        fun getInstance(mcontext: Context):SharePrefrence{
            if(mInstance == null){
                mInstance = SharePrefrence(mcontext)
            }
            return mInstance as SharePrefrence
        }
    }
}
