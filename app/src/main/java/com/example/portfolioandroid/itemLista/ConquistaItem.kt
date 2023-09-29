package com.example.portfolioandroid.itemLista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.portfolioandroid.R
import com.example.portfolioandroid.model.Conquistas

@Composable
fun ConquistaItem(
    position: Int,
    listarConquista: MutableList<Conquistas>
){
    val nomeCons = listarConquista[position].nomeCon
    val descCon = listarConquista[position].desCon
    val tipoCo = listarConquista[position].tipoCon
    val compCon = listarConquista[position].feitaCon
    val totalCom = listarConquista[position].totalCon

    var nivelTipo: String = when(tipoCo){
        0 -> {
            "Lazer"
        }
        1 -> {
            "Trabalho"
        }
        2 -> {
            "Exercicio"
        }
        else -> {
            "Exercicio"
        }}
    Card (
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (nomeCon,descriCon,descri,tipo,progresso, concuida,total,btDelete) = createRefs()
            Text(text ="Conquista: "+"$nomeCons", fontSize = 20.sp, fontWeight = FontWeight.Bold , modifier = Modifier.constrainAs(nomeCon){
                top.linkTo(parent.top,margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
            })
            Text(text = "Descrição:",fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(descri){
                top.linkTo(nomeCon.bottom,margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
                bottom.linkTo(descriCon.top,margin = 10.dp)

            })
            Text(text = descCon.toString(), modifier = Modifier.constrainAs(descriCon){
                start.linkTo(parent.start,margin = 10.dp)
                top.linkTo(descri.bottom,margin = 10.dp)

            })
            Text(text = "Tipo de Tarefa: "+"$nivelTipo",fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(tipo) {
                top.linkTo(descriCon.bottom, margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
                bottom.linkTo(progresso.top, margin = 10.dp)
            })
            Text(text = "Tarefas Feitas: ",fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(progresso) {
                top.linkTo(tipo.bottom, margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
            })
            Text(text = "($compCon/$totalCom)",fontSize = 16.sp, modifier = Modifier.constrainAs(total) {
                top.linkTo(tipo.bottom, margin = 10.dp)
                start.linkTo(progresso.end,margin = 20.dp)
            })

            IconButton(onClick = {},modifier = Modifier.constrainAs(btDelete){
                top.linkTo(descriCon.bottom, margin = 10.dp)
                start.linkTo(descriCon.end,margin = 40.dp)
                end.linkTo(parent.end, margin = 10.dp)
                bottom.linkTo(parent.bottom,margin = 10.dp)

            }) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete), contentDescription = null)
            }

        }
    }
}
