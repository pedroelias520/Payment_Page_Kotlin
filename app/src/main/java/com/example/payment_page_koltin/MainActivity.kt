package com.example.payment_page_koltin

import Models.Produto
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.button



class MainActivity : AppCompatActivity(){


    private fun hideSystemUI() {
        // Ativa o modo imersivo de tela
        // Para o modo "recuar", remova SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Esconde barra de status e barra de navegação
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN

                )
    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        print("Login in system")
        list.add(Produto("Tomate","6.99","Alimentos"))
        list.add(Produto("Regrigerante","3.50","Bebidas"))
        list.add(Produto("Alcool em gel","12.30","Higiena"))
        list.add(Produto("Luvas","4.50","Limpeza"))
        list.add(Produto("Frago","8.50","Frios"))



            button_login.setOnClickListener{
                    user_name = "admin"
                    print(user_name)
                    intent = Intent(this, Product_select_page::class.java)
                    startActivity(intent)

            }





    }

}
