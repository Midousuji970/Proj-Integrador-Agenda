package com.example.portfolioandroid.telatarefas

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.portfolioandroid.R
import com.example.portfolioandroid.constantes.Constantes
import com.example.portfolioandroid.repositorio.Botao
import com.example.portfolioandroid.repositorio.CaixaDeTexto
import com.example.portfolioandroid.repositorio.azulClaro
import com.example.portfolioandroid.repositorio.tarefasRepositorio
import com.example.portfolioandroid.ui.btnAmareloDisable
import com.example.portfolioandroid.ui.btnAmareloEnable
import com.example.portfolioandroid.ui.btnVerdeDisable
import com.example.portfolioandroid.ui.btnVerdeEnable
import com.example.portfolioandroid.ui.btnVermelhoDisable
import com.example.portfolioandroid.ui.btnVermelhoEnable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SalvarTarefa(
    navController: NavController


) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val repositorio = tarefasRepositorio()

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = azulClaro,
                title = {
                    IconButton(onClick ={
                        navController.previousBackStackEntry?.savedStateHandle
                        navController.popBackStack()
                    }, modifier = Modifier.padding(start = 1.dp) ) {
                        Image(imageVector = ImageVector.vectorResource(id = R.drawable.seta_back), contentDescription = null)

                    }
                    Text(

                        text = "SALVAR TAREFA",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                })
        },
        backgroundColor = Color.White
    ) {
        var nomeTarefa by remember {

            mutableStateOf("")
        }
        var iniTarefa by remember {
            mutableStateOf("")
        }
        var fimTarefa by remember {
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
                value = nomeTarefa,
                onValueChange = {
                    nomeTarefa = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Titulo Tarefa",
                maxLines = 1,
                keyBoardType = KeyboardType.Text
            )

            CaixaDeTexto(
                value = iniTarefa,
                onValueChange = {
                    if (it.length < maxNum) {
                        iniTarefa = it
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Data de Inicio",
                maxLines = 1,
                keyBoardType = KeyboardType.Text
            )
            CaixaDeTexto(
                value = fimTarefa,
                onValueChange = {
                    if (it.length < maxNum) {
                        fimTarefa = it
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Data de Término",
                maxLines = 1,
                keyBoardType = KeyboardType.Text
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
            Botao(onClick =
            {
                var mensagem = true
            scope.launch(Dispatchers.IO){
                if(nomeTarefa.isEmpty()){
                    mensagem = false
                }else if(nomeTarefa.isNotEmpty() && iniTarefa.isNotEmpty() && fimTarefa.isNotEmpty() && baixaPrioridade && lazerTipo){
                repositorio.salvarTarefa(nomeTarefa,iniTarefa,fimTarefa,Constantes.BAIXA_PRIORIDADE, Constantes.LAZER_TIPO )
                    mensagem = true
                }
                else if(nomeTarefa.isNotEmpty() && iniTarefa.isNotEmpty() && fimTarefa.isNotEmpty() && baixaPrioridade && trabalhoTipo){
                    repositorio.salvarTarefa(nomeTarefa,iniTarefa,fimTarefa,Constantes.BAIXA_PRIORIDADE, Constantes.TRABALHO_TIPO )
                    mensagem = true
                }
                else if(nomeTarefa.isNotEmpty() && iniTarefa.isNotEmpty() && fimTarefa.isNotEmpty() && baixaPrioridade && saudeTipo){
                    repositorio.salvarTarefa(nomeTarefa,iniTarefa,fimTarefa,Constantes.BAIXA_PRIORIDADE, Constantes.SAUDE_TIPO )
                    mensagem = true
                }
                else if(nomeTarefa.isNotEmpty() && iniTarefa.isNotEmpty() && fimTarefa.isNotEmpty() && mediaPrioridade && lazerTipo){
                    repositorio.salvarTarefa(nomeTarefa,iniTarefa,fimTarefa,Constantes.MEDIA_PRIORIDADE, Constantes.LAZER_TIPO )
                    mensagem = true
                }
                else if(nomeTarefa.isNotEmpty() && iniTarefa.isNotEmpty() && fimTarefa.isNotEmpty() && mediaPrioridade && trabalhoTipo){
                    repositorio.salvarTarefa(nomeTarefa,iniTarefa,fimTarefa,Constantes.MEDIA_PRIORIDADE, Constantes.TRABALHO_TIPO )
                    mensagem = true
                }
                else if(nomeTarefa.isNotEmpty() && iniTarefa.isNotEmpty() && fimTarefa.isNotEmpty() && mediaPrioridade && saudeTipo){
                    repositorio.salvarTarefa(nomeTarefa,iniTarefa,fimTarefa,Constantes.MEDIA_PRIORIDADE, Constantes.SAUDE_TIPO )
                    mensagem = true
                }
                else if(nomeTarefa.isNotEmpty() && iniTarefa.isNotEmpty() && fimTarefa.isNotEmpty() && altaPrioridade && lazerTipo){
                    repositorio.salvarTarefa(nomeTarefa,iniTarefa,fimTarefa,Constantes.ALTA_PRIORIDADE, Constantes.LAZER_TIPO )
                    mensagem = true
                }
                else if(nomeTarefa.isNotEmpty() && iniTarefa.isNotEmpty() && fimTarefa.isNotEmpty() && altaPrioridade && trabalhoTipo){
                    repositorio.salvarTarefa(nomeTarefa,iniTarefa,fimTarefa,Constantes.ALTA_PRIORIDADE, Constantes.TRABALHO_TIPO )
                    mensagem = true
                }
                else if(nomeTarefa.isNotEmpty() && iniTarefa.isNotEmpty() && fimTarefa.isNotEmpty() && altaPrioridade && saudeTipo){
                    repositorio.salvarTarefa(nomeTarefa,iniTarefa,fimTarefa,Constantes.ALTA_PRIORIDADE, Constantes.SAUDE_TIPO )
                    mensagem = true
                }


            }
                scope.launch ( Dispatchers.Main ){
                        if(mensagem){
                            Toast.makeText(context,"Sucesso ao salvar a tarefa",Toast.LENGTH_SHORT).show()
                            navController.popBackStack()
                        }else{
                            Toast.makeText(context,"Falha ao Salvar a tarefa",Toast.LENGTH_SHORT).show()
                        }
                }
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(20.dp),
                texto = "SALVAR")
        }

    }
}




