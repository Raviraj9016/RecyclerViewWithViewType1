package com.example.recyclerviewwithviewtype1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var products : ArrayList<Product>
    private lateinit var users : ArrayList<User>
    private lateinit var productsAdapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initProducts()
        initViews()
    }
    fun initViews(){
        recyclerView = findViewById(R.id.recyclerProducts)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        productsAdapter = ProductsAdapter(products, users)
        recyclerView.adapter = productsAdapter
    }

    fun initProducts(){
        products = ArrayList()
        for (i in 0..15){
            products.add(
                Product(
                i,
                "Product"+i,
                "500"+i
            )
            )
        }

        users = ArrayList()
        for (i in 0..3){
            users.add(
                User(
                    i,
                    "Raviraj",
                    "$i"
                )
            )
        }
    }
}