package com.example.portfolioandroid.itemLista

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.portfolioandroid.R
import com.example.portfolioandroid.model.Tarefa
import com.example.portfolioandroid.repositorio.azulClaro
import com.example.portfolioandroid.repositorio.tarefasRepositorio
import com.example.portfolioandroid.ui.ShapeCardPrioridade
import com.example.portfolioandroid.ui.cinzaBack
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun TarefaItem(
    position: Int,
    listaTarefas: MutableList<Tarefa>,
    context: Context,
    navController: NavController
){
    val nomeTarefa = listaTarefas[position].nomeTarefa
    val dataIni = listaTarefas[position].iniTarefa
    val dataFim = listaTarefas[position].fimTarefa
    val prioridade = listaTarefas[position].prioridade
    val tipo = listaTarefas[position].tipo

    val scope = rememberCoroutineScope()
    val tarefaRepositorio = tarefasRepositorio()
    fun dialogDeletar(){
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Deletar Tarefa")
            .setMessage("Deseja Excluir a Tarefa?")
            .setPositiveButton("Sim"){
                _, _ ->

                tarefaRepositorio.DeletarTarefas(nomeTarefa.toString())
                scope.launch ( Dispatchers.Main ){
                    listaTarefas.removeAt(position)
                    navController.navigate("ListaDeTarefas")
                    Toast.makeText(context,"Sucesso ao Deletar Tarefa",Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Não"){_,_ ->}
            .show()

    }

    var nivelPrioridade: String = when(prioridade){
        0 -> {
            "Baixa Prioridade"
        }
        1 -> {
            "Media Prioridade"
        }
        2 -> {
            "Alta Prioridade"
        }
        else -> {
        "Alta Prioridade"
        }

    }
    val colorP = when(prioridade){
        0 -> {
            Color.Green
        }
        1 -> {
            Color.Yellow
        }
        2 ->{
            Color.Red
        }
        else -> {
            azulClaro
        }}
            var nivelTipo: String = when(tipo){
            0 -> {
                "Lazer:"
            }
            1 -> {
                "Trabalho:"
            }
            2 -> {
                "Exercicio:"
            }
            else -> {
                "Outro:"
            }

        }
            val colorT = when(tipo){
            0 -> {
                Color.Green
            }
            1 -> {
                Color.Yellow
            }
            2 ->{
                Color.Red
            }
            else -> {
                azulClaro
            }}

    Card (
        backgroundColor = cinzaBack,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
    ConstraintLayout(
        modifier = Modifier.padding(20.dp)
    ) {
        val (txtNome,txtDataIni,txtDataFim,cardPrioridade,txtPrioridade,cardTipo,txtTipo,btDelete) = createRefs()
        Text(text = "$nomeTarefa", fontSize = 20.sp, fontWeight = FontWeight.Bold , modifier = Modifier.constrainAs(txtNome){
            top.linkTo(parent.top,margin = 10.dp)
            start.linkTo(parent.start,margin = 10.dp)


        })
        Text(text = "Data de Inicio:\n"+dataIni.toString(), modifier = Modifier.constrainAs(txtDataIni){
            top.linkTo(txtNome.bottom,margin = 10.dp)
            start.linkTo(parent.start,margin = 10.dp)
        })
        Text(text = "Data de Término:\n"+dataFim.toString(), modifier = Modifier.constrainAs(txtDataFim){
            top.linkTo(txtNome.bottom,margin = 10.dp)
            start.linkTo(txtDataIni.end,margin = 30.dp)
            end.linkTo(parent.end,margin = 10.dp)
        })
        Text(text = nivelPrioridade , modifier = Modifier.constrainAs(txtPrioridade){

            top.linkTo(txtDataIni.bottom,margin = 10.dp)
            start.linkTo(parent.start,margin = 10.dp)
        })
        Card(

            backgroundColor = colorP,
            modifier = Modifier
                .size(30.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Color.Black, Color.Black)
                    ), shape = RoundedCornerShape(40.dp)
                )
                .constrainAs(cardPrioridade) {
                    top.linkTo(txtDataIni.bottom, margin = 15.dp)
                    start.linkTo(txtPrioridade.end, margin = 10.dp)
                    bottom.linkTo(txtPrioridade.bottom, margin = 5.dp)
                }, shape = ShapeCardPrioridade.large

        ){

        }
        Text(text = nivelTipo.toString(), modifier = Modifier.constrainAs(txtTipo){
            top.linkTo(txtPrioridade.bottom,margin = 15.dp)
            start.linkTo(parent.start,margin = 10.dp)
            bottom.linkTo(parent.bottom, margin = 10.dp)
        })
        IconButton(onClick = {},modifier = Modifier
            .size(30.dp)
            .constrainAs(cardTipo) {
                top.linkTo(txtPrioridade.bottom, margin = 15.dp)
                start.linkTo(txtTipo.end, margin = 10.dp)
                bottom.linkTo(parent.bottom, margin = 10.dp)

            }) {
            when(tipo){
                0 -> {
                    Image(imageVector = ImageVector.vectorResource(id = R.drawable.lazer), contentDescription = null)
                }
                1 -> {
                    Image(imageVector = ImageVector.vectorResource(id = R.drawable.trabalho), contentDescription = null)
                }
                2 ->{
                    Image(imageVector = ImageVector.vectorResource(id = R.drawable.saude), contentDescription = null)
                }
                else -> {
                    Image(imageVector = ImageVector.vectorResource(id = R.drawable.outros), contentDescription = null)
                }}}

        IconButton(onClick = {
                             dialogDeletar()
        },modifier = Modifier.constrainAs(btDelete){
            top.linkTo(txtPrioridade.bottom, margin = 10.dp)
            start.linkTo(cardTipo.end,margin = 40.dp)
            end.linkTo(parent.end, margin = 10.dp)
            bottom.linkTo(parent.bottom,margin = 10.dp)

        }) {
            Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete), contentDescription = null)
        }

        }
    }
    }
