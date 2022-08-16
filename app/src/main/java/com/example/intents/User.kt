package com.example.intents

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val lastName: String,
    val age: String
) : Parcelable{
    override fun toString(): String {
        return "Name: ${name.toString().trim()} \nLast name: ${lastName.toString().trim()} \nAge: ${age.toString().trim()}"
    }
}
