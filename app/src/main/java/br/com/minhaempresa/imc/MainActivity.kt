package br.com.minhaempresa.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import kotlin.math.pow

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnCalcular: AppCompatButton
    lateinit var etPeso: AppCompatEditText
    lateinit var etAltura: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCalcular = findViewById(R.id.btnCalcularIMC)
        etPeso = findViewById(R.id.etPeso)
        etAltura = findViewById(R.id.etAltura)

        //etPeso.setOnClickListener(this)
        btnCalcular.setOnClickListener(this)
    }

    /***
     * Ocultando o teclado do Android.
     */
    private fun hideSoftKeyboard(){
        val softKeyManager =
            getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        softKeyManager.hideSoftInputFromWindow(btnCalcular.windowToken, 0)
    }

    private fun calcularImc(altura: Double, peso: Double) : Double{
        if (altura > 0.0 && peso > 0.0) {
            return (peso / (altura.pow(2.0)))
        } else {
            throw IllegalArgumentException("Altura e peso devem ser maiores que zero.")
        }
    }

    /***
     * Desafio:
     * Estudar como melhorar isso (muita coisa no onClick)
     */
    override fun onClick(v: View?) {

        if (v!!.id == R.id.btnCalcularIMC) {
            // escondendo o teclado
            hideSoftKeyboard()

            val peso = etPeso.text.toString().toDouble()
            val altura = etAltura.text.toString().toDouble()

            // verificando se a altura e peso informados são maiores que zero.
            try {
                val imc = calcularImc(altura, peso)

                // criando a intent (para abrir a outra activity)
                val intentResultado = Intent(this,ResultadoIMCActivity::class.java)

                // adicionando o parametro que desejamos
                intentResultado.putExtra("imc_resultado",imc)
                this.startActivity(intentResultado)

                /*
                    teste antes, depois retire o comentário da linha abaixo a linha abaixo e
                    descubra o que acontece quando vc apertar o "voltar" na tela de resultado
                    (voltar do próprio ANDROID)
                */
                // finish()

            }catch (arg : IllegalArgumentException){
                Toast.makeText(this, arg.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}