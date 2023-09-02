package com.example.conversoreurodolar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversoreurodolar.databinding.ActivityTelaDeTarefasBinding

class TelaDeTarefas : AppCompatActivity() {
    private lateinit var binding: ActivityTelaDeTarefasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaDeTarefasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icLike.setOnClickListener{
            Toast.makeText(this, "Like", Toast.LENGTH_SHORT).show()
        }
        binding.icShare.setOnClickListener{
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
        }
        binding.btnVol.setOnClickListener{
            finish()
        }
    }
}