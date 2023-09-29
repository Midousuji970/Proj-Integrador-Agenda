package com.example.portfolioandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portfolioandroid.telatarefas.ConquistaTarefa
import com.example.portfolioandroid.telatarefas.ListaDeTarefas
import com.example.portfolioandroid.telatarefas.MetasTarefa
import com.example.portfolioandroid.telatarefas.SalvarTarefa
import com.example.portfolioandroid.telatarefas.UsuarioTarefa
import com.example.portfolioandroid.telatarefas.gastoTarefas
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "ListaDeTarefas") {
                    composable(
                        route = "ListaDeTarefas"
                    )
                    {
                        ListaDeTarefas(navController)
                    }
                    composable(
                        route = "SalvarTarefa"
                    )
                    {
                        SalvarTarefa(navController)
                    }
                    composable(
                        route = "Metas"
                    ) {
                        MetasTarefa(navController)
                    }
                    composable(
                        route = "Gasto"
                    ) {
                        gastoTarefas(navController)
                    }
                    composable(
                        route = "Conquista"
                    ) {
                        ConquistaTarefa(navController)
                    }
                    composable(
                        route = "Usuario"
                    ) {
                        UsuarioTarefa(navController)
                    }


                }

        }

        }

    }



