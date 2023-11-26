package com.example.portfolioandroid.repositorio

import com.example.portfolioandroid.datasource.DataSource
import com.example.portfolioandroid.model.Gasto
import kotlinx.coroutines.flow.Flow

class GastoRepositorio() {
    private val dataSources = DataSource()
    fun salvarGasto(nomeGasto:String, descriGasto:String,tipoGasto:String){
        dataSources.salvarGasto(nomeGasto, descriGasto, tipoGasto)
    }

    fun recuperarGasto(): Flow<MutableList<Gasto>>{
        return dataSources.recuperarGasto()
    }

    fun DeletarGasto(gasto: String){
        dataSources.DeletarGasto(gasto)

    }
}