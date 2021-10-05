package com.example.exercicios

class Guerreiro(
    var nome:String,
    var vidaExtra:Int,
    var forcaExtra:Int,
    var defesaExtra:Int,
    var destrezaExtra:Int
) {
    var vida:Int = 100
    var forca:Int = 30
    var defesa:Int = 30
    var destreza:Int = 30

    fun carregarHabilidades(){
        vida     += vidaExtra
        forca    += forcaExtra
        defesa   += defesaExtra
        destreza += destrezaExtra
    }
    fun atacar():Int {
        var ataque:Int
        ataque=forca*destreza/100
        ataque=(1..ataque).random()
        return ataque
    }
    fun defender():Int {
        var def:Int
        def=defesa*destreza/100
        def=(1..def).random()
        return def
    }
    fun perderVida(danos:Int){
        if(danos<0) vida = vida+danos
    }
    fun esquiva():Boolean {
        var esquivar:Int
        esquivar = (1..(100-defesaExtra)).random()+defesaExtra
        if(esquivar>=70) return true
    return false
    }


}