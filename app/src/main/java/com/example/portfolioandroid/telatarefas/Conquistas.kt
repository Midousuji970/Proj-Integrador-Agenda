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
import com.example.portfolioandroid.itemLista.ConquistaItem
import com.example.portfolioandroid.model.Conquistas
import com.example.portfolioandroid.repositorio.BackGrounde

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun ConquistaTarefa(
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
            title = { Text(text = "Conquistas",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)})
    },
        bottomBar = { BottomBar(navController = navController, items = items)

        },
        backgroundColor = BackGrounde

    )

    {
        val listarConquistas: MutableList<Conquistas> = mutableListOf(
            Conquistas(
                nomeCon = " Marombeiro",
                desCon = "Fez 5 idas a Academia em uma Semana!",
                tipoCon = 2,
                feitaCon = 6,
                totalCon = 5
            ),
            Conquistas(
                nomeCon = "Cineasta",
                desCon = "Assistiu 10 filmes em uma Semana!",
                tipoCon = 0,
                feitaCon = 10,
                totalCon = 10
            ),
            Conquistas(
                nomeCon = "Programador Senior",
                desCon = "Entregou 5 querys grandes na Semana!",
                tipoCon = 1,
                feitaCon = 5,
                totalCon = 5
            ),
        )
        LazyColumn(){
            itemsIndexed(listarConquistas){position, _ ->
                ConquistaItem(position,listarConquistas)
            }
        }
}}
