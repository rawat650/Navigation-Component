package com.example.naviagationcomponent.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Register" )
class RegisterEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "FIRST_NAME") var firstname:String,
    @ColumnInfo(name = "LAST_NAME") var lastname:String,
    @ColumnInfo(name = "PHONE_NUMBER") var phonenumber:Int,
    @ColumnInfo(name = "EMAIL") var email:String,
    @ColumnInfo(name = "GENDER") var gender: String,
    @ColumnInfo(name = "PASSWORD") var password:String,
    @ColumnInfo(name = "CONFIRM_PASSWORD") var confirmpassword:String,
    @ColumnInfo(name = "EDUCATION") var eduacation:String,
    @ColumnInfo(name = "YEAR_OF_PASSING") var yearOfPassing:Int,
    @ColumnInfo(name = "GRADE") var grade:String,
    @ColumnInfo(name = "EXPERIENCE") var experience:Int,
    @ColumnInfo(name = "DESIGNATION") var designation:String,
    @ColumnInfo(name = "DOMAIN") var domain:String,
    @ColumnInfo(name = "ADDRESS") var address:String,
    @ColumnInfo(name = "LANDMARK") var landmark:String,
    @ColumnInfo(name = "CITY") var city:String,
    @ColumnInfo(name = "STATE") var state:String,
    @ColumnInfo(name = "PINCODE") var pincode:Int,




)