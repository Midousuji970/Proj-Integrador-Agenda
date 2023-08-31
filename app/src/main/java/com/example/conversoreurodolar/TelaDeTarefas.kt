package com.example.conversoreurodolar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversoreurodolar.databinding.ActivityTelaDeTarefasBinding

class TelaDeTarefas : AppCompatActivity() {
    private lateinit var binding: ActivityTelaDeTarefasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaDeTarefasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVol.setOnClickListener{
            finish()
        }
    }
}