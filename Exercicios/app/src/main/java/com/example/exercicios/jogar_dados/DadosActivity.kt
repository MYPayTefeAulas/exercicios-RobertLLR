package com.example.exercicios.jogar_dados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityDadosBinding
import com.example.exercicios.jogar_dados.Dados

class DadosActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDadosBinding
    private val listaDados = mutableListOf<Dados>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDadosBinding.inflate(layoutInflater)
        listaDados.add(Dados(4))
        listaDados.add(Dados(6))
        listaDados.add(Dados(8))


        binding.btTrocarDados1.setOnClickListener {
            listaDados[0].lados = trocarDados(listaDados[0].lados)
            binding.txtDados1.text = "${listaDados[0].lados} lados"

        }
        binding.btTrocarDados2.setOnClickListener {
            listaDados[1].lados = trocarDados(listaDados[1].lados)
            binding.txtDados2.text = "${listaDados[1].lados} lados"
        }
        binding.btTrocarDados3.setOnClickListener {
            listaDados[2].lados = trocarDados(listaDados[2].lados)
            binding.txtDados3.text = "${listaDados[2].lados} lados"
        }

        binding.btRolarDados.setOnClickListener {
            binding.txtSaidaDados1.text = listaDados[0].rolar().toString()
            binding.txtSaidaDados2.text = listaDados[1].rolar().toString()
            binding.txtSaidaDados3.text = listaDados[2].rolar().toString()
        }
        setContentView(binding.root)
    }

    fun trocarDados(lado:Int):Int {
        if (lado>=4 && lado<=8){
            return (lado + 2)
        }else {
            return 4
        }
    }
}