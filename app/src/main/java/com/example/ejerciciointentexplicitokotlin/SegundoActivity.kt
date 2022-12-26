package com.example.ejerciciointentexplicitokotlin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciointentexplicitokotlin.databinding.ActivitySegundoBinding

class SegundoActivity : AppCompatActivity() {
    //Creamos el binding que nos sirve para la vinculacion de vista
    private lateinit var binding: ActivitySegundoBinding

    //Este metodo es el metodo que se llama para que comience el activity
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        //Estas lineas hace que se nos vincule las vistas con el activity
        super.onCreate(savedInstanceState)
        binding = ActivitySegundoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creamos una variable inmutable en el que recogemos los datos que hemos mandado anteriormente,
        //capturando el Intent con el método extras
        val datos = intent.extras
        //Creación de variables inmutables que guarda los datos anteriores con los métodos asociados
        //a cada tipo de dato, método getInt y pasándole el nombre que se le ha dado a cada dato,
        //donde la variable datos le indicamos que puede ser nula ?
        val mat = datos?.getInt("notaMat")
        val fis = datos?.getInt("notaFis")
        val qui = datos?.getInt("notaQui")
        val media = datos?.getInt("media")

        //Cada componente con el método Text() cambie el texto que sale por lo que yo le estoy indicando
        binding.txtMat.text = "Nota de Matemáticas $mat"
        binding.txtFis.text = "Nota de Física $fis"
        binding.txtQui.text = "Nota de Química $qui"

        //Si media es distinto de nulo, hace lo siguiente
        if (media != null) {
            //Si media es mayor o igual a 5, txtResultado muestre un texto y sino pues muestre otro texto
            if (media >= 5) {
                binding.txtResultado.text = "Aprobado con $media de media"
            } else {
                binding.txtResultado.text = "Suspenso con $media de media"
            }
        }
    }
}