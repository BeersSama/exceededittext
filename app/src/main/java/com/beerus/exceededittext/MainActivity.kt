package com.beerus.exceededittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.beerus.exceededittext.consts.EXCEED_CHAR_COUNT
import com.beerus.exceededittext.databinding.ActivityMainBinding
import com.beerus.exceededittext.extensions.isMaxOpacity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isExceedText = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            edtExceed.doAfterTextChanged {
                isExceedText = edtExceed.length() > EXCEED_CHAR_COUNT
                tvExceed.isVisible = isExceedText
                tvExceed.text = (edtExceed.length() - EXCEED_CHAR_COUNT).toString()
                btnSubmit.isMaxOpacity = !isExceedText
            }
            btnSubmit.setOnClickListener {
                if (!isExceedText && !edtExceed.text.isNullOrBlank()) {
                    doSubmit(edtExceed.text.toString())
                }
            }
        }
    }

    private fun doSubmit(content: String) {
        Toast.makeText(applicationContext, "This is content: $content", Toast.LENGTH_SHORT).show()
    }
}