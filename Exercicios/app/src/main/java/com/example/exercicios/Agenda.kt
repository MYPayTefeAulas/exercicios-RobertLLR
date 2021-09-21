package com.example.exercicios


class Agenda {
    private val listaAgenda = mutableListOf<PessoaAg>()
    private var indiceAtual = -1


    fun deletarAg(contato:PessoaAg){
        listaAgenda.removeAt(indiceAtual)
        indiceAtual--
    }


    fun salvarAg(salvarPessoa:PessoaAg){
        listaAgenda.add(salvarPessoa)
        indiceAtual++
    }

    fun proximoAg() : PessoaAg{
       if(indiceAtual == listaAgenda.size -1){
           indiceAtual = 0
       } else {
           indiceAtual++
       }
        return listaAgenda[indiceAtual]
    }
    fun verificaContatoAg(contato:PessoaAg) :String{
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
//    fun existenciaContatoAg(contato:PessoaAg) : Boolean{
//        var aux:Boolean=false
//        for(lista in listaAgenda){
//            if (lista.nome == contato.nome &&
//                lista.telefone == contato.telefone ) {
//                aux = true
//                break
//            }
//        }
//        return aux
//    }
}