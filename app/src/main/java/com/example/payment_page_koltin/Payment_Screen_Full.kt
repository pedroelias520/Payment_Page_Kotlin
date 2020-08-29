package com.example.payment_page_koltin

import Models.MaskEditUtil
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.payment_page.*
import kotlinx.android.synthetic.main.product_select_page.*

class Payment_Screen_Full : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    private var spinner: Spinner? = null
    private var text_view: TextView? = null
    private var arrayAdapter: ArrayAdapter<String>? = null

    private var itemList = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")
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
        setContentView(R.layout.payment_page)
        hideSystemUI()

        cpf_editext.addTextChangedListener(MaskEditUtil.mask(cpf_editext, "###.###.###-##"));
        cartao_editext.addTextChangedListener(MaskEditUtil.mask(cartao_editext, "####-####-####-####"))
        cvv_editext.addTextChangedListener(MaskEditUtil.mask(cvv_editext,"###"))
        nome_produto.text = nome_prod
        spinner = list_parcelas
        text_view = parcelas_text
        arrayAdapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, itemList)
        spinner?.adapter = arrayAdapter
        spinner?.onItemSelectedListener = this

        cpf_editext.setOnClickListener {
            nome_produto.text = cpf_editext.text
            if (nome_produto.text != null) {
                cpf_editext.setTextColor(resources.getColor(R.color.abc_search_url_text))
            }
        }


    }


    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(applicationContext, "Nada selecionado", Toast.LENGTH_LONG).show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        var items:String = p0?.getItemAtPosition(p2) as String
        val price: Float
        if(items.equals(null)){
            text_view?.text = "Pagamento a vista"
        }else{
            text_view?.text = "${items} x de ${compras_sum.toFloat()/items.toFloat()}"
        }


    }
}

