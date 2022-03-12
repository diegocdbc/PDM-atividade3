package com.example.atividade1

import java.util.*
import java.util.Random
import com.example.atividade1.ListaDePalavras

class Sorteio(){
    val random = Random()
    var numeroSorteado = 0
    var tamanhoLista = 0
    var mListaDicas = listOf("casa","escola","carro")
    var dica = ""
    private lateinit var banco: ListaDePalavras

    fun rand(from: Int, to: Int) : Int {
        return random.nextInt(to - from) + from // from(incluso) e to(excluso)
    }

    fun sorteiarDica() : String{

        //sorteiando a dica
        var tamanhoLista = mListaDicas.size
        this.numeroSorteado = this.rand(1,tamanhoLista)
        dica = mListaDicas[numeroSorteado]
        //var key = banco.mDicas.keys.random()
        //dica = banco.mDicas[key].toString()
        return dica
    }

    fun sorteiarPalavra() : String? {

        // sorteiando uma palavra de um grupo de palavras pertencentes a uma dica
        var listaDePalavras = ListaDePalavras()
        var mListaNomes = listaDePalavras.mDicas[mListaDicas[numeroSorteado]]
        if (mListaNomes != null) {
            tamanhoLista = mListaNomes.size
        }
        numeroSorteado = this.rand(1,tamanhoLista)
        var palavra = mListaNomes?.get(numeroSorteado)
        return palavra
    }


}