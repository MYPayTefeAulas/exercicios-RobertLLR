package com.example.exercicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityPessoas2Binding

class PessoasActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityPessoas2Binding

    private  var nome = ""
    private  var idade = 0

    private val listaPessoas = mutableListOf<Pessoa>()
    private var indiceAtual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPessoas2Binding.inflate(layoutInflater)

        binding.btImprimirPessoa.setOnClickListener {
            binding.txtSaidaPessoa.text = imprimePessoa()
        }

        binding.btSalvarPessoa.setOnClickListener {
            nome = binding.txtNomePessoa.text.toString()
            binding.txtNomePessoa.text.clear()
            idade = binding.txtIdadePessoa.text.toString().toInt()
            binding.txtIdadePessoa.text.clear()

            val pessoa = Pessoa(nome,idade)
            listaPessoas.add(pessoa)
        }

        binding.btVoltarPessoa.setOnClickListener {
            val i = Intent (this@PessoasActivity2, MainActivity :: class.java)
            startActivity(i)
        }

        setContentView(binding.root)
    }

    fun imprimePessoa(): String {
        val pessoaAtual = listaPessoas[indiceAtual]
        indiceAtual++
        return  "Nome: ${pessoaAtual.nome}, Idade: ${pessoaAtual.idade}"
    }
}