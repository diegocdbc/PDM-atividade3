package com.example.atividade1

/**
 * 1.0 Sorteiar uma palavra aleatória #OK 27/02/2022
 * 1.1 Mascarar a palavra aleatória #OK 27/02/2022
 * 1.2 Ler string digitada #OK 27/02/2022
 * 1.3 Função que verifica se a letra está na palavra sorteada #OK 27/02/2022
 * 1.4 Implementar o laço #OK 27/02/2022
 * 1.5 Implementar bonequinho da forca #OK 27/02/2022
 * 1.6 Limpar prints #OK 27/02/2022
 * 1.7 Adicionar histórico de tentativas #OK 27/02/2022
 * 1.8 Modularizar #OK 27/02/2022
 * 1.9 Adicionar regra de digitar apenas uma letra #OK 02/03/2022
 * 2.0 Garantir que não sejam digitados números #OK 02/03/2022
 * 2.1 Ver dica #OK 07/03/2022
 * 2.2 Revisar Classe Forca
 * 2.3 Adição de níveis de dificuldade
 */

/*imports*/
//import java.util.Random
//import java.util.Scanner
import com.example.atividade1.Sorteio
import com.example.atividade1.Forca
import com.example.atividade1.ListaDePalavras

fun main() {

    //instanciamento de objetos, sorteando dica e palavra pertencente aquela dica
    var s = Sorteio()
    var dica = s.sorteiarDica()
    var palavra = s.sorteiarPalavra()
    var forca = palavra?.let { Forca(it) }
    println("Bem vindo ao jogo da Forca!\nA dica é: algo relacionado a ${dica}")

    // Se o objeto forca não for nulo a palavra será mascarada ( faca -> ____)

    if (forca != null) {
        print("\n${forca.mascararPalavra()}")
    }
    var letraAtual = "start"

    // Laço de execução

    while (letraAtual != "exit" && forca != null){

        // interatividade game/usuário

        print("\nDigite uma letra: ")
        letraAtual = forca.inputLetra()

        println("\nLetra digitada: ${letraAtual}")
        forca.verificarLetra(letraAtual)

        println("\nPalavra: ${forca.aux}")

        // settando condições de parada

        if (forca.aux.contains("_") == false){
            println("\nVocê venceu a palavra é ${forca.aux}")
            break
        }else if (forca.erros == 6){
            break
        }

    }

}