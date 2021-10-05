package com.example.exercicios

class Guerreiro(
    var nome         :String,
    var vidaExtra    :Int,
    var forcaExtra   :Int,
    var defesaExtra  :Int,
    var destrezaExtra:Int
) {
    var vida:Int     = 0
    var forca:Int    = 0
    var defesa:Int   = 0
    var destreza:Int = 0

    fun carregarHabilidades(){
        vida     = 100 + vidaExtra
        forca    = 30  + forcaExtra
        defesa   = 30  + defesaExtra
        destreza = 30  + destrezaExtra
    }
    fun zerarHabilidades(){
        vida     = 0
        forca    = 0
        defesa   = 0
        destreza = 0
    }
    fun atacar():Int {
        var ataque:Int = forca*destreza/100
        ataque = (1..ataque).random()
        return ataque
    }
    fun defender():Int {
        var def:Int = defesa*destreza/100
        def = (1..def).random()
        return def
    }
    fun perderVida(danos:Int){
        if(danos<0) vida = vida+danos
    }
    fun esquiva():Boolean {
        var esquivar:Int = (1..(100-defesaExtra)).random()+defesaExtra
        if(esquivar>=70) return true
    return false
    }
    fun aprendendoDefesa(defAprendido:Int){
        defesa+=(0..defAprendido).random()/10
    }
    fun aprendendoDestreza(desAprendida:Int){
        destreza+=(0..desAprendida).random()/10
    }


}