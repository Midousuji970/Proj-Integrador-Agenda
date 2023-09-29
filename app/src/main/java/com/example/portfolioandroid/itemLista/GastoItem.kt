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
import com.example.portfolioandroid.model.Gasto

@Composable
fun GastoItem(
    position: Int,
    listarGastos: MutableList<Gasto>
){
    val gasto = listarGastos[position].gasto
    val descricao = listarGastos[position].descricao
    val tipode = listarGastos[position].tipoDeCompra

    Card (
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (txtGasto,txtDescricao,descri, pag,tipo,btDelete) = createRefs()
            Text(text ="R$ "+"$gasto", fontSize = 18.sp, fontWeight = FontWeight.Bold , modifier = Modifier.constrainAs(txtGasto){
                top.linkTo(parent.top)
                start.linkTo(parent.start,margin = 10.dp)
                bottom.linkTo(descri.top, margin = 10.dp)
                })
            Text(text = "Descrição:",fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(txtDescricao){
                top.linkTo(txtGasto.bottom,margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
                bottom.linkTo(descri.top,margin = 10.dp)

            })
            Text(text = descricao.toString(), fontSize = 12.sp , modifier = Modifier.constrainAs(descri){

                start.linkTo(parent.start,margin = 10.dp)
               top.linkTo(txtDescricao.bottom,margin = 10.dp)
                bottom.linkTo(pag.top,margin = 10.dp)
            })
            Text(text = "Forma de Pagamento:",fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(pag) {
                top.linkTo(descri.bottom, margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)

            })

            Text(text = tipode.toString(),fontSize = 12.sp , modifier = Modifier.constrainAs(tipo){
                top.linkTo(pag.bottom, margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
                bottom.linkTo(parent.bottom, margin = 10.dp)
            })
            IconButton(onClick = {},modifier = Modifier.constrainAs(btDelete){
                top.linkTo(txtDescricao.bottom, margin = 10.dp)
                start.linkTo(parent.end,margin = 10.dp)
                end.linkTo(parent.end, margin = 10.dp)
                bottom.linkTo(parent.bottom,margin = 10.dp)

            }) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete), contentDescription = null)
            }

                }
         }
     }