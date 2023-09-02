package com.example.conversoreurodolar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversoreurodolar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogar.setOnClickListener{

            startActivity(Intent(this, TelaDeTarefas::class.java))
        }
        binding.icLike.setOnClickListener{
            Toast.makeText(this, "Like", Toast.LENGTH_SHORT).show()
        }
        binding.icShare.setOnClickListener{
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show()
        }
        }

    }


