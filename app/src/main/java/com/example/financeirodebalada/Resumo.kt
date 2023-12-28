package com.example.financeirodebalada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.financeirodebalada.repository.FinancaRepository

class Resumo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumo)
    }

    fun textoSaldo() {
        val saldo = findViewById<TextView>(R.id.saldo)
        val financaRepository = FinancaRepository(this)
        saldo.text = financaRepository.calculaSaldo().toString()
    }

    fun textoReceita() {
        val receita = findViewById<TextView>(R.id.receita)
        val financaRepository = FinancaRepository(this)
        receita.text = financaRepository.calculaReceita().toString()
    }

    fun textoDespesa() {
        val despesa = findViewById<TextView>(R.id.despesa)
        val financaRepository = FinancaRepository(this)
        despesa.text = (financaRepository.calculaSaldo() - financaRepository.calculaReceita()).toString()
    }

    fun atualizaTextos() {
        textoSaldo()
        textoReceita()
        textoDespesa()
    }

    override fun onResume() {
        super.onResume()
        atualizaTextos()
    }

}