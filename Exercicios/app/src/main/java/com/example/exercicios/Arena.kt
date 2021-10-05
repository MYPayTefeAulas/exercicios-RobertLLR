package com.example.exercicios

class Arena(guerreiro1:Guerreiro,guerreiro2:Guerreiro) {
    private val listaBatalhaG1 = mutableListOf<String>()
    private val listaBatalhaG2 = mutableListOf<String>()
    var danosG1:Int = 0
    var danosG2:Int = 0
    var turno  :Int = 0
    var testeEsquivaG1:Boolean=false
    var testeEsquivaG2:Boolean=false
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

        if(guerreiro1.esquiva()==false) {
            guerreiro1.perderVida(danosG1)
            listaBatalhaG1.add(0,"Danos Recebido: $danosG1\n\n")
        }
        else{
            listaBatalhaG1.add(0,"Danos Recebido: $danosG1, Esquivou\n\n")
        }

        listaBatalhaG1.add(0,"Defesa: $defesaG1\n")
        listaBatalhaG1.add(0,"Ataque: $ataqueG1\n")
        listaBatalhaG1.add(0,"Vida: ${guerreiro1.vida}\n")

        if(guerreiro2.esquiva()==false) {
            guerreiro2.perderVida(danosG2)
            listaBatalhaG2.add(0,"Danos Recebido: $danosG2\n\n")
        }else{
            listaBatalhaG2.add(0,"Danos Recebido: $danosG2, Esquivou\n\n")
        }
        listaBatalhaG2.add(0,"Defesa: $defesaG2\n")
        listaBatalhaG2.add(0,"Ataque: $ataqueG2\n")
        listaBatalhaG2.add(0,"Vida: ${guerreiro2.vida}\n")

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