package com.example.aulascm

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.aulascm.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    val operations: MutableList<String> = mutableListOf()
    private lateinit var binding: ActivityMainBinding
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.button1.setOnClickListener{ addSymbol("1", "Click no botão 1") }
        binding.button2.setOnClickListener{ addSymbol("2", "Click no botão 2") }
        binding.button3.setOnClickListener{ addSymbol("3", "Click no botão 3") }
        binding.button4.setOnClickListener{ addSymbol("4", "Click no botão 4") }
        binding.button5.setOnClickListener{ addSymbol("5", "Click no botão 5") }
        binding.button6.setOnClickListener{ addSymbol("6", "Click no botão 6") }
        binding.button7.setOnClickListener{ addSymbol("7", "Click no botão 7") }
        binding.button8.setOnClickListener{ addSymbol("8", "Click no botão 8") }
        binding.button9.setOnClickListener{ addSymbol("9", "Click no botão 9") }
        binding.buttonAdition.setOnClickListener(addOperation("+","Click no botão +"))
        binding.buttonX.setOnClickListener(addOperation("*","Click no botão X"))
        binding.buttonMinus.setOnClickListener(addOperation("-","Click no botão -"))
        binding.buttonPoint.setOnClickListener(addOperation(".","Click no botão ."))
        binding.buttonEquals.setOnClickListener(equals())
        binding.buttonBack.setOnClickListener(backspace())
        binding.buttonClean.setOnClickListener(clear())
    }

    fun addSymbol(number: String, logMessage: String){
        Log.i(TAG, logMessage)
        if(binding.textVisor.text.toString() == "0") {
            binding.textVisor.text = number
        } else {
            binding.textVisor.append(number)
        }

    }
    fun addOperation(operation: String, logMessage: String): View.OnClickListener {
        return View.OnClickListener {
            Log.i(TAG, logMessage)
            binding.textVisor.append(operation)
        }
    }

    fun equals(): View.OnClickListener {
        return View.OnClickListener {
            Log.i(TAG, "Click no botão =")
            val expression = ExpressionBuilder(
                binding.textVisor.text.toString()
            ).build()
            operations.add(binding.textVisor.text.toString())
            binding.textVisor.text = expression.evaluate().toString()
            Log.i(TAG, "O resultado da expressão é ${binding.textVisor.text}")
        }
    }

    fun backspace(): View.OnClickListener {
        return View.OnClickListener {
            if (operations.size > 0) {
                binding.textVisor.text = operations.last()
            } else {
                binding.textVisor.text = "0";
            }
        }
    }

    fun clear(): View.OnClickListener {
        return View.OnClickListener {
            binding.textVisor.text = "0";
        }
    }
}

