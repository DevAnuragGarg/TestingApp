package com.intact.testingapp.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.intact.testingapp.R
import com.intact.testingapp.ui.fragment.BaseFragmentFactory
import com.intact.testingapp.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val customFragmentFactory = BaseFragmentFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        // initializing fragment factory
        supportFragmentManager.fragmentFactory = customFragmentFactory
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // show the fragment
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace<HomeFragment>(R.id.fragment_container)
            }
        }

        // set button click listener
        next_button.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("FirstArg", "Anurag")
            }
            startActivity(intent)
        }
    }
}
