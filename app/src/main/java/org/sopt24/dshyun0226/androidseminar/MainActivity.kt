package org.sopt24.dshyun0226.androidseminar

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainLogin.setOnClickListener {
            Toast.makeText(applicationContext, "hello android", Toast.LENGTH_SHORT).show()
            toast("hello")
            Log.d("mytag", "hello")

            // anko
            startActivity<LoginActivity>()
        }

        btnMainClose.setOnClickListener {
            finish()
        }
    }
}

