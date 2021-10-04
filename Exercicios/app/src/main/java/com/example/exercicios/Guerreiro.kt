package com.example.exercicios

class Guerreiro(
    var nome:String,
    var vidaExtra:Int,
    var forcaExtra:Int,
    var defesaExtra:Int,
    var destrezaExtra:Int
) {

    fun vida(vidaExtra: Int):Int {
        var vida:Int
        vida=vidaExtra+100
        return vida
    }

    fun forca(forcaExtra: Int):Int {
        var forca:Int
        forca = forcaExtra+30
        return forca
    }
    fun defesa(defesaExtra: Int):Int {
        var defesa:Int
        defesa = defesaExtra+30
        return defesa
    }
    fun destreza(destrezaExtra: Int):Int {
        var destreza:Int
        destreza = destrezaExtra+30
        return destreza
    }
    fun atacar(forcaExtra: Int,destrezaExtra: Int):Int {
        var ataque:Int
        ataque=forca(forcaExtra)*destreza(destrezaExtra)/100
        ataque=(1..ataque).random()
        return ataque
    }
    fun defender(defesaExtra: Int,destrezaExtra: Int):Int {
        var defesa:Int
        defesa=defesa(defesaExtra)*destreza(destrezaExtra)/100
        defesa=(1..defesa).random()
        return defesa
    }
    fun calculoVida(danos:Int,vidaAtual:Int):Int {
        return vidaAtual - danos
    }
    fun esquiva():Boolean {
    return true
    }
    fun calculodestreza() {

    }
    fun somaPontosExtra(vidaExtra:Int,forcaExtra:Int,defesaExtra:Int,destrezaExtra:Int):Int{
        return vidaExtra+forcaExtra+defesaExtra+destrezaExtra
    }
}