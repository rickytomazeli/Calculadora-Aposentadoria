package com.example.aposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aposentadoria.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        // Dados para o Spinner
        val items = listOf<String>("Masculino", "Feminino")

        // COnfiguração do Adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Associa o adapter ao Spinner
        binding.spinner.adapter = adapter






        binding.button.setOnClickListener{
            val genero = binding.spinner.selectedItem.toString()
            calcular(genero)
        }

    }

    fun calcular(genero: String){
        val idadeTexto = binding.textInputEditText.text.toString()

        if (idadeTexto.isEmpty()){
            binding.textView.text = "Informe uma idade!"
        } else{
            if (genero == "Masculino"){
                if (idadeTexto.toInt() < 65){
                    binding.textView.text = "Faltam ${65 - idadeTexto.toInt()} anos para você se aposentar!"
                } else {
                    binding.textView.text = "Você já deveria estar aposentado!"
                }
            } else {
                if (idadeTexto.toInt() < 62){
                    binding.textView.text = "Faltam ${62 - idadeTexto.toInt()} anos para você se aposentar!"
                } else {
                    binding.textView.text = "Você já deveria estar aposentada!"
            }
        }


    }
}
}