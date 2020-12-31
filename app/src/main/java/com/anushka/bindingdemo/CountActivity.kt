package com.anushka.bindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.anushka.bindingdemo.databinding.ActivityCountBinding
import com.anushka.bindingdemo.viewModel.ViewModelCount
import com.anushka.bindingdemo.viewModel.ViewModelCountFactory

class CountActivity : AppCompatActivity() {
    private lateinit var countBinding : ActivityCountBinding
    private lateinit var viewModelCount : ViewModelCount
    private lateinit var viewModelFactory : ViewModelCountFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        countBinding = DataBindingUtil.setContentView(this, R.layout.activity_count)
        viewModelFactory = ViewModelCountFactory(5) //parametro por default al constructor de view model mediante la clase de viewModelFactory

        viewModelCount = ViewModelProvider(this, viewModelFactory).get(ViewModelCount::class.java)//igualamos el contenido de view model a la variable
        viewModelCount.totalData.observe(this, {
            countBinding.tvSetTextResultCount.text = it.toString()
        })
        countBinding.btnClickHereAumentCount.setOnClickListener {
            if(!countBinding.etSetTextResultSum.text.isNullOrEmpty()){
                viewModelCount.getUpdatedResult(countBinding.etSetTextResultSum.text.toString().toInt())
            }else{
                Toast.makeText(this, "Campo de suma vacio", Toast.LENGTH_SHORT).show()
            }
        }
    }
}