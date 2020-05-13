package com.intact.testingapp.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.intact.testingapp.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        next_button.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("FirstArg", "Anurag")
            }
            startActivity(intent)
        }
    }
}
