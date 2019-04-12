package com.kotlin.UserCenter.ui.activiity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.UserCenter.R
import kotlinx.android.synthetic.main.activity_test.*
import org.jetbrains.anko.toast

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        test.setText("${intent.getIntExtra("id", -1)}")
    }
}
