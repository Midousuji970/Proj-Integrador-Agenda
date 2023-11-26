package com.example.portfolioandroid.telatarefas

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.example.portfolioandroid.repositorio.Botao
import com.example.portfolioandroid.repositorio.CaixaDeTexto
import com.example.portfolioandroid.repositorio.UsuarioRepositorio
import com.example.portfolioandroid.repositorio.azulClaro
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SalvarUsuario(
    navController: NavController
) {
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val repositorio = UsuarioRepositorio()

    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = azulClaro,
                title = {
                    IconButton(onClick = {
                        navController.previousBackStackEntry?.savedStateHandle
                        navController.popBackStack()
                    }, modifier = Modifier.padding(start = 1.dp)) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.seta_back),
                            contentDescription = null
                        )

                    }
                    Text(

                        text = "IDENTIFICAR USUARIO ",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                })
        },
        backgroundColor = Color.White
    ) {
        var nomeUsu by remember {

            mutableStateOf("")
        }
        var perfil by remember {
            mutableStateOf("")
        }

        val maxNum = 11

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            CaixaDeTexto(
                value = nomeUsu,
                onValueChange = {
                    nomeUsu = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Nome do Usuario",
                maxLines = 1,
                keyBoardType = KeyboardType.Number
            )

            CaixaDeTexto(
                value = perfil,
                onValueChange = {
                    if (it.length < maxNum) {
                        perfil = it
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Descrição do Usuario",
                maxLines = 2,
                keyBoardType = KeyboardType.Text
            )

            Botao(
                onClick =
                {
                    var mensagem = true
                    scope.launch(Dispatchers.IO) {
                        if (nomeUsu.isEmpty()) {
                            mensagem = false
                        } else if (nomeUsu.isNotEmpty() && perfil.isNotEmpty()) {
                            repositorio.salvarUsuario(nomeUsu, perfil)

                            mensagem = true

                        }
                    }
                    scope.launch(Dispatchers.Main) {
                        if (mensagem) {
                            Toast.makeText(
                                context,
                                "Sucesso ao Cadastrar Usuario",
                                Toast.LENGTH_SHORT
                            ).show()
                            navController.popBackStack()
                        } else {
                            Toast.makeText(context, "Falha ao Cadastrar Usuario", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(20.dp),
                texto = "SALVAR"
            )
        }

    }
}




