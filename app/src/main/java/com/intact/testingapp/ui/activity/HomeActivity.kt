package com.intact.testingapp.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
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
            val bundle = Bundle()
            bundle.putInt("MOVIE_ID", 1)
            supportFragmentManager.commit {
                replace(R.id.fragment_container, HomeFragment::class.java, bundle)
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
