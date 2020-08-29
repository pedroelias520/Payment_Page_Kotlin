package com.example.payment_page_koltin

import Models.Produto
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.ColorSpace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import com.example.payment_page_koltin.Product_select_page as Product_select_page1

class MyAdapter(var mCtx:Context,var resources:Int,var items:List<Produto>,var screen:Int):ArrayAdapter<Produto>(mCtx,resources,items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mCtx)
        val view:View = layoutInflater.inflate(resources,null)
        val screen:View = layoutInflater.inflate(screen,null)

        val NomeView:TextView = view.findViewById(R.id.text_nome_row)
        val HoraView:TextView = view.findViewById(R.id.text_valor_row)
        val DescricaoView:TextView = view.findViewById(R.id.text_tipo_row)
        val ComprarButton:Button = view.findViewById(R.id.ComprarButton)
        val ItensNum:TextView = screen.findViewById(R.id.itens_num)
        val mItem:Produto = items[position]
        NomeView.text = mItem.nome
        HoraView.text = mItem.valor
        DescricaoView.text = mItem.tipo

        ComprarButton.setOnClickListener {
            nome_prod = mItem.nome
            valor_prod = mItem.valor
            tipo_prod = mItem.tipo
            compras.add(Produto(nome_prod, valor_prod, tipo_prod))
            compras_sum = compras_sum + valor_prod.toDouble()
            compras_num = compras_num + 1
            ItensNum.text = compras_num.toString()
            ComprarButton.text ="Adicionado!"
            ComprarButton.setTextColor(Color.GREEN)
        }

        return view
    }

}
//Lista responsável por receber os itens escritos
var compras_sum: Double = 0.0
var compras_num:Int = 0
var list = mutableListOf<Produto>()
var compras = mutableListOf<Produto>()
var nome_prod:String = ""
var valor_prod:String = ""
var tipo_prod:String = ""
var user_name:String = ""
