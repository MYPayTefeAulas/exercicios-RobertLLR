package com.example.exercicios

class Arena(guerreiro1:Guerreiro,guerreiro2:Guerreiro) {
    private val listaBatalhaG1 = mutableListOf<String>()
    private val listaBatalhaG2 = mutableListOf<String>()
     var danosG1:Int=0
     var danosG2:Int=0
     var turno:Int=0
    private var ataqueG1:Int=0
    private var ataqueG2:Int=0
    private var defesaG1:Int=0
    private var defesaG2:Int=0

    fun batalha(guerreiro1: Guerreiro,guerreiro2: Guerreiro) {
        ataqueG1 = guerreiro1.atacar(guerreiro1.forcaExtra,guerreiro1.destrezaExtra)
        ataqueG2 = guerreiro2.atacar(guerreiro2.forcaExtra,guerreiro2.destrezaExtra)
        defesaG1 = guerreiro1.defender(guerreiro1.defesaExtra,guerreiro1.destrezaExtra)
        defesaG2 = guerreiro2.defender(guerreiro2.defesaExtra,guerreiro2.destrezaExtra)
        danosG1  = defesaG1 - ataqueG2
        danosG2  = defesaG2 - ataqueG1

        listaBatalhaG1.add(0,"Danos Recebido: $danosG1\n\n")
        listaBatalhaG1.add(0,"Defesa: $defesaG1\n")
        listaBatalhaG1.add(0,"Ataque: $ataqueG1\n")

        listaBatalhaG2.add(0,"Danos Recebido: $danosG2\n\n")
        listaBatalhaG2.add(0,"Defesa: $defesaG2\n")
        listaBatalhaG2.add(0,"Ataque: $ataqueG2\n")
        turno++
    }
    fun resultadoG1():String{
        var resultado:String
        resultado = ""
        for (i in 0..(listaBatalhaG1.size-1)){
            resultado =resultado+listaBatalhaG1[i]
        }
        return resultado
    }

    fun resultadoG2():String{
        var resultado:String
        resultado = ""
        for (i in 0..(listaBatalhaG2.size-1)){
            resultado =resultado+listaBatalhaG2[i]
        }
        return resultado
    }

    fun limpaLista(){
        listaBatalhaG1.clear()
        listaBatalhaG2.clear()
    }

}