package com.example.purchaseslist

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
            val RegisterPurchaseIntent = Intent(this, RegisterNewPurchaseActivity::class.java)
            startActivity(RegisterPurchaseIntent)
        }

        purchasesList = findViewById(R.id.purchases_list)
        purchasesList.adapter = PurchaseListAdapter(getPurchases(), this)
        val layoutManager = LinearLayoutManager(this)
        purchasesList.layoutManager = layoutManager
    }

    private fun getPurchases(): List<Purchase> {
        return listOf(
            Purchase("Azeite", "galo extra virgem"),
            Purchase("Doritos", "sweet chili"),
            Purchase("Tomate", "tomate cereja turma da mônica")
        )
    }
}