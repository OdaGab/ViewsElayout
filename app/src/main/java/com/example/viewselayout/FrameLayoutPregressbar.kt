package com.example.viewselayout

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FrameLayoutPregressbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_frame_layout_pregressbar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.frameLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Encontrar as views
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val textProcessando = findViewById<TextView>(R.id.text_processando)
        val textSucesso = findViewById<TextView>(R.id.text_sucesso)
        val btnNextToTable = findViewById<Button>(R.id.btnNextToTable)

        // Agendar a troca de visibilidade após 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            // Esconder os componentes de processamento
            progressBar.visibility = View.GONE
            textProcessando.visibility = View.GONE

            // Mostrar a mensagem de sucesso e o botão
            textSucesso.visibility = View.VISIBLE
            btnNextToTable.visibility = View.VISIBLE
        }, 3000) // 3000 milissegundos = 3 segundos

        // Adicionar a navegação ao botão
        btnNextToTable.setOnClickListener {
            val intent = Intent(this, exemplo_table_layout::class.java)
            startActivity(intent)
        }
    }
}