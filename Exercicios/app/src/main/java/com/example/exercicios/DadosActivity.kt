package com.example.exercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityDadosBinding
import com.example.exercicios.databinding.ActivityGreeter1Binding

class DadosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDadosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDadosBinding.inflate(layoutInflater)



        setContentView(binding.root)
    }
}