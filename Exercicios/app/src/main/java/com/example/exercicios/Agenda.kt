package com.example.exercicios


class Agenda {
    private val listaAgenda = mutableListOf<Pessoa>()
    private var indiceAtual = 0


    fun deletarAg(excluirPessoa:Pessoa){

    }


    fun salvarAg(salvarPessoa:Pessoa){
        listaAgenda.add(salvarPessoa)
        indiceAtual++
    }

    fun proximoAg() : Pessoa{
       if(indiceAtual == listaAgenda.size - 1){
           indiceAtual = 0
       } else {
           indiceAtual++
       }
        return listaAgenda[indiceAtual]
    }
}