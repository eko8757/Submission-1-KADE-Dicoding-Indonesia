package com.example.eko8757.footballclub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    var items: Item? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent

        items = intent.getParcelableExtra("name")
        tv_name_detail.text = items?.name
        tv_desc_detail.text = items?.desc
        Glide.with(this).load(items?.image).into(img_detail)
    }
}