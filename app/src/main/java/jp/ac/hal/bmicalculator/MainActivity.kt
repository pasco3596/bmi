package jp.ac.hal.bmicalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainUI().setContentView(this)
    }
    fun bmiCal(weight:Double,tall:Double,tv:TextView) {
        val bmi = weight * 10000 / (tall * tall)
        val rweight = (tall * tall) * 22 /10000
        tv.text = String.format("BMIは%.2fでした\n理想体重は%.2fです", bmi,rweight)
    }
}
