package com.example.exercicios.agenda

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityAgendaBinding

class AgendaActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAgendaBinding
    //private val agenda = Agenda()
    private var editar : Boolean = false
    private var contatoAtual = PessoaAg(nome = "",telefone = "0")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgendaBinding.inflate(layoutInflater)


        binding.btAgSalvar.setOnClickListener {

            val nome = binding.txtAgNome.text.toString()
            val telefone = binding.txtAgTelefone.text.toString()
            contatoAtual = PessoaAg(nome,telefone)


            if(binding.txtAgNome.text.toString() == "") {
                binding.txtAgSaida.text = "Nome vazio, digite o nome de um contato para apagá-lo"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }else if (binding.txtAgTelefone.text.toString() == "" ){
                binding.txtAgSaida.text = "Telefone vazio, digite o telefone de um contato para apagá-lo"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }else {
                if(Agenda.verificaContatoAg(contatoAtual)=="false") {
                    binding.txtAgSaida.text = "Contato salvo"
                    binding.txtAgSaida.setTextColor(Color.rgb(0,0,255))

                    Agenda.salvarAg(contatoAtual)
                }else if(Agenda.verificaContatoAg(contatoAtual)==contatoAtual.nome&&editar==false) {
                    binding.txtAgSaida.text = "O nome ${contatoAtual.nome} já consta na lista"
                }else if(Agenda.verificaContatoAg(contatoAtual)==contatoAtual.telefone&&editar==false){
                    binding.txtAgSaida.text = "O telefone ${contatoAtual.telefone} já consta na lista"
                }else if(editar==true&&Agenda.listaVazia()==false){
                    Agenda.editarAg(contatoAtual)
                    binding.txtAgSaida.text = "Contato modificado"
                }
            }
            editar = false
        }

        binding.btAgDeletar.setOnClickListener {
            if(binding.txtAgNome.text.toString() == "") {
                binding.txtAgSaida.text = "Nome vazio, CLIQUE EM PROXIMO ANTES DE DELETAR"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }else if (binding.txtAgTelefone.text.toString() == "" ){
                binding.txtAgSaida.text = "Telefone vazio, CLIQUE EM PROXIMO ANTES DE DELETAR"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }else if(editar==true){
                Agenda.deletarAg()
                binding.txtAgSaida.text = "Contato deletado"
                binding.txtAgSaida.setTextColor(Color.rgb(0,0,255))
            }
            editar = false
        }

        binding.btAgProximo.setOnClickListener {
            if(Agenda.listaVazia()==true){
                binding.txtAgSaida.text = "Agenda esta vazia"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }else {
                contatoAtual = Agenda.proximoAg()
                binding.txtAgNome.setText(contatoAtual.nome)
                binding.txtAgTelefone.setText(contatoAtual.telefone)
            }
            editar = true
            binding.txtAgSaida.text = "Contato ${Agenda.numContato()+1}"
            binding.txtAgSaida.setTextColor(Color.rgb(0,0,255))
        }

        binding.btAgBuscar.setOnClickListener {
            if(Agenda.listaVazia()){
                binding.txtAgSaida.text = "Agenda esta vazia"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }else if(Agenda.existenciaContato(binding.txtAgBuscar.text.toString())) {
                contatoAtual = Agenda.buscarAg(binding.txtAgBuscar.text.toString())
                binding.txtAgNome.setText(contatoAtual.nome)
                binding.txtAgTelefone.setText(contatoAtual.telefone)
                binding.txtAgSaida.text = "Contato ${Agenda.numContato()+1}"
                binding.txtAgSaida.setTextColor(Color.rgb(0,0,255))
                binding.txtAgTest.text = "Nome: ${contatoAtual.nome}, telefone: ${contatoAtual.telefone}"
            }else {
                binding.txtAgSaida.text = "Este contato NÃO existe"
                binding.txtAgSaida.setTextColor(Color.rgb(201,103,103))
            }
            editar = true
            binding.txtAgBuscar.text.clear()
        }

        binding.btAglista.setOnClickListener {
            //listaView
        }

        setContentView(binding.root)
    }
}