package com.example.payment_page_koltin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.payment_page.*
import kotlinx.android.synthetic.main.product_select_page.*
import kotlinx.android.synthetic.main.row.*

 class Product_select_page : AppCompatActivity(){


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
        setContentView(R.layout.product_select_page)
        hideSystemUI()
        nome_usuario.text = user_name
        var listview = list_itens
        listview.adapter = MyAdapter(this,R.layout.row, list,R.layout.product_select_page)

        val finalizar:Button = findViewById(R.id.finalizar_button)
        finalizar.setOnClickListener(){
            if(compras.isEmpty()){
                Toast.makeText(applicationContext, "Nada selecionado", Toast.LENGTH_LONG).show()
            }else{
                intent = Intent(this,Payment_Screen_Full::class.java)
                startActivity(intent)
            }


        }



    }




}
