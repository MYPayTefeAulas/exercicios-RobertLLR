package com.example.exercicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityFrutasBinding

class FrutasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFrutasBinding

    private val listaFrutas = listOf("maçã", "mamão", "abacate")
    private val listaVegetais = listOf("pepino","alface","pimentão")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrutasBinding.inflate(layoutInflater)

        binding.btAnalisar.setOnClickListener {
            binding.txtSaida.text = analisar(binding.txtEntrada.text.toString())
        }
        binding.btVoltarFrutas.setOnClickListener {
            val i = Intent (this@FrutasActivity, MainActivity :: class.java)
            startActivity(i)
        }

        setContentView(binding.root)
    }

    fun analisar(entrada:String): String{
        var saida = ""

        var encontrouAlimento = false

        for (fruta in listaFrutas) {
            if( fruta == entrada) {
                saida = "é uma fruta"
                encontrouAlimento = true
                break
            }

        }

        for (vegetal in listaVegetais) {
            if( vegetal == entrada) {
                saida = "é um vegetal"
                encontrouAlimento = true
                break
            }

        }

        if (!encontrouAlimento){
            saida = "Não sei o que é isto"
        }
        return saida
    }
}