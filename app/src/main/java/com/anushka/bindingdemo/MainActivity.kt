package com.anushka.bindingdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.anushka.bindingdemo.databinding.ActivityMainBinding
import com.anushka.bindingdemo.models.Students

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    //lateinit var student : Students
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.student = getStudents()

        /**student  = getStudents()
        binding.tvGetStudentExample.text = student.name**/

        binding.submitButton.setOnClickListener {
            displayGreeting()
        }

        binding.btnStartAndStop.setOnClickListener{
            stopOnStartProgressBar()
        }
    }

    private fun displayGreeting() {
        binding.apply {
            greetingTextView.text = "Hello! " + nameEditText.text
        }
    }

    private fun stopOnStartProgressBar(){
        binding.apply {
            if (binding.btnStartAndStop.text == "Start"){
                binding.btnStartAndStop.text = "Stop"
                binding.progressBar.visibility = View.INVISIBLE
            } else {
                binding.btnStartAndStop.text = "Start"
                binding.progressBar.visibility = View.VISIBLE
            }
        }
    }

    private fun getStudents(): Students {
    return  Students(1,"Jorge Alfredo Campos Ortega","jorgec.informatic@gmail.com")
    }
}
