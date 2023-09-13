package com.example.conversoreurodolar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.conversoreurodolar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCriar.setOnClickListener{
           val criarEvento = Intent(this, TelaDeTarefas::class.java)
            startActivity(criarEvento)
        }

        }

    }


