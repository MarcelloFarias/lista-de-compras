package com.example.purchaseslist.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.purchaseslist.model.PurchaseListAdapter
import com.example.purchaseslist.R
import com.example.purchaseslist.dao.PurchasesDao
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnNewItem: ExtendedFloatingActionButton
    private lateinit var purchasesList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnNewItem = findViewById(R.id.btn_new_item)

        btnNewItem.setOnClickListener {
            val registerPurchaseIntent = Intent(this, RegisterNewPurchaseActivity::class.java)
            startActivity(registerPurchaseIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        val purchasesDao = PurchasesDao()

        purchasesList = findViewById(R.id.purchases_list)
        purchasesList.adapter = PurchaseListAdapter(purchasesDao.getAll(), this)
        val layoutManager = LinearLayoutManager(this)
        purchasesList.layoutManager = layoutManager
    }
}