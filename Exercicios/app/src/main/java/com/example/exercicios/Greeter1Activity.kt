package com.example.exercicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityGreeter1Binding

class Greeter1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityGreeter1Binding
    private val listaNomes1 = mutableListOf<Pessoa>()
    private val listaNomes2 = mutableListOf<Pessoa>()
    private var indiceAtual1 = 0
    private var indiceAtual2 = 0
    private var erroSalvar = false
    private lateinit var greeterAtual: GreeterTipo1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGreeter1Binding.inflate(layoutInflater)
        //------------------------------------------------------------------
        // configurações de variáveis "globais" da tela
        val greeter1 = GreeterTipo1("Olá", "sua idade é","!")
        val greeter2 = GreeterTipo1("Bem vindo,", "Já que você tem", "sinta-se em casa")
        greeterAtual = greeter1
        listaNomes1.add(Pessoa("Robert",39))
        listaNomes1.add(Pessoa("Renato",19))
        listaNomes1.add(Pessoa("Ricardo",59))
        // ------------------------------------------------------------------
        //configurações dos botões primeira parte
        binding.btImprimirGreeter1.setOnClickListener {
            binding.txtSaidaGreeter1.text = greeterAtual.greet1(listaNomes1[indiceAtual1].nome) //Primeira Impressão

            if(indiceAtual1 == listaNomes1.size - 1){
                indiceAtual1 = 0
            } else {
                indiceAtual1++
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
        //----------------------------------------------------------------------------------
        // configurações dos botões segunda parte
        binding.btSalvarGreeter2.setOnClickListener{

            erroSalvar = false
            binding.txtSaida2.text = ""
                for (lista in listaNomes2) {
                    if (lista.nome == binding.txtEntradaNome.text.toString() &&
                        lista.idade == binding.txtEntradaIdade.text.toString().toInt()
                    ) {
                        binding.txtSaida2.text = "Esta pessoa ja consta na lista"
                        binding.txtEntradaNome.text.clear()
                        binding.txtEntradaIdade.text.clear()
                        erroSalvar = true
                        break
                    }
                }
                if (erroSalvar == false&&binding.txtEntradaNome.text.toString()!="") {
                    if(listaNomes2.size!=0) listaNomes2.removeAt(listaNomes2.size-1)

                    listaNomes2.add(Pessoa(
                        binding.txtEntradaNome.text.toString(),
                        binding.txtEntradaIdade.text.toString().toInt()
                    ))
                    listaNomes2.add(Pessoa("Fim da lista, aperte próximo para voltar ao inicio",0))
                    binding.txtEntradaNome.text.clear()
                    binding.txtEntradaIdade.text.clear()
                    binding.txtSaida2.text = "Nome e telefone salvos com sucesso"
                }else binding.txtSaida2.text = "Digite nome e telefone para poder salvar"
        }

        binding.btImprimir2.setOnClickListener{
           if (listaNomes2.size != 0 &&(listaNomes2.size-1)>indiceAtual2) {

               binding.txtSaida2.text = greeterAtual.greet2(
                   listaNomes2[indiceAtual2].nome,
                   listaNomes2[indiceAtual2].idade
               )            //Segunda Impressão

               indiceAtual2++

           }else if(listaNomes2.size-1==indiceAtual2){
               binding.txtSaida2.text = listaNomes2[indiceAtual2].nome
               indiceAtual2 = 0
           }else{
               binding.txtSaida2.text = "Não há registro"
           }
        }
        setContentView(binding.root)
    }
}