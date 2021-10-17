package com.example.exercicios.batalha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityBatalhaRpgBinding

class BatalhaRPGActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBatalhaRpgBinding
    private val guerreiro1 = Guerreiro("",0,0,0,0)
    private val guerreiro2 = Guerreiro("",0,0,0,0)
    //private val arena = Arena(guerreiro1,guerreiro2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBatalhaRpgBinding.inflate(layoutInflater)

        binding.boxBatalhaAtila.setOnCheckedChangeListener { compoundButton, b ->
           binding.boxBatalhaGK.isChecked = false
           binding.boxBatalhaLeonidas.isChecked = false
        }
        binding.boxBatalhaLeonidas.setOnCheckedChangeListener { compoundButton, b ->
            binding.boxBatalhaGK.isChecked = false
            binding.boxBatalhaAtila.isChecked = false
        }
        binding.boxBatalhaGK.setOnCheckedChangeListener { compoundButton, b ->
            binding.boxBatalhaLeonidas.isChecked = false
            binding.boxBatalhaAtila.isChecked = false
        }


        binding.btBatalhaIniciar.setOnClickListener {
            guerreiro1.zerarHabilidades()
            guerreiro2.zerarHabilidades()
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
                guerreiro1.carregarHabilidades()

                binding.txtBatalhaGuerreiro1.text = "${binding.txtBatalhaNome.text}"

                if(binding.boxBatalhaAtila.isChecked==true) {
                    guerreiro2.nome = "Átila"
                    guerreiro2.vidaExtra = 15
                    guerreiro2.forcaExtra = 45
                    guerreiro2.defesaExtra = 45
                    guerreiro2.destrezaExtra = 25
                    guerreiro2.carregarHabilidades()

                    binding.txtBatalhaGuerreiro2.text = guerreiro2.nome
                }else if(binding.boxBatalhaLeonidas.isChecked==true){
                    guerreiro2.nome = "Leonidas"
                    guerreiro2.vidaExtra = 45
                    guerreiro2.forcaExtra = 45
                    guerreiro2.defesaExtra = 20
                    guerreiro2.destrezaExtra = 20
                    guerreiro2.carregarHabilidades()

                    binding.txtBatalhaGuerreiro2.text = guerreiro2.nome
                }else if(binding.boxBatalhaGK.isChecked==true){
                    guerreiro2.nome = "Genghis Khan"
                    guerreiro2.vidaExtra = 45
                    guerreiro2.forcaExtra = 20
                    guerreiro2.defesaExtra = 20
                    guerreiro2.destrezaExtra = 45
                    guerreiro2.carregarHabilidades()

                    binding.txtBatalhaGuerreiro2.text = guerreiro2.nome
                }

                binding.barGuerreiro1.max = guerreiro1.vida
                binding.barGuerreiro2.max = guerreiro1.vida

                binding.barGuerreiro1.progress = guerreiro1.vida
                binding.barGuerreiro2.progress = guerreiro1.vida

                binding.txtBatalhaResultadoG1.text = "Histórico de Batalha"
                binding.txtBatalhaResultadoG2.text = "Histórico de Batalha"
                binding.txtBatalhaMensagens.text = "INICIO DA LUTA, Clique em ATACAR!!"
            }

        }
        binding.btBatalhaProximoTurno.setOnClickListener {

            if(guerreiro1.vida>0&&guerreiro2.vida>0) {

                Arena.batalha(guerreiro1, guerreiro2)

                binding.txtBatalhaResultadoG1.text = Arena.resultado(Arena.listaBatalhaG1)
                binding.txtBatalhaResultadoG2.text = Arena.resultado(Arena.listaBatalhaG2)
                binding.barGuerreiro1.progress = guerreiro1.vida
                binding.barGuerreiro2.progress = guerreiro2.vida

                binding.txtBatalhaMensagens.text = "TURNO ${Arena.turno}!"

            }else if(guerreiro2.vida<=0&&guerreiro1.vida>0&&Arena.turno!=0){
                binding.txtBatalhaMensagens.text = "VITÓRIA DO Guerreiro 1 no turno ${Arena.turno}!"
                Arena.turno = 0
                Arena.limpaLista()
            }
             else if(guerreiro1.vida<=0&&guerreiro2.vida>0&&Arena.turno!=0){
                binding.txtBatalhaMensagens.text = "VITÓRIA DO Guerreiro 2 no turno ${Arena.turno}!"
                Arena.turno = 0
                Arena.limpaLista()
            }
        }

        setContentView(binding.root)
    }
}

