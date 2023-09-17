package com.example.portfolioandroid.repositorio

import com.example.portfolioandroid.datasource.DataSource

class tarefasRepositorio(private val dataSource: DataSource) {
    fun salvarTarefa(nome: String, inicio: String, termino: String, prioridade: Int, tipo: Int){
        dataSource.salvarTarefa(nome, inicio, termino, prioridade, tipo)
    }
}