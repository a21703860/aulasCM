package com.example.aulascm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.aulascm.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorFragment : Fragment() {
    private lateinit var binding: FragmentCalculatorBinding
    val operations: MutableList<String> = mutableListOf()
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
            R.layout.fragment_calculator, container, false
        )
        binding = FragmentCalculatorBinding.bind(view)
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        requireActivity().title = "Calculadora"
        binding.button0.setOnClickListener {
            Calculator.addSymbol("0")
            showDisplay()
        }
        binding.button1.setOnClickListener {
            Calculator.addSymbol("1")
            showDisplay()
        }
        binding.button2.setOnClickListener {
            Calculator.addSymbol("2")
            showDisplay()
        }
        binding.button3.setOnClickListener {
            Calculator.addSymbol("3")
            showDisplay()
        }
        binding.button4.setOnClickListener {
            Calculator.addSymbol("4")
            showDisplay()
        }
        binding.button5.setOnClickListener {
            Calculator.addSymbol("5")
            showDisplay()
        }
        binding.button6.setOnClickListener {
            Calculator.addSymbol("6")
            showDisplay()
        }
        binding.button7.setOnClickListener {
            Calculator.addSymbol("7")
            showDisplay()
        }
        binding.button8.setOnClickListener {
            Calculator.addSymbol("8")
            showDisplay()
        }
        binding.button9.setOnClickListener {
            Calculator.addSymbol("9")
            showDisplay()
        }

        binding.buttonClean.setOnClickListener {
            (Calculator.clear())
            showDisplay()
        }
        binding.buttonLast.setOnClickListener {
            (Calculator.lastOperation())
            showDisplay()
        }
        binding.buttonRemove.setOnClickListener {
            (Calculator.delete())
            showDisplay()
        }
        binding.buttonEquals.setOnClickListener {
            (Calculator.equals())
            showDisplay()
        }
        binding.buttonPlus.setOnClickListener {
            (Calculator.addOperation("+"))
            showDisplay()
        }
        binding.buttonPoint.setOnClickListener {
            (Calculator.addOperation("."))
            showDisplay()
        }
        binding.buttonMultiple.setOnClickListener {
            (Calculator.addOperation("*"))
            showDisplay()
        }
        binding.buttonDivide.setOnClickListener {
            (Calculator.addOperation("/"))
            showDisplay()
        }
        binding.buttonMinus.setOnClickListener {
            (Calculator.addOperation("-"))
            showDisplay()
        }
    }

    fun showDisplay() {
        binding.textVisor.text = Calculator.display
    }
}
