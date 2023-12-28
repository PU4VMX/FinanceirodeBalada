package com.example.financeirodebalada

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

import com.example.financeirodebalada.repository.FinancaRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun irParaResumo(view: View) {
        val intent = Intent(this, Resumo::class.java)
        startActivity(intent)
    }

    fun btnSalvar(view: View){
        val tipo = findViewById<RadioGroup>(R.id.radioGroup).checkedRadioButtonId.toString()
        val valor = findViewById<Button>(R.id.valor).text.toString()
        val data = findViewById<Button>(R.id.data).text.toString()
        val nome = findViewById<Button>(R.id.nome).text.toString()

        val financaRepository = FinancaRepository(this)
        financaRepository.salvarFinanca(nome, valor.toDouble(), data, tipo)
    }

}