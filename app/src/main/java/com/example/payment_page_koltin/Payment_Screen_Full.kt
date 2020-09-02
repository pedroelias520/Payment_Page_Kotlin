package com.example.payment_page_koltin

import Models.MaskEditUtil
import Models.Produto
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.payment_page.*
import java.util.*

class Payment_Screen_Full : AppCompatActivity(), AdapterView.OnItemSelectedListener {


    private var spinner: Spinner? = null
    private var text_view: TextView? = null
    private var arrayAdapter: ArrayAdapter<String>? = null

    var nome_cartao:String = ""
    var cartao_numero:String = ""
    var validade_mes: Int = 0
    var validade_ano: Int = 0
    var codigo: Int = 0
    var valor_total:Double = 0.00
    var num_parcelas:Int = 0

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
        mes_validade.addTextChangedListener(MaskEditUtil.mask(mes_validade,"##"))
        ano_validade.addTextChangedListener(MaskEditUtil.mask(ano_validade,"##"))
        var lista_comprados = findViewById<ListView>(R.id.lista_produtos_comprados)
        var adapter = ArrayAdapter <Produto>(this,android.R.layout.simple_list_item_1, compras)
        lista_comprados.adapter = adapter

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

        end_button.setOnClickListener{
            nome_cartao = nome_cartao_editext.text.toString()
            cartao_numero = cartao_editext.text.toString()
            validade_mes= mes_validade.text.toString().toInt()
            validade_ano= ano_validade.text.toString().toInt()
            codigo = cvv_editext.text.toString().toInt()

            print(nome_cartao)
            print(cartao_numero)
            print(validade_mes)
            print(validade_ano)
            print(codigo)
            print(valor_total)
            print(num_parcelas)
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
            valor_total = compras_sum.toDouble()/items.toDouble()
            num_parcelas = items.toInt()
            text_view?.text = "${items} x de ${compras_sum.toFloat()/items.toFloat()}"
        }


    }
}

