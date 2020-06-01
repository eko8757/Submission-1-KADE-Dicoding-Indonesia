package com.example.eko8757.footballclub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = FootballAdapter(this, items) {
            val i = Intent(this, DetailActivity::class.java)
            i.putExtra("name", it)
            startActivity(i)
        }
    }

    private fun initData() {
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val desc = resources.getStringArray(R.array.desc_club)

        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i], desc[i], image.getResourceId(i, 0)))
        }
    }
}
