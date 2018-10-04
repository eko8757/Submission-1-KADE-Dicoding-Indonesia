package com.example.eko8757.footballclub

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    var items: Item? = null
    lateinit var nameTextView: TextView
    lateinit var descTextView: TextView
    lateinit var ImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            topPadding = 16
            gravity = Gravity.CENTER_HORIZONTAL

            ImageView = imageView() {
            }.lparams(width = 170, height = 170)

            nameTextView = textView {
                padding = dip(16)
                textSize = 20F
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER_HORIZONTAL
            }

            descTextView = textView {
                text = items?.desc
                textSize = 15F
                padding = dip(15)
                gravity = Gravity.CENTER_HORIZONTAL
            }.lparams {
                width = matchParent
            }
        }

        var intent = intent

        items = intent.getParcelableExtra("name")
        Log.d("bebas", items?.name +"123")
        nameTextView.text = items?.name
        descTextView.text = items?.desc
        Glide.with(this).load(items?.image).into(ImageView)
    }
}