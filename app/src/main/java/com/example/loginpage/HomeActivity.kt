package com.example.loginpage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var homeImage = findViewById<ImageView>(R.id.imageView)
        var size = (0..4)
        var ramdom = size.random()
        var photolist:String = "R.drawable.myshiba"
        homeImage.setImageResource(R.drawable.myshiba+ramdom)

        val id = intent.getStringExtra("idData")
        val homeId =findViewById<TextView>(R.id.home_id)
        homeId.setText("아이디 : "+id)


        val finish = findViewById<Button>(R.id.finish)
        finish.setOnClickListener {
            finish()
        }
    }
}