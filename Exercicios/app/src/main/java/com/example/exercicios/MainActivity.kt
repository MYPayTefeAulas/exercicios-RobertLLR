package com.example.exercicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.btEx1.setOnClickListener {
            val i = Intent (this@MainActivity, CalculadoraActivity :: class.java)
            startActivity(i)
        }
        binding.btEx2.setOnClickListener {
            val i = Intent (this@MainActivity, FrutasActivity :: class.java)
            startActivity(i)
        }
        binding.btEx3.setOnClickListener {
            val i = Intent (this@MainActivity, PessoasActivity2 :: class.java)
            startActivity(i)
        }

        setContentView(binding.root)
    }
}