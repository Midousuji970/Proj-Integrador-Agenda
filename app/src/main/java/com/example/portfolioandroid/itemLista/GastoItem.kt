package com.example.portfolioandroid.itemLista

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.portfolioandroid.R
import com.example.portfolioandroid.model.Gasto
import com.example.portfolioandroid.repositorio.BackGrounde
import com.example.portfolioandroid.repositorio.GastoRepositorio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun GastoItem(
    position: Int,
    listaGastos: MutableList<Gasto>,
    contexts: Context,
    navController: NavController
){
    val gasto = listaGastos[position].nomeGasto
    val descriG = listaGastos[position].descriGasto
    val tipode = listaGastos[position].tipoGasto

    val scopes = rememberCoroutineScope()
    val gastoRepositorio = GastoRepositorio()
    fun dialogsDeletar(){
        val alertDialog = AlertDialog.Builder(contexts)
        alertDialog.setTitle("Deletar o Gasto")
            .setMessage("Deseja Excluir o Gasto?")
            .setPositiveButton("Sim"){
                    _, _ ->

                gastoRepositorio.DeletarGasto( gasto.toString())
                scopes.launch ( Dispatchers.Main ){
                    listaGastos.removeAt(position)
                    navController.navigate("Gasto")
                    Toast.makeText(contexts,"Sucesso ao Deletar o Gasto", Toast.LENGTH_SHORT).show()
                }
            }
            .setNegativeButton("Não"){_,_ ->}
            .show()

    }

    Card (
        border = BorderStroke(2.dp, BackGrounde)
        , backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ){
        ConstraintLayout(
            modifier = Modifier.padding(10.dp)
        ) {
            val (txtGasto,txtDescricao,descri, pag,tipo,btDelete) = createRefs()
            Text(text ="Custo: R$ $gasto", fontSize = 16.sp, fontWeight = FontWeight.Bold , modifier = Modifier.constrainAs(txtGasto){
                start.linkTo(parent.start,margin = 10.dp)
                bottom.linkTo(descri.top, margin = 10.dp)
                })
            Text(text = "Descrição:",fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(txtDescricao){
                top.linkTo(txtGasto.bottom, margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
                bottom.linkTo(parent.bottom,margin = 10.dp)

            })
            Text(text = descriG.toString(), fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(descri){

                start.linkTo(txtDescricao.end, margin = 10.dp)
                top.linkTo(txtDescricao.top)
                bottom.linkTo(txtDescricao.bottom)
            })
            Text(text = "Forma de Pagamento:",fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(pag) {
                top.linkTo(txtGasto.top)
                start.linkTo(txtGasto.end,margin = 10.dp)
                bottom.linkTo(txtGasto.bottom)

            })

            Text(text = tipode.toString(),fontSize = 16.sp, fontWeight = FontWeight.Bold , modifier = Modifier.constrainAs(tipo){
                start.linkTo(pag.end, margin = 10.dp)
                top.linkTo(pag.top)
                bottom.linkTo(pag.bottom)
            })
            IconButton(onClick = {dialogsDeletar()},modifier = Modifier.constrainAs(btDelete){
                top.linkTo(descri.top)
                end.linkTo(parent.end, margin = 20.dp)
                bottom.linkTo(parent.bottom,margin = 10.dp)

            }) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete), contentDescription = null)
            }

                }
         }
     }