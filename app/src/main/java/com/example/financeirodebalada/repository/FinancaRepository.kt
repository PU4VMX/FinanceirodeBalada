package com.example.financeirodebalada.repository

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.financeirodebalada.dados.EsquemaBD
import com.example.financeirodebalada.dados.MeuBancoSQLite

class FinancaRepository (var contexto: Context) {
    lateinit var banco: MeuBancoSQLite
    lateinit var conexao: SQLiteDatabase

    init {
        this.banco = MeuBancoSQLite(this.contexto)
        this.conexao = this.banco.writableDatabase
    }

    fun salvarFinanca(nome: String, valor: Double, data: String, tipo: String): Boolean {
        val valores: ContentValues = ContentValues()

        valores.put(EsquemaBD.tabela_financas.NOME_ATT, nome)
        valores.put(EsquemaBD.tabela_financas.VALOR_ATT, valor)
        valores.put(EsquemaBD.tabela_financas.DATA_ATT, data)
        valores.put(EsquemaBD.tabela_financas.TIPO_ATT, tipo)

        return this.conexao.insert(EsquemaBD.tabela_financas.NOME_TABELA,
            null, valores) > 0
    }

    fun calculaSaldo(): Double {
        val tuplasBanco = this.conexao.query(
            EsquemaBD.tabela_financas.NOME_TABELA, arrayOf(EsquemaBD.tabela_financas.VALOR_ATT,
                EsquemaBD.tabela_financas.TIPO_ATT), null, null, null, null, null)

        var saldo = 0.0

        while (tuplasBanco.moveToNext()) {
            if (tuplasBanco.getString(1) == "Receita") {
                saldo += tuplasBanco.getDouble(0)
            } else {
                saldo -= tuplasBanco.getDouble(0)
            }
        }

        return saldo
    }

    fun calculaReceita(): Double {
        val tuplasBanco = this.conexao.query(
            EsquemaBD.tabela_financas.NOME_TABELA, arrayOf(EsquemaBD.tabela_financas.VALOR_ATT,
                EsquemaBD.tabela_financas.TIPO_ATT), null, null, null, null, null)

        var receita = 0.0

        while (tuplasBanco.moveToNext()) {
            if (tuplasBanco.getString(1) == "Receita") {
                receita += tuplasBanco.getDouble(0)
            }
        }

        return receita
    }

    fun calculaDespesa(): Double {
        val tuplasBanco = this.conexao.query(
            EsquemaBD.tabela_financas.NOME_TABELA, arrayOf(EsquemaBD.tabela_financas.VALOR_ATT,
                EsquemaBD.tabela_financas.TIPO_ATT), null, null, null, null, null)

        var despesa = 0.0

        while (tuplasBanco.moveToNext()) {
            if (tuplasBanco.getString(1) == "Despesa") {
                despesa += tuplasBanco.getDouble(0)
            }
        }

        return despesa
    }


}