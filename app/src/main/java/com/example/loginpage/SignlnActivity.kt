package com.example.loginpage

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kotlin.math.sign
import kotlin.random.Random


    var idData:String?=null
    var passwordData:String?=null

class SignlnActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")


    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var loginLauncher: ActivityResultLauncher<Intent>
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val id = findViewById<EditText>(R.id.id)
        val password = findViewById<EditText>(R.id.password)



        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener {
            val idData = id.text.toString()
            val passwordData = password.text.toString()
            val intent = Intent(this, HomeActivity::class.java)
            if (idData.length == 0 || passwordData.length == 0) {
                Toast.makeText(this, "아이디와 비밀번호를 전부 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                intent.putExtra("idData", idData)
                startActivity(intent)
            }
        }
        val signUp = findViewById<Button>(R.id.signup)
        signUp.setOnClickListener {
            var signupIntent = Intent(this, SignUpActivity::class.java)
            loginLauncher.launch(signupIntent)
        }

        loginLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result ->
            if(result.resultCode == RESULT_OK) {
                val data = result.data
                idData = data?.getStringExtra("signUpId") ?: ""
                passwordData = data?.getStringExtra("signUpPassword") ?: ""

                id.setText(idData)
                password.setText(passwordData)
            }
        }
    }
}


