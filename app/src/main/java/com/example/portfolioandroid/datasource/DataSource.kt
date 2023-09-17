package com.example.portfolioandroid.datasource

import com.google.firebase.firestore.FirebaseFirestore

class DataSource {
    private val db = FirebaseFirestore.getInstance()
    fun salvarTarefa(nome: String, inicio: String, termino: String, prioridade: Int, tipo: Int){
        val tarefaMap = hashMapOf(
            "tarefa" to nome,
            "inicio" to inicio,
            "termino" to  termino,
            "prioridade" to prioridade,
            "tipo" to tipo
        )
        db.collection("tarefas").document(nome).set(tarefaMap).addOnCompleteListener{

        }.addOnFailureListener{

        }


    }
}