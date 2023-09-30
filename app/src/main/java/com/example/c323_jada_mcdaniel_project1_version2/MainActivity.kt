package com.example.c323_jada_mcdaniel_project1_version2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
//import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.log10
import kotlin.math.sin
import kotlin.math.tan

class MainActivity : AppCompatActivity() {
    private var canAddOperation = false
    private var canAddDecimal = true
    private var canAddPercent = false
    private var textLineText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textLine = findViewById<TextView>(R.id.text)

        if(savedInstanceState != null){
            textLineText = savedInstanceState.getString("TEXT_KEY").toString()
            textLine.text = textLineText
        }

        val c = findViewById<Button>(R.id.c)
        val plusMinus = findViewById<Button>(R.id.plusMinus)
        val percent = findViewById<Button>(R.id.percent)
        val divide = findViewById<Button>(R.id.divide)
        val _7 = findViewById<Button>(R.id._7)
        val _8 = findViewById<Button>(R.id._8)
        val _9 = findViewById<Button>(R.id._9)
        val x = findViewById<Button>(R.id.x)
        val _4 = findViewById<Button>(R.id._4)
        val _5 = findViewById<Button>(R.id._5)
        val _6 = findViewById<Button>(R.id._6)
        val minus = findViewById<Button>(R.id.minus)
        val _1 = findViewById<Button>(R.id._1)
        val _2 = findViewById<Button>(R.id._2)
        val _3 = findViewById<Button>(R.id._3)
        val plus = findViewById<Button>(R.id.plus)
        val _0 = findViewById<Button>(R.id._0)
        val decimal = findViewById<Button>(R.id.decimal)
        val equals = findViewById<Button>(R.id.equals)
        val sin = findViewById<Button>(R.id.sin)
        val cos = findViewById<Button>(R.id.cos)
        val tan = findViewById<Button>(R.id.tan)
        val log = findViewById<Button>(R.id.log)
        val ln = findViewById<Button>(R.id.ln)

        c.setOnClickListener{
            textLine.text = ""
            textLineText = ""
            canAddOperation = false
            canAddDecimal = true
            canAddPercent = false
        }
        plusMinus.setOnClickListener{
            val newText =  textLine.text.toString() + "–"
            textLineText = newText
            textLine.text = newText
        }
        percent.setOnClickListener{
            if(canAddPercent){
                canAddPercent = false
                val newText =  textLine.text.toString() + "%"
                textLineText = newText
                textLine.text = newText
            }
        }
        divide.setOnClickListener{
            if(canAddOperation) {
                canAddPercent = false
                canAddOperation = false
                canAddDecimal = true
                val newText = textLine.text.toString() + "/"
                textLineText = newText
                textLine.text = newText
            }
        }
        _7.setOnClickListener{
            val newText =  textLine.text.toString() + "7"
            textLineText = newText
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _8.setOnClickListener{
            val newText =  textLine.text.toString() + "8"
            textLineText = newText
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _9.setOnClickListener{
            val newText =  textLine.text.toString() + "9"
            textLineText = newText
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        x.setOnClickListener{
            if(canAddOperation) {
                canAddOperation = false
                canAddDecimal = true
                canAddPercent = false
                val newText = textLine.text.toString() + "x"
                textLineText = newText
                textLine.text = newText
            }
        }
        _4.setOnClickListener{
            val newText =  textLine.text.toString() + "4"
            textLineText = newText
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _5.setOnClickListener{
            val newText =  textLine.text.toString() + "5"
            textLineText = newText
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _6.setOnClickListener{
            val newText =  textLine.text.toString() + "6"
            textLineText = newText
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        minus.setOnClickListener{
            if(canAddOperation) {
                canAddOperation = false
                canAddDecimal = true
                canAddPercent = false
                val newText = textLine.text.toString() + "-"
                textLineText = newText
                textLine.text = newText
            }
        }
        _1.setOnClickListener{
            val newText =  textLine.text.toString() + "1"
            textLineText = newText
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _2.setOnClickListener{
            val newText =  textLine.text.toString() + "2"
            textLineText = newText
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _3.setOnClickListener{
            val newText =  textLine.text.toString() + "3"
            textLineText = newText
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        plus.setOnClickListener{
            if(canAddOperation) {
                canAddOperation = false
                canAddDecimal = true
                canAddPercent = false
                val newText = textLine.text.toString() + "+"
                textLineText = newText
                textLine.text = newText
            }
        }
        _0.setOnClickListener{
            val newText =  textLine.text.toString() + "0"
            textLineText = newText
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        decimal.setOnClickListener{
            if(canAddDecimal){
                canAddDecimal = false
                canAddPercent = false
                val newText =  textLine.text.toString() + "."
                textLineText = newText
                textLine.text = newText
            }
        }
        equals.setOnClickListener{
            val solution = evaluate(textLine.text.toString())
            textLineText = solution
            textLine.text = solution
        }
        if(sin != null){
            sin.setOnClickListener{
                val newText =  textLine.text.toString() + "sin("
                textLineText = newText
                textLine.text = newText
            }
            cos.setOnClickListener{
                val newText =  textLine.text.toString() + "cos("
                textLineText = newText
                textLine.text = newText
            }
            tan.setOnClickListener{
                val newText =  textLine.text.toString() + "tan("
                textLineText = newText
                textLine.text = newText
            }
            log.setOnClickListener{
                val newText =  textLine.text.toString() + "log("
                textLineText = newText
                textLine.text = newText
            }
            ln.setOnClickListener{
                val newText =  textLine.text.toString() + "ln("
                textLineText = newText
                textLine.text = newText
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("TEXT_KEY", textLineText)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        if (savedInstanceState != null) {
            textLineText = savedInstanceState.getString("TEXT_KEY").toString()
        }
        super.onRestoreInstanceState(savedInstanceState)
    }


    private fun evaluate(s: String): String {
        var solution = ""
        if(s.isNotEmpty()){
            val nums = s.split("+", "-", "x", "/").toMutableList()
            var opps = s.filter { i: Char -> i == '+' || i == '-' || i == 'x' || i == '/' }

            if(s.contains("–")){
                for((index, value) in nums.withIndex()){
                    if(value.contains("–")){
                        val negativeStr = value.replace("–", "")
                        val newNum = "-$negativeStr"
                        nums[index] = newNum
                    }
                }
            }
            if(s.contains('%')){
                for((index, value) in nums.withIndex()){
                    if(value.contains('%')){
                        val percentStr = value.replace("%", "")
                        val percentNum = percentStr.toInt()
                        val newNum = percentNum / 100
                        nums[index] = newNum.toString()
                    }
                }
            }
            if(s.contains("sin(") || s.contains("cos(") || s.contains("tan(") || s.contains("log(") || s.contains("ln(")){
                for((index, value) in nums.withIndex()){
                    val valSplit = value.split("(").toMutableList()

                    while(valSplit.contains("sin") || valSplit.contains("cos") || valSplit.contains("tan") || valSplit.contains("log") || valSplit.contains("ln")){
                        val opIndex = valSplit.indexOfLast{ i: String -> i.matches("sin".toRegex()) || i.matches("cos".toRegex()) || i.matches("tan".toRegex()) || i.matches("log".toRegex()) || i.matches("ln".toRegex()) }

                        if(valSplit[opIndex].matches("sin".toRegex())){
                            valSplit[opIndex + 1] = sin(valSplit[opIndex + 1].toDouble()).toString()
                            valSplit.removeAt(opIndex)
                        }
                        else if(valSplit[opIndex].matches("cos".toRegex())){
                            valSplit[opIndex + 1] = cos(valSplit[opIndex + 1].toDouble()).toString()
                            valSplit.removeAt(opIndex)
                        }
                        else if(valSplit[opIndex].matches("tan".toRegex())){
                            valSplit[opIndex + 1] = tan(valSplit[opIndex + 1].toDouble()).toString()
                            valSplit.removeAt(opIndex)
                        }
                        else if(valSplit[opIndex].matches("log".toRegex())){
                            valSplit[opIndex + 1] = log10(valSplit[opIndex + 1].toDouble()).toString()
                            valSplit.removeAt(opIndex)
                        }
                        else if(valSplit[opIndex].matches("ln".toRegex())){
                            valSplit[opIndex + 1] = ln(valSplit[opIndex + 1].toDouble()).toString()
                            valSplit.removeAt(opIndex)
                        }
                    }


                    nums[index] = valSplit[0]
                }
            }
            if(s.contains('x') || s.contains('/')){
                var count = 0
                while(opps.contains('x') || opps.contains('/')){
                    if(opps[count] == 'x'){
                        val num1 = nums[count].toDouble()
                        val num2 = nums[count+1].toDouble()
                        val newNum = num1 * num2
                        nums[count] = newNum.toString()
                        nums.removeAt(count+1)
                        opps = opps.replaceFirst("x", "")
                    }
                    else if(opps[count] == '/'){
                        val num1 = nums[count].toDouble()
                        val num2 = nums[count+1].toDouble()
                        val newNum = num1 / num2
                        nums[count] = newNum.toString()
                        nums.removeAt(count+1)
                        opps = opps.replaceFirst("/", "")
                    }
                    else{
                        count++
                    }
                }
            }
            if(s.contains('+') || s.contains('-')){
                var count = 0
                while(opps.contains('+') || opps.contains('-')){
                    if(opps[count] == '+'){
                        val num1 = nums[count].toDouble()
                        val num2 = nums[count+1].toDouble()
                        val newNum = num1 + num2
                        nums[count] = newNum.toString()
                        nums.removeAt(count+1)
                        opps = opps.replaceFirst("+", "")
                    }
                    else if(opps[count] == '-'){
                        val num1 = nums[count].toDouble()
                        val num2 = nums[count+1].toDouble()
                        val newNum = num1 - num2
                        nums[count] = newNum.toString()
                        nums.removeAt(count+1)
                        opps = opps.replaceFirst("-", "")
                    }
                    else{
                        count++
                    }
                }
            }
            solution = nums[0]
        }

        return solution
    }
}