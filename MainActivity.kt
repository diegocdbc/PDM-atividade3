package com.example.forcaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.atividade1.Forca
import com.example.atividade1.Sorteio

class MainActivity : AppCompatActivity() {
    //Inicializando objetos
    private lateinit var tvLayout: TextView
    private lateinit var tvDica: TextView
    //private lateinit var banco: ListaDePalavras
    private lateinit var sorteio: Sorteio
    private lateinit var forca: Forca

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciando objetos
        //this.banco = ListaDePalavras()
        this.sorteio = Sorteio()
        this.tvLayout = findViewById(R.id.tvLayout)
        this.tvDica = findViewById(R.id.tvDica)

        // Recuperando valores de nome + dica
        var dica = sorteio.sorteiarDica()
        var palavra = sorteio.sorteiarPalavra()

        //Instanciando Forca
        this.forca = palavra?.let { Forca(it) }!!

        // recebendo a palavra mascarada
        this.tvLayout.text = "["+this.forca.mascararPalavra()+"]"
        this.tvDica.text = "a dica é algo relacionado a "+dica
    }
}