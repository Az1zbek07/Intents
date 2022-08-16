package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.os.bundleOf
import com.example.intents.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGo.setOnClickListener {
            var newAge = 0
            var name = binding.editName.text.toString().trim()
            var lastName = binding.editLastName.text.toString().trim()
            var age = binding.editAge.text.toString().trim()
            if (age.isNotEmpty()){
                newAge = age.toInt()
            }
            if (checkLogin(name, lastName, newAge)) {
                val user = User(name, lastName,newAge.toString())
                val bundle = bundleOf("user" to user)
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun checkLogin(name: String, lastName: String, nAge: Int): Boolean {
        checkLastName(null)
        checkName(null)
        checkAge(null)
        if (name.isEmpty() || name.length < 6){
            checkName("Name length must be longer than 6")
            return false
        }

        if (lastName.isEmpty() || lastName.length < 6){
            checkLastName("Last name length must be longer than 6")
            return false
        }

        if (nAge < 18){
            checkAge("age must be longer than 18")
            return false
        }
        return true
    }

    private fun checkName(e: String?) {
        binding.editNameLayout.error = e
    }

    private fun checkLastName(e: String?) {
        binding.editLastNameLayout.error = e
    }

    private fun checkAge(e: String?) {
        binding.editAgeLayout.error = e
    }
}