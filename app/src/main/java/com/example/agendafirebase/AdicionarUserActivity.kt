package com.example.agendafirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AdicionarUserActivity : AppCompatActivity() {
    private lateinit var edNome: EditText
    private lateinit var edEmail: EditText
    private lateinit var edTelefone: EditText
    private lateinit var edEndereco: EditText
    private lateinit var edOccupation: EditText
    private lateinit var btnAdicionar : Button

    private lateinit var databaseReference: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_user)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        initView()

        btnAdicionar.setOnClickListener{
            addAgenda()
        }


    }
    private fun addAgenda() {
        val nome = edNome.text.toString()
        val email = edEmail.text.toString()
        val telefone = edTelefone.text.toString()
        val endereco = edEndereco.text.toString()
        val profissoes = edOccupation.text.toString()

        if (nome.isEmpty() || email.isEmpty() || telefone.isEmpty() || endereco.isEmpty() || profissoes.isEmpty()) {
            Toast.makeText(this, "Preencha os campos ", Toast.LENGTH_SHORT).show()
        } else {

            databaseReference =
                FirebaseDatabase.getInstance().getReference("Agenda")//Nome da tabela

            val servidores =
                AgendaActivity(name = nome, email = email, phone = telefone, location = endereco, occupation = profissoes)
            val status = databaseReference.child(nome).setValue(servidores).addOnSuccessListener {
                Toast.makeText(this, "Bloca de notas crianda com sucesso", Toast.LENGTH_SHORT).show()

            }
        }
    }
    private fun initView() {
        edNome = findViewById(R.id.edNome)
        edEmail = findViewById(R.id.edEmail)
        edTelefone = findViewById(R.id.edTelefone)
        edEndereco = findViewById(R.id.edEndereco)
        edOccupation = findViewById(R.id.edOccupation)
        btnAdicionar = findViewById(R.id.btnAdicionar)

    }

}

