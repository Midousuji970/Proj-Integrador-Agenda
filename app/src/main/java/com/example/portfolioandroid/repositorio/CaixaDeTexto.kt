package com.example.portfolioandroid.repositorio

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.portfolioandroid.ui.ShapeEditText

@Composable
fun CaixaDeTexto(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyBoardType: KeyboardType
){

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier,
        label = { Text(text = label)
        },
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            focusedBorderColor = azulClaro,
            focusedLabelColor = azulClaro,
            backgroundColor = Color.White,
            cursorColor = azulClaro
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType)
        )
}

@Composable
fun CaixaDeData(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    maxLines: Int,
    keyBoardType: KeyboardType
){

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier,
        label = { Text(text = label)
        },
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Black,
            focusedBorderColor = azulClaro,
            focusedLabelColor = azulClaro,
            backgroundColor = Color.White,
            cursorColor = azulClaro
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType)
    )

}
@Composable
@Preview
private fun CaixaDeTextoPrev(){
    CaixaDeTexto(value = "Murilo",
        onValueChange = {},
        modifier = Modifier.fillMaxWidth(),
        label = "Descricao",
        maxLines = 1,
        keyBoardType = KeyboardType.Text
        )
}