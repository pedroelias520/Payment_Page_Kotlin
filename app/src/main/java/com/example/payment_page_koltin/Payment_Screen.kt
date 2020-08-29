package com.example.payment_page_koltin


import Models.MaskEditUtil
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.payment_page.*

class Payment_Screen : AppCompatActivity (),AdapterView.OnItemSelectedListener{

    private var spinner: Spinner? = null
    private var text_view: TextView? = null
    private var arrayAdapter: ArrayAdapter<String>? = null

    private var itemList = arrayOf("1","2","3","4","5","6","7","8","9","10","11","12")




    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.payment_page)


        cpf_editext.addTextChangedListener(MaskEditUtil.mask(cpf_editext, "###.###.###-##"));
        cartao_editext.addTextChangedListener(MaskEditUtil.mask(cartao_editext,"####-####-####-####"))

        nome_produto.text = nome_prod
        spinner = list_parcelas
        text_view = parcelas_text
        arrayAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_item,itemList)
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
        items.toInt()
        text_view?.text = "${items} x de ${valor_prod.toInt()/items.toInt()}"
    }


}