package com.example.portfolioandroid.telatarefas

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.portfolioandroid.R
import com.example.portfolioandroid.itemLista.MetaItem
import com.example.portfolioandroid.model.Metas
import com.example.portfolioandroid.repositorio.BackGrounde

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun MetasTarefa(
    navController: NavController
)
{
    val imagem: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_home)
    val imagem2: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_estatistica)
    val imagem3: ImageVector = ImageVector.vectorResource(id = R.drawable.flag)
    val imagem4: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_gasto)
    val imagem5: ImageVector = ImageVector.vectorResource(id = R.drawable.ic_usuario)
    val items = listOf(
        BottomBarItem("ListaDeTarefas",imagem) , // Substitua "Screen1" e Icons.Default.Screen1 pelos seus destinos e ícones reais
        BottomBarItem("Metas", imagem2 ),
        BottomBarItem("Conquista",imagem3),
        BottomBarItem("Gasto",imagem4),
        BottomBarItem("Usuario",imagem5)
    )
    Scaffold(topBar = {
        TopAppBar(backgroundColor = BackGrounde,
            title = { Text(text = "Metas",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)})
    },
        bottomBar = { BottomBar(navController = navController, items = items)
    },
        backgroundColor = BackGrounde
    )

    {
        val listarMetas: MutableList<Metas> = mutableListOf(
            Metas(
                metas = "Metas Concluidas",
                descricaoMetas= "Metas Concluidas no Mês de Setembro",
                concluidas = 15,
             naoConcluidas = 10
            )
        ,
        Metas(
            metas = "Metas Concluidas",
            descricaoMetas= "Metas Concluidas no Mês de Agosto",
            concluidas = 20,
            naoConcluidas = 54
        ),
        Metas(
            metas = "Metas Concluidas",
            descricaoMetas= "Metas Concluidas no Mês de Julho",
            concluidas = 15,
            naoConcluidas = 10
        )

        )
        LazyColumn(){
            itemsIndexed(listarMetas){position, _ ->
                MetaItem(position,listarMetas)
            }
        }
    }
}



