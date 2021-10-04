package com.example.exercicios

class Arena(guerreiro1:Guerreiro,guerreiro2:Guerreiro) {
    private val listaBatalhaG1 = mutableListOf<String>()
    private val listaBatalhaG2 = mutableListOf<String>()
     var danosG1:Int=0
     var danosG2:Int=0
    var turno:Int=0

    fun batalha(guerreiro1: Guerreiro,guerreiro2: Guerreiro) {
        danosG1=guerreiro1.defender(guerreiro1.defesaExtra,guerreiro1.destrezaExtra)-
                guerreiro2.atacar(guerreiro2.forcaExtra,guerreiro2.destrezaExtra)
        listaBatalhaG1.add(0,"Danos Recebido: $danosG1\n\n")
        listaBatalhaG1.add(0,"Defesa: ${guerreiro1.defender(guerreiro1.forcaExtra,guerreiro1.destrezaExtra)}\n")
        listaBatalhaG1.add(0,"Ataque: ${guerreiro1.atacar(guerreiro1.forcaExtra,guerreiro1.destrezaExtra)}\n")

        danosG2=guerreiro2.defender(guerreiro2.defesaExtra,guerreiro2.destrezaExtra)-
                guerreiro1.atacar(guerreiro1.forcaExtra,guerreiro1.destrezaExtra)
        listaBatalhaG2.add(0,"Danos Recebido: $danosG2\n\n")
        listaBatalhaG2.add(0,"Defesa: ${guerreiro2.defender(guerreiro2.forcaExtra,guerreiro2.destrezaExtra)}\n")
        listaBatalhaG2.add(0,"Ataque: ${guerreiro2.atacar(guerreiro2.forcaExtra,guerreiro2.destrezaExtra)}\n")
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

    fun danos(defesa:Int,ataque:Int):Int = defesa - ataque

    fun danosBoolean(danos:Int):Boolean{
        if(danos<0)return true
        return false
    }
}