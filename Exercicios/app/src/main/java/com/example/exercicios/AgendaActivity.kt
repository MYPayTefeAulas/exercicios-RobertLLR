package com.example.exercicios

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityAgendaBinding

class AgendaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaBinding
    private val agenda = Agenda()
    //private var contatoAtual : PessoaAg()
    private var contatoAtual = PessoaAg(nome = "",telefone = "0")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaBinding.inflate(layoutInflater)


        binding.btAgSalvar.setOnClickListener {

            val nome = binding.txtAgNome.text.toString()
            val telefone = binding.txtAgTelefone.text.toString()
            //val novaPessoa = PessoaAg(nome,telefone)
            contatoAtual = PessoaAg(nome,telefone)

            if(binding.txtAgNome.text.toString() == "") {
                binding.txtAgSaida.text = "Nome vazio, digite o nome de um contato para apagá-lo"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }else if (binding.txtAgTelefone.text.toString() == "" ){
                binding.txtAgSaida.text = "Telefone vazio, digite o telefone de um contato para apagá-lo"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }else {
                if(agenda.verificaContatoAg(contatoAtual)=="false") {
                    binding.txtAgSaida.text = "Este contato não consta na Agenda"
                    binding.txtAgSaida.setTextColor(Color.rgb(0,0,255))

                    agenda.salvarAg(contatoAtual)
                }else if(agenda.verificaContatoAg(contatoAtual)==contatoAtual.nome) {
                    binding.txtAgSaida.text = "O nome ${contatoAtual.nome} já consta na lista"
                }else if(agenda.verificaContatoAg(contatoAtual)==contatoAtual.telefone){
                    binding.txtAgSaida.text = "O telefone ${contatoAtual.telefone} já consta na lista"
                }
            }
        }
        binding.btAgDeletar.setOnClickListener {
            if(binding.txtAgNome.text.toString() == "") {
                binding.txtAgSaida.text = "Nome vazio, CLIQUE EM PROXIMO ANTES DE DELETAR"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }else if (binding.txtAgTelefone.text.toString() == "" ){
                binding.txtAgSaida.text = "Telefone vazio, CLIQUE EM PROXIMO ANTES DE DELETAR"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }else {
                agenda.deletarAg(contatoAtual)
            }
        }

        binding.btAgProximo.setOnClickListener {
            if(agenda.listaVazia()==true){
                binding.txtAgSaida.text = "Agenda esta vazia"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }else {
                contatoAtual = agenda.proximoAg()
                binding.txtAgNome.setText(contatoAtual.nome)
                binding.txtAgTelefone.setText(contatoAtual.telefone)
            }
        }

        setContentView(binding.root)
    }
}