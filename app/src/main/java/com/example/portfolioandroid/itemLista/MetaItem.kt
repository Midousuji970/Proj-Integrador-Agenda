package com.example.portfolioandroid.itemLista

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.portfolioandroid.model.Metas
import com.example.portfolioandroid.repositorio.BackGrounde
import com.example.portfolioandroid.repositorio.verde
import com.example.portfolioandroid.repositorio.vermelho

@Composable
fun MetaItem(
    position: Int,
    listarMetas: MutableList<Metas>
) {

    val nomeTarefa = listarMetas[position].metas
    val descricao = listarMetas[position].descricaoMetas
    val concluidas = listarMetas[position].concluidas
    val naoConcluida = listarMetas[position].naoConcluidas
    var naoNao = naoConcluida.toString()
    var nao = naoNao.toInt()
    var conCon = concluidas.toString()
    var con = conCon.toInt()

    Card (
        border = BorderStroke(2.dp, BackGrounde)
        , backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {

            val (txtNome,txtDescricao,txtConcluidas, cardCon,txtNaoCon,cardNao, cardBase,cardBaseTop) = createRefs()
            Text(text = nomeTarefa.toString(), fontSize = 20.sp, fontWeight = FontWeight.Bold , modifier = Modifier.constrainAs(txtNome){
                top.linkTo(parent.top,margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)

            })
            Text(text = descricao.toString(), modifier = Modifier.constrainAs(txtDescricao){
                top.linkTo(txtNome.bottom,margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
            })
            Card(

                backgroundColor = Color.White,
                modifier = Modifier
                    .height(1.dp)
                    .width(150.dp)
                    .constrainAs(cardBaseTop) {
                        top.linkTo(txtDescricao.bottom, margin = 1.dp)
                        start.linkTo(parent.end)
                        end.linkTo(parent.start)
                        bottom.linkTo(txtConcluidas.top, margin = 1.dp)

                    }, shape = RectangleShape

            ){

            }

            Text(text = "Concluidas\n"+"        $concluidas", modifier = Modifier.constrainAs(txtConcluidas){
                top.linkTo(cardBaseTop.bottom,margin = 10.dp)
                start.linkTo(parent.start,margin = 1.dp)
                bottom.linkTo(parent.bottom, margin = 10.dp)
            })
            Card(

                backgroundColor = verde,
                modifier = Modifier
                    .height(if (con > nao) 100.dp else 80.dp)
                    .width(50.dp)
                    .constrainAs(cardCon) {
                        bottom.linkTo(cardBase.top, margin = -10.dp)
                        top.linkTo(cardBaseTop.bottom, margin = 10.dp)
                        start.linkTo(txtConcluidas.start, margin = 80.dp)

                    }, shape = RectangleShape

            ){

            }
            Text(text = "Não Concluidas\n"+"           $naoConcluida".toString(), modifier = Modifier.constrainAs(txtNaoCon){
                top.linkTo(cardBaseTop.bottom,margin = 10.dp)
                start.linkTo(cardNao.end, margin = 1.dp)
                bottom.linkTo(parent.bottom, margin = 10.dp)
            })
            Card(

                backgroundColor = vermelho,
                modifier = Modifier
                    .height(if (con < nao) 100.dp else 80.dp)
                    .width(50.dp)
                    .constrainAs(cardNao) {
                        bottom.linkTo(cardBase.top, margin = -10.dp)
                        top.linkTo(cardBaseTop.bottom, margin = 10.dp)
                        start.linkTo(cardCon.start, margin = 80.dp)
                    }, shape = RectangleShape

            ){

            }

            Card(

                backgroundColor = Color.Gray,
                modifier = Modifier
                    .height(10.dp)
                    .width(150.dp)
                    .constrainAs(cardBase) {
                        top.linkTo(cardCon.bottom, margin = 1.dp)
                        start.linkTo(txtConcluidas.end)
                        end.linkTo(txtNaoCon.start)
                        bottom.linkTo(parent.bottom, margin = 1.dp)

                    }, shape = RectangleShape

            ){

            }
        }
    }
}



