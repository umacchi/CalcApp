package jp.techacademy.hide.yui.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton.setOnClickListener(this)
        subButton.setOnClickListener(this)
        multiButton.setOnClickListener(this)
        divideButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {

        if(num1.text.isNullOrBlank() || num2.text.isNullOrBlank()) {

            Log.d("UI_PARTS", "未入力です")

            Snackbar.make(v, "何か数値を入力してください", Snackbar.LENGTH_INDEFINITE)
                .setAction("閉じる"){
                    Log.d("UI_PARTS", "何か数値を入力してください")
                }.show()
        } else {

            var num1 = num1.text.toString().toDouble()
            var num2 = num2.text.toString().toDouble()

            var result: Double = 0.0

            when(v.id){
                R.id.addButton    -> result = calcAdd(num1, num2)
                R.id.subButton    -> result = calcSub(num1, num2)
                R.id.multiButton  -> result = calcMulti(num1, num2)
                R.id.divideButton -> result = calcDivide(num1, num2)
            }

            Log.d("UI_PARTS", result.toString())

            val intent = Intent(this, CalcResultActivity::class.java)
            intent.putExtra("RESULT", result)
            startActivity(intent)

        }


    }


    private fun calcAdd(num1: Double, num2: Double): Double {
        return num1 + num2
    }
    private fun calcSub(num1: Double, num2: Double): Double {
        return num1 - num2
    }

    private fun calcMulti(num1: Double, num2: Double): Double {
        return num1 * num2
    }

    private fun calcDivide(num1: Double, num2: Double): Double {
        return num1 / num2
    }
}