package com.example.exercicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityGreeter1Binding

class Greeter1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGreeter1Binding
    private val listaNomes = mutableListOf<String>()
    private var indiceAtual = 0
    private lateinit var greeterAtual: GreeterTipo1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGreeter1Binding.inflate(layoutInflater)
        //------------------------------------------------------------------
        // configurações de variáveis "globais" da tela
        val greeter1 = GreeterTipo1("Olá")
        val greeter2 = GreeterTipo1("Bem vindo,")
        greeterAtual = greeter1
        listaNomes.add("Robert")
        listaNomes.add("Alex")
        listaNomes.add("Rodrigo")
        // ------------------------------------------------------------------
        //configurações dos botões
        binding.btImprimir.setOnClickListener {
            val nomeAtual = listaNomes[indiceAtual]

            binding.txtSaida.text = greeterAtual.greet(nomeAtual)

            if(indiceAtual == listaNomes.size - 1){
                indiceAtual = 0
            } else {
                indiceAtual++
            }
        }

        binding.btTrocar.setOnClickListener {
            if(greeterAtual == greeter1){
                greeterAtual = greeter2
                binding.txtNumGreeter.text = "2"
            }else{
                greeterAtual = greeter1
                binding.txtNumGreeter.text = "1"
            }
        }

        binding.btVoltarGreeter.setOnClickListener {
            val i = Intent (this@Greeter1Activity, MainActivity :: class.java)
            startActivity(i)
        }

        setContentView(binding.root)
    }
}