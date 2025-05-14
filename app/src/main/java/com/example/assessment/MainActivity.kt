package com.example.assessment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val outputTV : TextView = findViewById(R.id.outputTV)
        val editText : EditText = findViewById(R.id.editText)
        val lengthBtn : Button = findViewById(R.id.lengthBtn)
        val reverseBtn : Button = findViewById(R.id.reverseBtn)
        val appendBtn : Button = findViewById(R.id.appenBtn)
        val numericBtn : Button = findViewById(R.id.numericBtn)
        val clearBtn : Button = findViewById(R.id.clearBtn)

        val error = "Special characters are not allowed"

        lengthBtn.setOnClickListener {
            val input = editText.text.toString()
            outputTV.text = if (input.hasNoSpecialCharacters()) error else "${input.length}"
        }
        reverseBtn.setOnClickListener {
            val input = editText.text.toString()
            outputTV.text = if (input.hasNoSpecialCharacters()) error else input.reverse()
        }
        appendBtn.setOnClickListener {
            val input = editText.text.toString()
            outputTV.text = if (input.hasNoSpecialCharacters()) error else input.appendHello()
        }
        numericBtn.setOnClickListener {
            val input = editText.text.toString()
            outputTV.text = if (input.hasNoSpecialCharacters()) error else "${input.isAllIntegers()}"
        }
        clearBtn.setOnClickListener {
            editText.setText("")
            outputTV.text = ""
        }
    }

    private fun String.appendHello() : String{
        return "Hello $this"
    }

    private fun String.reverse()  : String{
        val array : CharArray = this.toCharArray()
        var left = 0
        var right = array.size - 1
        while (left < right){
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            left ++
            right --
        }
        return String(array)
    }

    private fun String.isAllIntegers() : Boolean{
        return this.matches(Regex("^\\d+$"))
    }

    private fun String.hasNoSpecialCharacters() : Boolean{
        return this.matches(Regex("[^a-zA-Z0-9\\s]"))
    }
}