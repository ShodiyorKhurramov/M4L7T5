package com.example.m4l7t5

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.tv_task5text)
        val btHashtag = findViewById<View>(R.id.b_searchHashtag) as Button
        btHashtag.isAllCaps = false
        btHashtag.setOnClickListener {
            val pattern = Pattern.compile("(#\\w+)")
            val matcher = pattern.matcher(text.text)
            // Check all occurrences
            while (matcher.find()) {
                val spannableStr = SpannableString(text.text)
                val foregroundColorSpan = ForegroundColorSpan(Color.GREEN)
                spannableStr.setSpan(
                    foregroundColorSpan,
                    matcher.start(),
                    matcher.end(),
                    Spanned.SPAN_INCLUSIVE_EXCLUSIVE
                )
                text.text = spannableStr
            }
        }
    }
}
