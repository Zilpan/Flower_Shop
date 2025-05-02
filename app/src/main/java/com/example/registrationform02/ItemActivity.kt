package com.example.flowershop

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val title: TextView = findViewById(R.id.itemListTitleDetail)
        val description: TextView = findViewById(R.id.itemListLongDesc)
        val price: TextView = findViewById(R.id.itemListPriceDetail)
        val image: ImageView = findViewById(R.id.itemListImageDetail)

        title.text = intent.getStringExtra("itemTitle")
        description.text = intent.getStringExtra("itemDesc")
        price.text = intent.getIntExtra("itemPrice", 0).toString()
        image.setImageResource(intent.getIntExtra("itemImage", 0))
        //image.setImageResource(imageId)

    }
}