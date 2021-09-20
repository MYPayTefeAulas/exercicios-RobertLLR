package com.example.exercicios

import android.graphics.Color.rgb
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityAgendaBinding

class AgendaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaBinding
    private val agenda = Agenda()
    //private var contatoAtual : Pessoa? = null
    private var contatoAtual = Pessoa("",0)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaBinding.inflate(layoutInflater)


        binding.btAgSalvar.setOnClickListener {
            if(binding.txtAgNome.text.toString() == "") {
                binding.txtAgSaida.text = "Nome vazio, digite um nome"
                binding.txtAgSaida.setTextColor(getResources().getColor(R.color.design_default_color_error))
            }else if (binding.txtAgTelefone.text.toString() == "" ){
                binding.txtAgSaida.text = "Telefone vazio, digite um nome"
                binding.txtAgSaida.setTextColor(getResources().getColor(R.color.design_default_color_error))
            }else {
                binding.txtAgSaida.text = "Contato foi salvo"
                binding.txtAgSaida.setTextColor(resources.getColor(R.color.purple_500))
                contatoAtual.nome = binding.txtAgNome.text.toString()
                contatoAtual.idade = binding.txtAgTelefone.text.toString().toInt()
                agenda.salvarAg(contatoAtual)
            }

        }
        binding.btAgDeletar.setOnClickListener {

        }

        binding.btAgProximo.setOnClickListener {

            contatoAtual = agenda.proximoAg()
            //binding.txtAgNome.text = getText("Robert")
            //binding.txtAgTelefone.text = contatoAtual.idade.toString()

        }

        setContentView(binding.root)
    }
}