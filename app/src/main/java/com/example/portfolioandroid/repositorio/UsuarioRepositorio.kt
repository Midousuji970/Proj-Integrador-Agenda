package com.example.portfolioandroid.repositorio

import com.example.portfolioandroid.datasource.DataSource
import com.example.portfolioandroid.model.Usuarios
import kotlinx.coroutines.flow.Flow

class UsuarioRepositorio() {
    private val dataSource = DataSource()
    fun salvarUsuario(nomeUsu:String, perfil:String){
        dataSource.salvarUsuario(nomeUsu,perfil)
    }

    fun recuperarUsuario(): Flow<MutableList<Usuarios>>{
        return dataSource.recuperarUsuario()
    }

    fun deletarUsuario(usuario: String){
        dataSource.DeletarUsuario(usuario)
    }

}