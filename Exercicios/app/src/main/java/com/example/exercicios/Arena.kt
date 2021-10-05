package com.example.exercicios

class Arena(guerreiro1:Guerreiro,guerreiro2:Guerreiro) {
    val listaBatalhaG1 = mutableListOf<String>()
    val listaBatalhaG2 = mutableListOf<String>()
    var danosG1:Int = 0
    var danosG2:Int = 0
    var turno  :Int = 0
    private var ataqueG1:Int=0
    private var ataqueG2:Int=0
    private var defesaG1:Int=0
    private var defesaG2:Int=0

    fun batalha(guerreiro1: Guerreiro,guerreiro2: Guerreiro) {
        ataqueG1 = guerreiro1.atacar()
        ataqueG2 = guerreiro2.atacar()
        defesaG1 = guerreiro1.defender()
        defesaG2 = guerreiro2.defender()

        danosG1  = defesaG1 - ataqueG2
        danosG2  = defesaG2 - ataqueG1
        if(danosG1>0){
            guerreiro1.aprendendoDefesa(danosG1)
            danosG1=0
        }
        if(danosG2>0){
            guerreiro2.aprendendoDefesa(danosG2)
            danosG2=0
        }

        if(!guerreiro1.esquiva()) {
            guerreiro1.perderVida(danosG1)
            if(guerreiro1.vida<0) guerreiro1.vida=0
            listaBatalhaG1.add(0,"Danos Recebido: ${-danosG1}\n\n")
        }
        else{
            listaBatalhaG1.add(0,"Se esquivou de ${-danosG1} danos\n\n")
            if(danosG1<0) guerreiro1.aprendendoDestreza(-danosG1)
            else guerreiro1.aprendendoDestreza(danosG1)
        }
        listaBatalhaG1.add(0,"Defesa: $defesaG1\n")
        listaBatalhaG1.add(0,"Ataque: $ataqueG1\n")
        listaBatalhaG1.add(0,"Vida: ${guerreiro1.vida}\n")

        if(!guerreiro2.esquiva()) {
            guerreiro2.perderVida(danosG2)
            if(guerreiro2.vida<0) guerreiro2.vida=0
            listaBatalhaG2.add(0,"Danos Recebido: ${-danosG2}\n\n")
        }else{
            listaBatalhaG2.add(0,"Se esquivou de ${-danosG2} danos\n\n")
            if(danosG2<0) guerreiro2.aprendendoDestreza(-danosG2)
            else guerreiro2.aprendendoDestreza(danosG2)
        }
        listaBatalhaG2.add(0,"Defesa: $defesaG2\n")
        listaBatalhaG2.add(0,"Ataque: $ataqueG2\n")
        listaBatalhaG2.add(0,"Vida: ${guerreiro2.vida}\n")

        turno++
    }
    fun resultado(lista: List<String>):String{
        var resultado = ""
        for (i in 0..(lista.size-1)){
            resultado += lista[i]
        }
        return resultado
    }
    fun limpaLista(){
        listaBatalhaG1.clear()
        listaBatalhaG2.clear()
    }

}