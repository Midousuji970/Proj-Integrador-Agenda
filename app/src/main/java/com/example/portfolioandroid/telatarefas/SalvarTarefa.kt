package com.example.portfolioandroid.telatarefas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.portfolioandroid.repositorio.BackGrounde
import com.example.portfolioandroid.repositorio.Botao
import com.example.portfolioandroid.repositorio.CaixaDeTexto
import com.example.portfolioandroid.ui.btnAmareloDisable
import com.example.portfolioandroid.ui.btnAmareloEnable
import com.example.portfolioandroid.ui.btnVerdeDisable
import com.example.portfolioandroid.ui.btnVerdeEnable
import com.example.portfolioandroid.ui.btnVermelhoDisable
import com.example.portfolioandroid.ui.btnVermelhoEnable
import com.example.portfolioandroid.ui.cinza

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SalvarTarefa(
    navController: NavController
) {


    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = BackGrounde,
                title = {
                    Text(
                        text = "SALVAR TAREFA",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                })
        },
        backgroundColor = cinza
    ) {
        var tituloTarefa by remember {

            mutableStateOf("")
        }
        var dataIniTarefa by remember {
            mutableStateOf("")
        }
        var dataFimTarefa by remember {
            mutableStateOf("")
        }

        var baixaPrioridade by remember {
            mutableStateOf(false)
        }
        var mediaPrioridade by remember {
            mutableStateOf(false)
        }
        var altaPrioridade by remember {
            mutableStateOf(false)
        }
        var lazerTipo by remember {
            mutableStateOf(false)
        }
        var trabalhoTipo by remember {
            mutableStateOf(false)
        }
        var saudeTipo by remember {
            mutableStateOf(false)
        }

        val maxNum = 11


        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CaixaDeTexto(
                value = tituloTarefa,
                onValueChange = {
                    tituloTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Titulo Tarefa",
                maxLines = 1,
                keyBoardType = KeyboardType.Text
            )

            CaixaDeTexto(
                value = dataIniTarefa,
                onValueChange = {
                    if (it.length < maxNum) {
                        dataIniTarefa = it
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Data de Inicio",
                maxLines = 1,
                keyBoardType = KeyboardType.Number
            )
            CaixaDeTexto(
                value = dataFimTarefa,
                onValueChange = {
                    if (it.length < maxNum) {
                        dataFimTarefa = it
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Data de Término",
                maxLines = 1,
                keyBoardType = KeyboardType.Number
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp, 0.dp, 0.dp)
            ) {
                Text(text = "Nivel de Prioridade: ",
                    fontSize = 18.sp, fontWeight = FontWeight.Bold)

            }
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()) {

                RadioButton(
                    selected = baixaPrioridade,
                    onClick = { baixaPrioridade = !baixaPrioridade },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = btnVerdeDisable,
                        selectedColor = btnVerdeEnable
                    )
                )
                Text(text = "Baixa",fontSize = 14.sp)

                RadioButton(
                    selected = mediaPrioridade,
                    onClick = { mediaPrioridade = !mediaPrioridade },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = btnAmareloDisable,
                        selectedColor = btnAmareloEnable
                    )
                )
                Text(text = "Media",fontSize = 14.sp)
                RadioButton(
                    selected = altaPrioridade,
                    onClick = { altaPrioridade = !altaPrioridade },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = btnVermelhoDisable,
                        selectedColor = btnVermelhoEnable
                    )
                )
                Text(text = "Alta",fontSize = 14.sp)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Text(text = "Tipo de Tarefa: ",fontSize = 18.sp, fontWeight = FontWeight.Bold)

            }
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()){

                RadioButton(
                    selected = lazerTipo,
                    onClick = { lazerTipo = !lazerTipo },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = btnVerdeDisable,
                        selectedColor = btnVerdeEnable
                    )
                )
                Text(text = "Lazer",fontSize = 14.sp)

                RadioButton(
                    selected = trabalhoTipo,
                    onClick = { trabalhoTipo = !trabalhoTipo },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = btnAmareloDisable,
                        selectedColor = btnAmareloEnable
                    )
                )
                Text(text = "Trabalho",fontSize = 14.sp)
                RadioButton(
                    selected = saudeTipo,
                    onClick = { saudeTipo = !saudeTipo },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = btnVermelhoDisable,
                        selectedColor = btnVermelhoEnable
                    )
                )
                Text(text = "Saude",fontSize = 14.sp)
            }
            Botao(onClick = { },
                modifier = Modifier.fillMaxWidth().height(80.dp).padding(20.dp),
                texto = "SALVAR")
        }

    }
}



