package com.example.exercicios

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exercicios.databinding.ActivityCalculadoraBinding
import com.example.exercicios.databinding.ActivityMainBinding
import kotlin.math.pow

class CalculadoraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculadoraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculadoraBinding.inflate(layoutInflater)

        var operacao:String = ""
        var numero1 :String = ""
        var numero2 :String = ""

        binding.btLimpar.setOnClickListener {
            numero1  = ""
            numero2  = ""
            operacao = ""
            binding.txtTela.text =  ""
        }
        binding.btPorcentagem.setOnClickListener {
            if (operacao != "+" && operacao != "-" && operacao != "*" && operacao != "/" && operacao != "^" && operacao != "%") {
                operacao = "%"
                binding.txtTela.text = binding.txtTela.text.toString() + "%"
            }
        }
        binding.btPotencia.setOnClickListener {
            if (operacao != "+" && operacao != "-" && operacao != "*" && operacao != "/" && operacao != "^" && operacao != "%") {
                operacao = "^"
                binding.txtTela.text = binding.txtTela.text.toString() + "^"
            }
        }
        binding.btMultiplicacao.setOnClickListener {
            if (operacao != "+" && operacao != "-" && operacao != "*" && operacao != "/" && operacao != "^" && operacao != "%") {
                operacao = "*"
                binding.txtTela.text = binding.txtTela.text.toString() + "*"
            }
        }
        binding.bt7.setOnClickListener {
            binding.txtTela.text = binding.txtTela.text.toString() + "7"
            if (operacao == "+" || operacao == "-" || operacao == "*" || operacao == "/" || operacao == "^" || operacao == "%") {
                numero2 = numero2 + "7"
            }else {
                numero1 = binding.txtTela.text.toString()
            }
        }
        binding.bt8.setOnClickListener {
            binding.txtTela.text = binding.txtTela.text.toString() + "8"
            if (operacao == "+" || operacao == "-" || operacao == "*" || operacao == "/" || operacao == "^" || operacao == "%") {
                numero2 = numero2 + "8"
            }else {
                numero1 = binding.txtTela.text.toString()
            }
        }
        binding.bt9.setOnClickListener {
            binding.txtTela.text = binding.txtTela.text.toString() + "9"
            if (operacao == "+" || operacao == "-" || operacao == "*" || operacao == "/" || operacao == "^" || operacao == "%") {
                numero2 = numero2 + "9"
            }else {
                numero1 = binding.txtTela.text.toString()
            }
        }
        binding.btDivisao.setOnClickListener {
            if (operacao != "+" && operacao != "-" && operacao != "*" && operacao != "/" && operacao != "^" && operacao != "%") {
                operacao = "/"
                binding.txtTela.text = binding.txtTela.text.toString() + "/"
            }
        }
        binding.bt4.setOnClickListener {
            binding.txtTela.text = binding.txtTela.text.toString() + "4"
            if (operacao == "+" || operacao == "-" || operacao == "*" || operacao == "/" || operacao == "^" || operacao == "%") {
                numero2 = numero2 + "4"
            }else {
                numero1 = binding.txtTela.text.toString()
            }
        }
        binding.bt5.setOnClickListener {
            binding.txtTela.text = binding.txtTela.text.toString() + "5"
            if (operacao == "+" || operacao == "-" || operacao == "*" || operacao == "/" || operacao == "^" || operacao == "%") {
                numero2 = numero2 + "5"
            }else {
                numero1 = binding.txtTela.text.toString()
            }
        }
        binding.bt6.setOnClickListener {
            binding.txtTela.text = binding.txtTela.text.toString() + "6"
            if (operacao == "+" || operacao == "-" || operacao == "*" || operacao == "/" || operacao == "^" || operacao == "%") {
                numero2 = numero2 + "6"
            }else {
                numero1 = binding.txtTela.text.toString()
            }
        }
        binding.btSubtracao.setOnClickListener {
            if (operacao != "+" && operacao != "-" && operacao != "*" && operacao != "/" && operacao != "^" && operacao != "%") {
                operacao = "-"
                binding.txtTela.text = binding.txtTela.text.toString() + "-"
            }
        }
        binding.bt1.setOnClickListener {
            binding.txtTela.text = binding.txtTela.text.toString() + "1"
            if (operacao == "+" || operacao == "-" || operacao == "*" || operacao == "/" || operacao == "^" || operacao == "%") {
                numero2 = numero2 + "1"
            }else {
                numero1 = binding.txtTela.text.toString()
            }
        }
        binding.bt2.setOnClickListener {
            binding.txtTela.text = binding.txtTela.text.toString() + "2"
            if (operacao == "+" || operacao == "-" || operacao == "*" || operacao == "/" || operacao == "^" || operacao == "%") {
                numero2 = numero2 + "2"
            }else {
                numero1 = binding.txtTela.text.toString()
            }
        }
        binding.bt3.setOnClickListener {
            binding.txtTela.text = binding.txtTela.text.toString() + "3"
            if (operacao == "+" || operacao == "-" || operacao == "*" || operacao == "/" || operacao == "^" || operacao == "%") {
                numero2 = numero2 + "3"
            }else {
                numero1 = binding.txtTela.text.toString()
            }
        }
        binding.btSoma.setOnClickListener {
            if (operacao != "+" && operacao != "-" && operacao != "*" && operacao != "/" && operacao != "^" && operacao != "%") {
                operacao = "+"
                binding.txtTela.text = binding.txtTela.text.toString() + "+"
            }
        }
        binding.btMaisMenos.setOnClickListener {
            if (operacao != "+" && operacao != "-" && operacao != "*" && operacao != "/" && operacao != "^" && operacao != "%") {
                val valor = binding.txtTela.text.toString()
                val numero1= (valor.toDouble()*(-1.0)).toString()
                binding.txtTela.text = numero1
            }
        }
        binding.bt0.setOnClickListener {
            binding.txtTela.text = binding.txtTela.text.toString() + "0"
            if (operacao == "+" || operacao == "-" || operacao == "*" || operacao == "/" || operacao == "^" || operacao == "%") {
                numero2 = numero2 + "0"
            }else {
                numero1 = binding.txtTela.text.toString()
            }
        }
        binding.btPonto.setOnClickListener {
            binding.txtTela.text = binding.txtTela.text.toString() + "."
        }
        binding.btIgual.setOnClickListener {
            var resultado : Double = 0.0
            if (operacao == "+") {
                resultado = numero1.toDouble() + numero2.toDouble()
                numero1 = resultado.toString()
                numero2 = ""
                binding.txtTela.text = resultado.toString()
                operacao = ""
            }
            if (operacao == "-") {
                resultado = numero1.toDouble() - numero2.toDouble()
                numero1 = resultado.toString()
                numero2 = ""
                binding.txtTela.text = resultado.toString()
                operacao = ""
            }
            if (operacao == "*") {
                resultado = numero1.toDouble() * numero2.toDouble()
                numero1 = resultado.toString()
                numero2 = ""
                binding.txtTela.text = resultado.toString()
                operacao = ""
            }
            if (operacao == "/") {
                resultado = numero1.toDouble() / numero2.toDouble()
                numero1 = resultado.toString()
                numero2 = ""
                binding.txtTela.text = resultado.toString()
                operacao = ""
            }
            if (operacao == "^") {
                resultado = numero1.toDouble().pow(numero2.toDouble())
                numero1 = resultado.toString()
                numero2 = ""
                binding.txtTela.text = resultado.toString()
                operacao = ""
            }
            if (operacao == "%") {
                resultado = numero1.toDouble()*numero2.toDouble()/100
                numero1 = resultado.toString()
                numero2 = ""
                binding.txtTela.text = resultado.toString()
                operacao = ""
            }

        }
        binding.btVoltarCalculadora.setOnClickListener {
            val i = Intent (this@CalculadoraActivity, MainActivity :: class.java)
            startActivity(i)
        }

        setContentView(binding.root)
    }
}