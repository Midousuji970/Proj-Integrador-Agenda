package com.example.portfolioandroid.datasource

import com.example.portfolioandroid.model.Gasto
import com.example.portfolioandroid.model.Tarefa
import com.example.portfolioandroid.model.Usuarios
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource {
    private val db = FirebaseFirestore.getInstance()

    private val todas_tarefas = MutableStateFlow<MutableList<Tarefa>>(mutableListOf())
    private val _todasTarefas: StateFlow<MutableList<Tarefa>> = todas_tarefas
    private val todas_gasto = MutableStateFlow<MutableList<Gasto>>(mutableListOf())
    private val _todasGasto: StateFlow<MutableList<Gasto>> = todas_gasto
    private val todas_usu = MutableStateFlow<MutableList<Usuarios>>(mutableListOf())
    private val _todasUsu: StateFlow<MutableList<Usuarios>> = todas_usu
    fun salvaraTarefa(nomesTarefa: String, iniTarefa: String, fimTarefa: String, prioridade: Int, tipo: Int){
        val tarefaMap = hashMapOf(
            "nomeTarefa" to nomesTarefa,
            "iniTarefa" to iniTarefa,
            "fimTarefa" to fimTarefa,
            "prioridade" to prioridade,
            "tipo" to tipo
        )
        db.collection("tarefas").document(nomesTarefa).set(tarefaMap).addOnCompleteListener{

        }.addOnFailureListener{

        }


    }
    fun recuperarTarefas(): Flow<MutableList<Tarefa>>{


        val listaTarefa: MutableList<Tarefa> = mutableListOf()
        db.collection("tarefas").get().addOnCompleteListener{
            querySnapshot -> if(querySnapshot.isSuccessful){
                for(documento in querySnapshot.result){
                    val tarefa = documento.toObject(Tarefa::class.java)
                    listaTarefa.add(tarefa)
                    todas_tarefas.value = listaTarefa
                }
        }
        }
        return _todasTarefas
    }
    fun DeletarTarefa(tarefa: String){
        db.collection("tarefas").document(tarefa).delete().addOnCompleteListener {

        }.addOnFailureListener{

        }

    }
    fun salvarGasto(nomeGasto: String, descriGasto: String, tipoGasto: String){
        val gastoMap = hashMapOf(
            "nomeGasto" to nomeGasto,
            "descriGasto" to descriGasto,
            "tipoGasto" to tipoGasto

        )
        db.collection("gasto").document(nomeGasto).set(gastoMap).addOnCompleteListener{

        }.addOnFailureListener{

        }


    }
    fun recuperarGasto(): Flow<MutableList<Gasto>>{


        val listaGasto: MutableList<Gasto> = mutableListOf()
        db.collection("gasto").get().addOnCompleteListener{
                querySnapshot -> if(querySnapshot.isSuccessful){
            for(documento in querySnapshot.result){
                val gasto = documento.toObject(Gasto::class.java)
                listaGasto.add(gasto)
                todas_gasto.value = listaGasto
            }
        }
        }
        return _todasGasto
    }
    fun DeletarGasto(gasto: String) {
        db.collection("gasto").document(gasto).delete().addOnCompleteListener {

        }.addOnFailureListener {

        }
    }

        fun salvarUsuario(nomeUsu: String, perfil: String){
            val usuMap = hashMapOf(
                "nomeUsu" to nomeUsu,
                "perfil" to perfil

            )
            db.collection("usuario").document(nomeUsu).set(usuMap).addOnCompleteListener{

            }.addOnFailureListener{

            }


        }
        fun recuperarUsuario(): Flow<MutableList<Usuarios>>{


            val listarUsuario: MutableList<Usuarios> = mutableListOf()
            db.collection("usuario").get().addOnCompleteListener{
                    querySnapshot -> if(querySnapshot.isSuccessful){
                for(documento in querySnapshot.result){
                    val usuario = documento.toObject(Usuarios::class.java)
                    listarUsuario.add(usuario)
                    todas_usu.value = listarUsuario
                }
            }
            }
            return _todasUsu
        }
    fun DeletarUsuario(usuario: String) {
        db.collection("usuario").document(usuario).delete().addOnCompleteListener {

        }.addOnFailureListener {

        }
    }

    }

