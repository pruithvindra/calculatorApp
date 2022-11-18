package com.saicharan.calculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.saicharan.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    lateinit  var binding:ActivityMainBinding
    var isOperratiorAdded :  Boolean  = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


     //   setContentView(R.layout.activity_main)
        /*Number Buttons*/

        binding.tvOne.setOnClickListener {
            evaluateExpression("1", isOperater = false)
        }

        binding.tvTwo.setOnClickListener {
            evaluateExpression("2", isOperater = false)
        }

        binding.tvThree.setOnClickListener {
            evaluateExpression("3", isOperater = false)
        }
        binding.tvFour.setOnClickListener {
            evaluateExpression("4", isOperater = false)
        }

        binding.tvFive.setOnClickListener {
            evaluateExpression("5", isOperater = false)
        }

        binding.tvSix.setOnClickListener {
            evaluateExpression("6", isOperater = false)
        }

        binding.tvSeven.setOnClickListener {
            evaluateExpression("7",isOperater = false)
        }

        binding.tvEight.setOnClickListener {
            evaluateExpression("8",isOperater = false)
        }

        binding.tvNine.setOnClickListener {
            evaluateExpression("9", isOperater = false)
        }

        binding.tvZero.setOnClickListener {
            if(!isOperratiorAdded){  evaluateExpression("0", isOperater = false)}

        }

        /*Operators*/

        binding.tvPlus.setOnClickListener {
            evaluateExpression("+",isOperater = true)
        }

        binding.tvMinus.setOnClickListener {
            evaluateExpression("-", isOperater = true)
        }

        binding.tvMul.setOnClickListener {
            evaluateExpression("*", isOperater = true)
        }

        binding.tvDivide.setOnClickListener {
            evaluateExpression("/", isOperater = true)
        }

        binding.tvDot.setOnClickListener {
            evaluateExpression(".", isOperater = true)
        }

        binding.tvClear.setOnClickListener {
            binding.tvExpression.text = ""
            binding.tvResult.text = ""
        }

        binding.tvEquals.setOnClickListener {
            val text =  (binding.tvExpression.text).toString()

            if(text.isNotEmpty() && !isOperratiorAdded){
                val expression = ExpressionBuilder(text).build()

                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    binding.tvResult.text = longResult.toString()
                } else {
                    binding.tvResult.text = result.toString()
                }
            }

        }

        binding.tvBack.setOnClickListener {
            val text =  binding.tvExpression.text.toString()
            if(text.isNotEmpty()) {
                binding.tvExpression.text = text.dropLast(1)

            }

            binding.tvResult.text = ""
        }
    }

    /*Function to calculate the expressions using expression builder library*/

    fun evaluateExpression(string: String, isOperater: Boolean) {

        if(((isOperater && !isOperratiorAdded && !binding.tvExpression.text.toString().isEmpty()  ) || !isOperater) ){
            Log.d("uuu", "evaluateExpression() called with: string = $string, clear = $isOperater")
            var text : String =  binding.tvExpression.text.toString()
            text =  text + string
            binding.tvExpression.text = text

            Log.d("uuu", "e=the valkue us $text")
            isOperratiorAdded = isOperater
//            Result.text = ""
//            Expression.append(string)
        }

    }
}