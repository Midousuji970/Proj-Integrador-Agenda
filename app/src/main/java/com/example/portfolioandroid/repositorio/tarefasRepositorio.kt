package com.example.portfolioandroid.repositorio

import com.example.portfolioandroid.datasource.DataSource
import com.example.portfolioandroid.model.Tarefa
import kotlinx.coroutines.flow.Flow

class tarefasRepositorio() {
    private val dataSource = DataSource()
    fun salvarTarefa(nomeTarefa:String, iniTarefa:String,fimTarefa:String, prioridade: Int, tipo: Int){
        dataSource.salvaraTarefa(nomeTarefa, iniTarefa, fimTarefa, prioridade, tipo)
    }

    fun recuperarTarefas(): Flow<MutableList<Tarefa>>{
        return dataSource.recuperarTarefas()
    }

    fun DeletarTarefas(tarefa: String){
        dataSource.DeletarTarefa(tarefa)

    }
}