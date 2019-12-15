package com.example.otpverification

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    internal var otp_Value = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manageOTPText()

        button.setOnClickListener {
            //
            otp_Value = edtOtp1.text.toString() +
                    edtOtp2.text.toString() +
                    edtOtp3.text.toString() +
                    edtOtp4.text.toString()
            if (otp_Value.isNullOrEmpty()) {
                Toast.makeText(this@MainActivity, "empty", Toast.LENGTH_SHORT).show()
            } else if (otp_Value.length == 4) {
                Toast.makeText(this@MainActivity, otp_Value, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "please fill otp ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun manageOTPText() {
        edtOtp1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.toString().length > 0) {
                    edtOtp2.requestFocus()
                }
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })
        edtOtp2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.toString().length > 0) {
                    edtOtp3.requestFocus()
                } else
                    edtOtp1.requestFocus()
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })
        edtOtp3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.toString().length > 0) {
                    edtOtp4.requestFocus()
                } else
                    edtOtp2.requestFocus()
            }

            override fun afterTextChanged(editable: Editable) {

            }
        })
        edtOtp4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (charSequence.toString().length > 0) {
                    hideSoftKeyboard()
                } else
                    edtOtp3.requestFocus()
            }

            override fun afterTextChanged(editable: Editable) {}
        })
    }


    fun hideSoftKeyboard() {
        if (currentFocus != null) {
            val inputMethodManager =
                    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
    }

}
