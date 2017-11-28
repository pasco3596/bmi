package jp.ac.hal.bmicalculator

import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by pasuco on 2017/11/28.
 */
class MainUI : AnkoComponent<MainActivity> {
    lateinit var tallEt: EditText
    lateinit var weightEt: EditText
    lateinit var tv: TextView

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        verticalLayout {
            verticalLayout {
                orientation = LinearLayout.HORIZONTAL
                textView {
                    text = "身長"
                    gravity = Gravity.CENTER
                }.lparams(width = 0, weight = 1f)
                tallEt = editText {
                    hint = "cm"
                    gravity = Gravity.RIGHT
                    inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
                }.lparams(width = 0, weight = 2f)
            }
            verticalLayout {
                orientation = LinearLayout.HORIZONTAL
                textView {
                    text = "体重"
                    gravity = Gravity.CENTER
                }.lparams(width = 0, weight = 1f)
                weightEt = editText {
                    hint = "kg"
                    gravity = Gravity.RIGHT
                    inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_FLAG_DECIMAL
                }.lparams(width = 0, weight = 2f)
            }
            button("BMI計算") {
                onClick {
                    try {
                        val weight = Integer.parseInt(weightEt.text.toString()).toDouble()
                        val tall = Integer.parseInt(tallEt.text.toString()).toDouble()
                        ui.owner.bmiCal(weight,tall,tv)
                    } catch (e: Exception) {
                        toast("ちゃんと入力しろ")
                    }
                }
            }
            tv = textView()
        }
    }
}
