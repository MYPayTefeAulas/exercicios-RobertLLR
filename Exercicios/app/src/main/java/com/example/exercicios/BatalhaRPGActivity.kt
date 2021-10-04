package com.example.exercicios

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityBatalhaRpgBinding

class BatalhaRPGActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBatalhaRpgBinding
    private val guerreiro1 = Guerreiro("",0,0,0,0)
    private val guerreiro2 = Guerreiro("",0,0,0,0)
    private val arena = Arena(guerreiro1,guerreiro2)
    private var vidaAtualG1:Int=0
    private var vidaAtualG2:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBatalhaRpgBinding.inflate(layoutInflater)

        binding.boxBatalhaAtila.setOnCheckedChangeListener { compoundButton, b ->
           binding.boxBatalhaGK.isChecked = false
           binding.boxBatalhaLeonidas.isChecked = false
           //binding.boxBatalhaAtila.isChecked = true
        }
        binding.boxBatalhaLeonidas.setOnCheckedChangeListener { compoundButton, b ->
            binding.boxBatalhaGK.isChecked = false
            binding.boxBatalhaAtila.isChecked = false
            //binding.boxBatalhaLeonidas.isChecked = true
        }
        binding.boxBatalhaGK.setOnCheckedChangeListener { compoundButton, b ->
            binding.boxBatalhaLeonidas.isChecked = false
            binding.boxBatalhaAtila.isChecked = false
            //binding.boxBatalhaGK.isChecked = true
        }


        binding.btBatalhaIniciar.setOnClickListener {
            if(binding.txtBatalhaNome.text.toString()==""){
                binding.txtBatalhaMensagens.text = "De um NOME ao seu Guerreiro"
            }else if(binding.txtBatalhaVida.text.toString()==""){
                binding.txtBatalhaMensagens.text = "De pontos de VIDA ao seu Guerreiro"
            }else if(binding.txtBatalhaForca.text.toString()==""){
                binding.txtBatalhaMensagens.text = "De pontos de FORÇA ao seu Guerreiro"
            }else if(binding.txtBatalhaDefesa.text.toString()==""){
                binding.txtBatalhaMensagens.text = "De pontos de DEFESA ao seu Guerreiro"
            }else if(binding.txtBatalhaDestreza.text.toString()=="") {
                binding.txtBatalhaMensagens.text = "De pontos de DESTREZA ao seu Guerreiro"
            }else if(binding.txtBatalhaVida.text.toString().toInt()+
                     binding.txtBatalhaForca.text.toString().toInt()+
                     binding.txtBatalhaDefesa.text.toString().toInt()+
                     binding.txtBatalhaDestreza.text.toString().toInt()!=100){
                binding.txtBatalhaMensagens.text = "Distribua CORRETAMENTE os 100 pontos"
            }else if(binding.boxBatalhaAtila.isChecked==false&&
                binding.boxBatalhaLeonidas.isChecked==false&&
                binding.boxBatalhaGK.isChecked==false){
                binding.txtBatalhaMensagens.text = "Selecione um Guerreiro para ser seu oponente"
            }else {
                guerreiro1.nome = binding.txtBatalhaNome.text.toString()
                guerreiro1.vidaExtra = binding.txtBatalhaVida.text.toString().toInt()
                guerreiro1.forcaExtra = binding.txtBatalhaForca.text.toString().toInt()
                guerreiro1.defesaExtra = binding.txtBatalhaDefesa.text.toString().toInt()
                guerreiro1.destrezaExtra = binding.txtBatalhaDestreza.text.toString().toInt()

                binding.txtBatalhaGuerreiro1.text = "${binding.txtBatalhaNome.text}"
                if(binding.boxBatalhaAtila.isChecked==true) {
                    guerreiro2.nome = "Átila"
                    guerreiro2.vidaExtra = 15
                    guerreiro2.forcaExtra = 45
                    guerreiro2.defesaExtra = 45
                    guerreiro2.destrezaExtra = 25

                    binding.txtBatalhaGuerreiro2.text = guerreiro2.nome
                }else if(binding.boxBatalhaLeonidas.isChecked==true){
                    guerreiro2.nome = "Leonidas"
                    guerreiro2.vidaExtra = 45
                    guerreiro2.forcaExtra = 45
                    guerreiro2.defesaExtra = 20
                    guerreiro2.destrezaExtra = 20

                    binding.txtBatalhaGuerreiro2.text = guerreiro2.nome
                }else if(binding.boxBatalhaGK.isChecked==true){
                    guerreiro2.nome = "Genghis Khan"
                    guerreiro2.vidaExtra = 45
                    guerreiro2.forcaExtra = 20
                    guerreiro2.defesaExtra = 20
                    guerreiro2.destrezaExtra = 45

                    binding.txtBatalhaGuerreiro2.text = guerreiro2.nome
                }

                vidaAtualG1 = guerreiro1.vida(guerreiro1.vidaExtra)
                vidaAtualG2 = guerreiro2.vida(guerreiro2.vidaExtra)

                binding.barGuerreiro1.max = vidaAtualG1
                binding.barGuerreiro2.max = vidaAtualG2

                binding.barGuerreiro1.progress = vidaAtualG1
                binding.barGuerreiro2.progress = vidaAtualG2

                binding.txtBatalhaMensagens.text = "INICIO DA LUTA, Clique em ATACAR!!"
            }

        }
        binding.btBatalhaProximoTurno.setOnClickListener {

            if(vidaAtualG1>0&&vidaAtualG2>0) {
                arena.batalha(guerreiro1, guerreiro2)
                binding.txtBatalhaResultadoG1.text = arena.resultadoG1()
                binding.txtBatalhaResultadoG2.text = arena.resultadoG2()

                if (arena.danosG1 < 0) {
                    vidaAtualG1 = vidaAtualG1 + arena.danosG1
                    binding.barGuerreiro1.progress = vidaAtualG1
                }
                if (arena.danosG2 < 0) {
                    vidaAtualG2 = vidaAtualG2 + arena.danosG2
                    binding.barGuerreiro2.progress = vidaAtualG2
                }
                binding.txtBatalhaMensagens.text = "TURNO ${arena.turno}!"

            }else if(vidaAtualG2<0&&vidaAtualG1>0&&arena.turno!=0){
                binding.txtBatalhaMensagens.text = "VITÓRIA DO Guerreiro 1 no turno ${arena.turno}!"
                arena.turno = 0
                arena.limpaLista()
            }
             else if(vidaAtualG1<0&&vidaAtualG2>0&&arena.turno!=0){
                binding.txtBatalhaMensagens.text = "VITÓRIA DO Guerreiro 2 no turno ${arena.turno}!"
                arena.turno = 0
                arena.limpaLista()
            }
        }

        setContentView(binding.root)
    }
}

