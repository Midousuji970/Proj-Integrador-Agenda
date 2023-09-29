package com.example.portfolioandroid.datasource

import com.example.portfolioandroid.model.Tarefa
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource {
    private val db = FirebaseFirestore.getInstance()

    private val todas_tarefas = MutableStateFlow<MutableList<Tarefa>>(mutableListOf())
    private val _todasTarefas: StateFlow<MutableList<Tarefa>> = todas_tarefas

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
}
