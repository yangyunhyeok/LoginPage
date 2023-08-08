package com.example.loginpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val signup = findViewById<Button>(R.id.signup)

        signup.setOnClickListener {
            val signUpName = findViewById<EditText>(R.id.signup_name).text.toString()
            val signUpId = findViewById<EditText>(R.id.signup_id).text.toString()
            val signUpPassword = findViewById<EditText>(R.id.signup_pass).text.toString()
            if (signUpName.length == 0 || signUpId.length == 0 || signUpPassword.length == 0) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"회원가입 완료",Toast.LENGTH_SHORT).show()
                intent.putExtra("signUpId",signUpId.toString())
                intent.putExtra("signUpPassword",signUpPassword.toString())
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}