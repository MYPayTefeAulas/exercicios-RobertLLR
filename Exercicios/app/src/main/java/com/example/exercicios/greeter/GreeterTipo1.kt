package com.example.exercicios.greeter

class GreeterTipo1 (val cumprimento1: String, val cumprimento2:String, val cumprimento3:String ) {

    fun greet1 (nome:String):String{
        val cumprimentoCompleto = "$cumprimento1 $nome $cumprimento3"
        return cumprimentoCompleto
    }
    fun greet2 (nome:String, idade:Int):String{
        val cumprimentoCompleto = "$cumprimento1 $nome. $cumprimento2 $idade  $cumprimento3"
        return cumprimentoCompleto
    }
}