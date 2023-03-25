package com.example.aulascm

class Operation(var expression: String = "", var result: String = "") {
    override fun toString(): String {
        return "Expression: $expression, Result: $result"
    }
}
