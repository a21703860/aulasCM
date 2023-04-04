package com.example.aulascm
import androidx.recyclerview.widget.LinearLayoutManager
import net.objecthunter.exp4j.ExpressionBuilder

// Passar para aqui parte do código do CalculatorFragment
object Calculator {

    var display: String = "0"
        private set

    private val _history = mutableListOf<Operation>(Operation("1+1", "2"), Operation("2+2", "4"))
    val history get() = _history.toList()

    fun addSymbol(number: String) {
        if (display == "0") {
            display = number
        } else {
            display += (number)
        }
    }

    fun addOperation(operation: String) {
        display += operation
    }

    fun delete() {
        if(display.length > 0) {
            display = display.substring(0, display.length - 1);
        } else {
            display = "0";
        }
    }

    fun clear() {
        display = "0";
    }

    fun equals() {
        var result = ExpressionBuilder(display).build()
        _history.add(Operation(display, result.evaluate().toString()))
        display = result.evaluate().toString()
    }

    fun lastOperation() {
        var expression = _history.last().expression
        var result = _history.last().result
        display = "$expression = $result"
    }

}
