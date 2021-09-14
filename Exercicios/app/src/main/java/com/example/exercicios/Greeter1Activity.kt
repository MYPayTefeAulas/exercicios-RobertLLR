package com.example.exercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityGreeter1Binding
import com.example.exercicios.databinding.ActivityMainBinding

class Greeter1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGreeter1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGreeter1Binding.inflate(layoutInflater)


        setContentView(binding.root)
    }
}