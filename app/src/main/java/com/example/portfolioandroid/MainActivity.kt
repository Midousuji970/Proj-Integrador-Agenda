package com.example.portfolioandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portfolioandroid.telatarefas.ListaDeTarefas

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "ListaDeTarefas" ){
                composable(
                    route = "ListaDeTarefas"
                )
                {
                    ListaDeTarefas(navController)
                }
            }
        }

        }

    }



