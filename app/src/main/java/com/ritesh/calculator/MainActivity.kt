package com.ritesh.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.ritesh.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnAc.setOnClickListener {
            binding.inputText.text = ""
            binding.outputText.text = ""
        }

        binding.btn0.setOnClickListener{

            binding.inputText.append("0")
        }
        binding.btn1.setOnClickListener{

            binding.inputText.append("1")
        }
        binding.btn2.setOnClickListener{
            binding.inputText.append("2")

        }
        binding.btn3.setOnClickListener{
            binding.inputText.append("3")

        }
        binding.btn4.setOnClickListener{

            binding.inputText.append("4")
        }
        binding.btn5.setOnClickListener{

            binding.inputText.append("5")
        }
        binding.btn6.setOnClickListener{

            binding.inputText.append("6")
        }
        binding.btn7.setOnClickListener{
            binding.inputText.append("7")

        }
        binding.btn8.setOnClickListener{
            binding.inputText.append("8")

        }
        binding.btn9.setOnClickListener{
            binding.inputText.append("9")
        }

        binding.btnPlus.setOnClickListener{
            binding.inputText.append("+")
        }
        binding.btnMinus.setOnClickListener{
            binding.inputText.append(" - ")
        }
        binding.btnMultiplication.setOnClickListener{
            binding.inputText.append(" * ")
        }
        binding.btnDivide.setOnClickListener{
            binding.inputText.append(" / ")
        }
        binding.btnDot.setOnClickListener{
            binding.inputText.append(".")
        }

        binding.btnEndBracket.setOnClickListener{
            binding.inputText.append(" ) ")
        }
        binding.btnStartBracket.setOnClickListener{
            binding.inputText.append(" ( ")
        }


        binding.bs.setOnClickListener{
            val string = binding.inputText.text.toString()
            if(string.isNotEmpty())
            {
                binding.inputText.text = string.substring(0,string.length-1)
            }
            binding.outputText.text = ""
        }



        binding.btnEqual.setOnClickListener{

            try {
                val expression = ExpressionBuilder(binding.inputText.text.toString()).build()
                val result = expression.evaluate()
                val longresult = result.toLong()

                if (result == longresult.toDouble()) {

                    binding.outputText.text = longresult.toString()
                } else {
                    binding.outputText.text = result.toString()
                }

            }
            catch(e: Exception)
            {
                Log.d("Exception","message : " + e.message)
            }
        }



    }


}





