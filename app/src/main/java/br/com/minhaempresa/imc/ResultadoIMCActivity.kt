package br.com.minhaempresa.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatTextView

class ResultadoIMCActivity : AppCompatActivity() {

    // para aqueles que já conhecem android ainda não estamos usando viewbinding
    // views
    private lateinit var tvImcResultado: AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imcactivity)

        // referenciando a view
        tvImcResultado = findViewById(R.id.tvImcResultado)

        // checando se o parametro chegou direitinho
        if(intent.hasExtra("imc_resultado")){
            tvImcResultado.text = String.format("%.2f",intent.getDoubleExtra("imc_resultado",0.0))
        }else{
            // não chegou... o que fazer? Nda. Fechar.
            finish()
        }

    }
}