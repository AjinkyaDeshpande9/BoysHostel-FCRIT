package com.example.boyshostelfcrit.model

data class User(val name:String,
                val dept: String,
                val profilePicPath: String?){
constructor(): this("","",null)

}