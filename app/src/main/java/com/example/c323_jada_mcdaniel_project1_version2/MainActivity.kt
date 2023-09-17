package com.example.c323_jada_mcdaniel_project1_version2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var canAddOperation = false
    private var canAddDecimal = true
    private var canAddPercent = false
    private var textLineText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textLine = findViewById<TextView>(R.id.text)

        //textLine.text = textLineText
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

        c.setOnClickListener{
            textLineText = ""
            textLine.text = textLineText
            canAddOperation = false
            canAddDecimal = true
            canAddPercent = false
        }
        plusMinus.setOnClickListener{
            val newText =  textLine.text.toString() + "–"
            textLine.text = newText
        }
        percent.setOnClickListener{
            if(canAddPercent){
                canAddPercent = false
                val newText =  textLine.text.toString() + "%"
                textLine.text = newText
            }
        }
        divide.setOnClickListener{
            if(canAddOperation) {
                canAddPercent = false
                canAddOperation = false
                canAddDecimal = true
                val newText = textLine.text.toString() + "/"
                textLine.text = newText
            }
        }
        _7.setOnClickListener{
            val newText =  textLine.text.toString() + "7"
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _8.setOnClickListener{
            val newText =  textLine.text.toString() + "8"
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _9.setOnClickListener{
            val newText =  textLine.text.toString() + "9"
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
                textLine.text = newText
            }
        }
        _4.setOnClickListener{
            val newText =  textLine.text.toString() + "4"
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _5.setOnClickListener{
            val newText =  textLine.text.toString() + "5"
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _6.setOnClickListener{
            val newText =  textLine.text.toString() + "6"
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
                textLine.text = newText
            }
        }
        _1.setOnClickListener{
            val newText =  textLine.text.toString() + "1"
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _2.setOnClickListener{
            val newText =  textLine.text.toString() + "2"
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        _3.setOnClickListener{
            val newText =  textLine.text.toString() + "3"
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
                textLine.text = newText
            }
        }
        _0.setOnClickListener{
            val newText =  textLine.text.toString() + "0"
            textLine.text = newText
            canAddOperation = true
            canAddPercent = true
        }
        decimal.setOnClickListener{
            if(canAddDecimal){
                canAddDecimal = false
                canAddPercent = false
                val newText =  textLine.text.toString() + "."
                textLine.text = newText
            }
        }
        equals.setOnClickListener{
            val solution = evaluate(textLine.text.toString())
            textLine.text = solution
        }
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
            if(s.contains('x') || s.contains('/')){
                var count = 0
                while(opps.contains('x') || opps.contains('/')){
                    if(opps[count] == 'x'){
                        val num1 = nums[count].toInt()
                        val num2 = nums[count+1].toInt()
                        val newNum = num1 * num2
                        nums[count] = newNum.toString()
                        nums.removeAt(count+1)
                        opps = opps.replaceFirst("x", "")
                    }
                    else if(opps[count] == '/'){
                        val num1 = nums[count].toInt()
                        val num2 = nums[count+1].toInt()
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
                        val num1 = nums[count].toInt()
                        val num2 = nums[count+1].toInt()
                        val newNum = num1 + num2
                        nums[count] = newNum.toString()
                        nums.removeAt(count+1)
                        opps = opps.replaceFirst("+", "")
                    }
                    else if(opps[count] == '-'){
                        val num1 = nums[count].toInt()
                        val num2 = nums[count+1].toInt()
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