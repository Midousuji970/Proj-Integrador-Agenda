package com.example.portfolioandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.portfolioandroid.databinding.ActivityTelaDeTarefasBinding

class TelaDeTarefas : AppCompatActivity() {
    private lateinit var binding: ActivityTelaDeTarefasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaDeTarefasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSalvar.setOnClickListener{
            val nome = binding.txtNomeTarefa.text.toString()
            val inicio = binding.txtInicioTarefa.text.toString()
            val fim = binding.txtTerminoTarefa.text.toString()
            val txtprioridade = binding.txtPrio.text.toString()
            val txttipo = binding.txtTipo.text.toString()
            val prioridade = txtprioridade.toInt()
            val tipo = txttipo.toInt()


        }
    }
}