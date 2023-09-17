package com.example.portfolioandroid.telatarefas

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.portfolioandroid.itemLista.TarefaItem
import com.example.portfolioandroid.model.Tarefa
import com.example.portfolioandroid.repositorio.BackGrounde

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun ListaDeTarefas(
    navController: NavController
)
{

    Scaffold(topBar = {
        TopAppBar(backgroundColor = BackGrounde,
            title = { Text(text = "Lista de Tarefas",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)})
    },
        backgroundColor = BackGrounde
        )
    {
   val listarTarefas: MutableList<Tarefa> = mutableListOf(
       Tarefa(
           nomeTarefa = "Casar",
           iniTarefa = "10/02/2023",
           fimTarefa = "15/09/2023",
           prioridade = 1,
           tipo = 0
       ),
       Tarefa(
       nomeTarefa = "Entregar Projeto",
       iniTarefa = "19/05/2022",
       fimTarefa = "08/12/2023",
       prioridade = 2,
       tipo = 1
   ),
       Tarefa(
           nomeTarefa = "Treinar Perna",
           iniTarefa = "18/09/2023",
           fimTarefa = "18/09/2023",
           prioridade = 1,
           tipo = 2
       ),
       Tarefa(
           nomeTarefa = "Assistir Jogo",
           iniTarefa = "26/03/2023",
           fimTarefa = "26/03/20233",
           prioridade = 0,
           tipo = 0
       )
   )
        LazyColumn(){
            itemsIndexed(listarTarefas){position, _ ->
            TarefaItem(position,listarTarefas)
            }
        }
    }
}



