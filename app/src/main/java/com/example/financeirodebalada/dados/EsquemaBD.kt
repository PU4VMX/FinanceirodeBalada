package com.example.financeirodebalada.dados

class EsquemaBD {
    //aqui temos variáveis estáticas da classe
    companion object{
        val NOME_BD:String = "bd_financas_balada"
        val VERSAO:Int = 1
    }

    object tabela_financas {
        val NOME_TABELA = "financeiro"
        val ID_ATT = "id"
        val NOME_ATT = "nome"
        val VALOR_ATT = "valor"
        val DATA_ATT = "data"
        val TIPO_ATT = "tipo"
        val CRIA_TABELA = "CREATE TABLE IF NOT EXISTS $NOME_TABELA " +
                "($ID_ATT INTEGER primary key autoincrement, " +
                "$NOME_ATT text, $VALOR_ATT text, $DATA_ATT text, " +
                "$TIPO_ATT text)"
    }
}