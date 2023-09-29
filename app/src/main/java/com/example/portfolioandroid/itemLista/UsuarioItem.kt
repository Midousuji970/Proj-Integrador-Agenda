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
import com.example.portfolioandroid.model.Usuarios

@Composable
fun UsuarioItem(
    position: Int,
    listarUsuario: MutableList<Usuarios>
){
    val icone = listarUsuario[position].icone
    val nomeUsu = listarUsuario[position].nomeUsu
    val perfil = listarUsuario[position].perfil
    Card (
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (nomeUsus,foto,descri, perfils, btMuda) = createRefs()
            IconButton(onClick = {},modifier = Modifier.constrainAs(btMuda){
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
                end.linkTo(parent.end, margin = 10.dp)
            }) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.menino_4), contentDescription = null
                    )
            }
            Text(text = "Usuario: "+"$nomeUsu",fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(nomeUsus){
                top.linkTo(btMuda.bottom,margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
                bottom.linkTo(descri.top,margin = 10.dp)

            })
            Text(text = "Sobre Mim:",fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(descri){
                top.linkTo(nomeUsus.bottom,margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
                bottom.linkTo(perfils.top,margin = 10.dp)

            })
            Text(text = perfil.toString(),fontSize = 16.sp, modifier = Modifier.constrainAs(perfils){
                top.linkTo(descri.bottom,margin = 10.dp)
                start.linkTo(parent.start,margin = 10.dp)
                bottom.linkTo(parent.bottom,margin = 10.dp)
            })


        }
    }

}