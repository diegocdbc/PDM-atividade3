package com.example.atividade1

import java.util.*

class Forca(var palavra: String){

    val random = Random()
    var aux = ""
    var erros = 0
    var count = 0
    var mHist = mutableListOf("")

    fun mascararPalavra(): String {

        for (i in 1 .. palavra.length){
            if (i == 1){
                aux = aux + "_"
            } else if (i != 1) {
                aux = aux +"_"
            } else {
                aux = ""
            }
        }
        return "${aux}"
    }

    fun inputLetra() : String {

        val letra:String? = readLine()
        return "${letra}"
    }

    fun bonecoForca(status: String){
        var boneco = ".______\n|     ´\n|      \n|       \n|       \n========="
        if(status.equals("erro")){
            erros += 1
            if(erros == 1){
                boneco = ".______\n|     ´\n|     O\n|       \n|       \n========="
            }else if(erros == 2){
                boneco = ".______\n|     ´\n|     O\n|    ´  \n|       \n========="
            }else if(erros == 3){
                boneco = ".______\n|     ´\n|     O\n|    ´| \n|       \n========="
            }else if(erros == 4){
                boneco = ".______\n|     ´\n|     O\n|    ´|`\n|       \n========="
            }else if(erros == 5){
                boneco = ".______\n|     ´\n|     O\n|    ´|`\n|    ´  \n========="
            }else if(erros == 6){
                boneco = "A palavra era ${palavra}\n.______         ************\n|     ´         ************\n|     O         **  VOCÊ  **\n|    ´|`        ** PERDEU **\n|    ´ `        ************\n=========       ************"
            }
            println("\nErrou!\nErros atuais: ${erros} \nNúmero máximo de erros permitidos: 6\n${boneco}")

        }
    }
    //modificar
    fun verificarLetra(letraAtual: String): String {
        // criar uma nova interface que valide a letra
        if(count == 0){
            mHist[0] = letraAtual
            count +=1
        }else if(letraAtual.length > 1) {
            println("Caracter inválido, forneça apenas uma letra")
            return "Valor inválido"
        }else if(letraAtual in "0123456789") {
            println("Caracter inválido, forneça apenas uma letra")
            return "Valor inválido"
        }else if(letraAtual in mHist) {
            println("Caracter inválido, que não tenha sido fornecida anteriormente")
            return "Valor inválido"
        }else{
            mHist.add(letraAtual)
            count +=1
        }
        //até aqui
        if(palavra.contains(letraAtual)){

            for (i in 0 .. palavra.length){

                if("${palavra[i]}" == "${letraAtual}"){

                    aux = aux.substring(0, i) + letraAtual + aux.substring(i + 1)
                    if(i+1 == palavra.length){
                        println("tentativas: ${mHist}")
                        return aux
                    }
                }else if(i+1 == palavra.length){
                    return aux
                }else{

                    aux = aux
                }
            }
        }else{
            println("tentativas: ${mHist}")
            this.bonecoForca("erro")
        }
        println("tentativas: ${mHist}")
        return aux
    }

}