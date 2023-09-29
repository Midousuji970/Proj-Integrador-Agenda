package com.example.portfolioandroid.telatarefas

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.portfolioandroid.R
import com.example.portfolioandroid.itemLista.TarefaItem
import com.example.portfolioandroid.repositorio.BackGrounde
import com.example.portfolioandroid.repositorio.tarefasRepositorio

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun ListaDeTarefas(
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
    val repositorio = tarefasRepositorio()
    val context = LocalContext.current

    Scaffold(
        topBar = {

        TopAppBar(backgroundColor = BackGrounde,
            title = { Text(text = "Lista de Tarefas",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White)})
    },
        bottomBar = { BottomBar(navController = navController, items = items)

        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(route = "SalvarTarefa")
            },backgroundColor = BackGrounde
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.redondo),
                    contentDescription = "Botao de Salvar"
                )
            }
        },
        backgroundColor = BackGrounde


    )

    {
    val listaTarefas = repositorio.recuperarTarefas().collectAsState(mutableListOf()).value
        LazyColumn(){
            itemsIndexed(listaTarefas){
                position, _, ->
                TarefaItem(position = position, listaTarefas = listaTarefas, context = context, navController = navController)
            }
            }
        }
    }

@Composable
fun BottomBar(
    navController: NavController,
    items: List<BottomBarItem>
) {
    val currentRoute by navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute?.destination?.route == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null

                    )


                }
            )
        }
    }
}
data class BottomBarItem(val route: String, val icon: ImageVector)
