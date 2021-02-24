package com.example.aboutme

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var name: Name = Name(fullName = "Evgeny Miroshnichenko")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.name = name
        binding.doneButton.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(doneButton: View): Unit {
        binding.apply {
            name?.nickname = binding.nicknameEdit.text.toString()

            binding.nicknameText.visibility = View.VISIBLE
            binding.nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE

            invalidateAll()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(doneButton.windowToken, 0)
    }
}