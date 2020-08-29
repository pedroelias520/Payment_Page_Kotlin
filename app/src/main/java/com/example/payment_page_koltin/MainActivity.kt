package com.example.payment_page_koltin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.payment_page.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {


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

    private var spinner:Spinner ? = null
    private var text_view:TextView ? = null
    private var arrayAdapter:ArrayAdapter<String> ? = null

    private var itemList = arrayOf("1","2","3","4","5","6","7","8","9","10","11","12")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_page)


        spinner = list_parcelas
        text_view = parcelas_text
        arrayAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,itemList)
        spinner?.adapter = arrayAdapter
        spinner?.onItemSelectedListener = this

        editText4.setOnClickListener {
            nome_produto.text = editText4.text
            if (nome_produto.text != null) {
                editText4.setTextColor(resources.getColor(R.color.abc_search_url_text))
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(applicationContext, "Nada selecionado", Toast.LENGTH_LONG).show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var items:String = p0?.getItemAtPosition(p2) as String
        text_view?.text = "${items} x"
    }
}
