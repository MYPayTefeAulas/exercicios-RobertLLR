package com.example.exercicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityCalculadoraBinding
import java.lang.RuntimeException
import kotlin.math.*

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculadoraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var somaCaracter  = ""
        var totalCaracter = ""
        var resultado = ""

        setTitle("Calculadora")
        binding = ActivityCalculadoraBinding.inflate(layoutInflater)

        binding.bt1.setOnClickListener {
            somaCaracter += "1"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.bt2.setOnClickListener {
            somaCaracter += "2"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.bt3.setOnClickListener {
            somaCaracter += "3"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.bt4.setOnClickListener {
            somaCaracter += "4"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.bt5.setOnClickListener {
            somaCaracter += "5"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.bt6.setOnClickListener {
            somaCaracter += "6"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.bt7.setOnClickListener {
            somaCaracter += "7"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.bt8.setOnClickListener {
            somaCaracter += "8"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.bt9.setOnClickListener {
            somaCaracter += "9"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.bt0.setOnClickListener {
            somaCaracter += "0"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btPonto.setOnClickListener {
            somaCaracter += "."
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btCalculadoraParetesEsq.setOnClickListener {
            somaCaracter += "("
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btCalculadoraParentesDir.setOnClickListener {
            somaCaracter += ")"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btMultiplicacao.setOnClickListener {
            somaCaracter += "*"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btDivisao.setOnClickListener {
            somaCaracter += "/"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btSubtracao.setOnClickListener {
            somaCaracter += "-"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btSoma.setOnClickListener {
            somaCaracter += "+"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btPotencia.setOnClickListener {
            somaCaracter += "^"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btRaiz.setOnClickListener {
            somaCaracter += "sqrt"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btTan.setOnClickListener {
            somaCaracter += "tan"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btCos.setOnClickListener {
            somaCaracter += "cos"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btSen.setOnClickListener {
            somaCaracter += "sen"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btPorcentagem.setOnClickListener {
            somaCaracter += "%"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btLog.setOnClickListener {
            somaCaracter += "log"
            binding.txtEntrada.setText(somaCaracter)
        }
        binding.btLimpar.setOnClickListener {
            somaCaracter = ""
            binding.txtEntrada.setText("0.0")
        }
        binding.btLimpaHistorico.setOnClickListener {
            resultado = ""
            binding.txtTela.text = resultado
        }
        binding.btIgual.setOnClickListener {
            totalCaracter = binding.txtEntrada.text.toString()
            try {
                resultado += totalCaracter+" = "+eval(totalCaracter).toString() + "\n"
            } catch (erro:Exception){
                resultado += erro.toString() +"\n"
            }

            binding.txtTela.text = resultado
        }


        setContentView(binding.root)
    }
    fun eval(str: String): Double {
        return object : Any() {
            var pos = -1
            var ch = 0
            fun nextChar() {
                ch = if (++pos < str.length) str[pos].toInt() else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.toInt()) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.toInt())) x += parseTerm() // addition
                    else if (eat('-'.toInt())) x -= parseTerm() // subtraction
                    else return x
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.toInt())) x *= parseFactor() // multiplication
                    else if (eat('/'.toInt())) x /= parseFactor() // division
                    else if (eat('%'.toInt())) x = (x/100)*parseFactor() // porcentagem
                    else return x
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.toInt())) return parseFactor() // unary plus
                if (eat('-'.toInt())) return -parseFactor() // unary minus
                var x: Double
                val startPos = pos
                if (eat('('.toInt())) { // parentheses
                    x = parseExpression()
                    eat(')'.toInt())
                } else if (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) {
                    while (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) nextChar()
                    x = str.substring(startPos, pos).toDouble()
                } else if (ch >= 'a'.toInt() && ch <= 'z'.toInt()) {
                    while (ch >= 'a'.toInt() && ch <= 'z'.toInt()) nextChar()
                    val func = str.substring(startPos, pos)
                    x = parseFactor()
                    x =
                        if      (func == "sqrt") sqrt(x)
                        else if (func == "log")  log10(x)
                        else if (func == "sin")  sin(x)
                        else if (func == "cos")  cos(x)
                        else if (func == "tan")  tan(x)
                        else  throw RuntimeException("Unknown function: $func")
                } else {throw RuntimeException("Unexpected: " + ch.toChar())}
                if (eat('^'.toInt())) x = x.pow(parseFactor())
                return x
            }
        }.parse()
    }
}