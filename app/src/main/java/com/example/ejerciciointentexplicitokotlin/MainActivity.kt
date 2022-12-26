package com.example.ejerciciointentexplicitokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciointentexplicitokotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Creamos el binding que nos sirve para la vinculacion de vista
    private lateinit var binding: ActivityMainBinding

    //Este metodo es el metodo que se llama para que comience el activity
    override fun onCreate(savedInstanceState: Bundle?) {
        //Estas lineas hace que se nos vincule las vistas con el activity
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Definimos un escuchador para cuando pulsemos el boton evaluar haga lo que se va a definir dentro
        binding.btEvaluar.setOnClickListener {
            //Creamos las siguientes variables inmutables que se obtienen a traves del binding
            val valor1 = binding.txtMatematicas.text.toString()
            val valor2 = binding.txtFisica.text.toString()
            val valor3 = binding.txtQuimica.text.toString()
            //Si las variables no estan vacias se hace lo siguiente y sino muestra un toast
            if (valor1.isNotEmpty() && valor2.isNotEmpty() && valor3.isNotEmpty()) {
                //Creamos la variable inmutable media que calcula la media de las notas
                val media = (valor1.toInt() + valor2.toInt() + valor3.toInt()) / 3
                //Creamos un Intent, objeto de mensajería, donde estamos diciendo que se vaya al SegundoActivity
                val intent = Intent(this, SegundoActivity::class.java)
                //Enviamos la información desde el MainActivity al SegundoActivity
                intent.putExtra("notaMat", valor1.toInt())
                intent.putExtra("notaFis", valor2.toInt())
                intent.putExtra("notaQui", valor3.toInt())
                intent.putExtra("media", media)
                //Realice el salto al SegundoActivity
                startActivity(intent)
            } else {
                Toast.makeText(this, "Debes introducir todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}