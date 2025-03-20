package com.example.calculadora2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val botaoMais = findViewById<Button>(R.id.mais)
        val botaoMenos = findViewById<Button>(R.id.menos)
        val botaoMult = findViewById<Button>(R.id.multiplicacao)
        val botaoDiv = findViewById<Button>(R.id.divisao)
        var num1 = findViewById<EditText>(R.id.num1)
        var num2 = this.findViewById<EditText>(R.id.num2)
        var result = this.findViewById<TextView>(R.id.result)
        var sinal = this.findViewById<TextView>(R.id.sinalOperacao)

        //Toast.makeText(this.baseContext, "short/long message", Toast.LENGTH_LONG).show()

        botaoMais.setOnClickListener {
            if (num1.text.isNullOrEmpty() || num2.text.isNullOrEmpty() ){
                Toast.makeText(this.baseContext, "Digite um numero valido", Toast.LENGTH_SHORT).show()
            }
            else{
                result.text = resultado(
                    "+",
                    num1.text.toString().toDouble(),
                    num2.text.toString().toDouble(),
                    sinal
                )
            }
        }
        botaoMenos.setOnClickListener {
            if (num1.text.isNullOrEmpty() || num2.text.isNullOrEmpty() ){
                Toast.makeText(this.baseContext, "Digite um numero valido", Toast.LENGTH_SHORT).show()
            }
            else{
                result.text = resultado(
                    "-",
                    num1.text.toString().toDouble(),
                    num2.text.toString().toDouble(),
                    sinal
                )
            }
        }
        botaoMult.setOnClickListener {

            if (num1.text.isNullOrEmpty() || num2.text.isNullOrEmpty() ){
                Toast.makeText(this.baseContext, "Digite um numero valido", Toast.LENGTH_SHORT).show()
            }
            else{
                result.text = resultado(
                    "x",
                    num1.text.toString().toDouble(),
                    num2.text.toString().toDouble(),
                    sinal
                )
            }
        }
        botaoDiv.setOnClickListener {
            if (num1.text.isNullOrEmpty() || num2.text.isNullOrEmpty() ){
                Toast.makeText(this.baseContext, "Digite um numero valido", Toast.LENGTH_SHORT).show()
            }
            else{
                result.text = resultado(
                    "/",
                    num1.text.toString().toDouble(),
                    num2.text.toString().toDouble(),
                    sinal
                )
            }
        }
    }

    private fun resultado(tipo: String, num1: Double, num2: Double, sinal: TextView): String {
        var retorno = 0.0
        when {
            tipo == "+" -> retorno = (num1 + num2)
            tipo == "-" -> retorno = (num1 - num2)
            tipo == "x" -> retorno = (num1 * num2)
            tipo == "/" -> retorno = (num1 / num2)
        }
        sinal.text = tipo
        return String.format("%.4f", retorno)
    }
}