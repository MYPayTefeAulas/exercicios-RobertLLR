package com.example.exercicios.agenda


class Agenda {
    private val listaAgenda = mutableListOf<PessoaAg>()
    private var indiceAtual = -1


    fun numContato():Int{return indiceAtual}
    fun deletarAg(){
        listaAgenda.removeAt(indiceAtual)
        indiceAtual--
    }
    fun buscarAg(contato:String): PessoaAg {
        indiceAtual = 0
        for (lista in listaAgenda) {
            if(contato==lista.nome||contato==lista.telefone) return listaAgenda[indiceAtual]
            indiceAtual++
        }
        return listaAgenda[indiceAtual]
    }
    fun salvarAg(salvarPessoa: PessoaAg){
        listaAgenda.add(salvarPessoa)
        indiceAtual++
    }
    fun editarAg(contato: PessoaAg){
        listaAgenda[indiceAtual]=contato
    }
    fun proximoAg() : PessoaAg {
       if(indiceAtual == listaAgenda.size -1){
           indiceAtual = 0
       } else {
           indiceAtual++
       }
        return listaAgenda[indiceAtual]
    }
    fun verificaContatoAg(contato: PessoaAg) :String{
        var testePessoaAg:String = "false"

        for (lista in listaAgenda) {
            if (lista.nome == contato.nome){
                testePessoaAg = contato.nome
                break
            }else if(lista.telefone == contato.telefone){
                testePessoaAg = contato.telefone
                break
            }
        }
        return testePessoaAg
    }
    fun listaVazia ():Boolean{
        return listaAgenda.size == 0
    }
    fun existenciaContato(nt:String): Boolean{
        for (lista in listaAgenda) {
            if(nt==lista.nome||nt==lista.telefone) return true
        }
        return false
    }

}