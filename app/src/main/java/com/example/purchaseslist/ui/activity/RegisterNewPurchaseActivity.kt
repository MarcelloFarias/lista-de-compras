package com.example.purchaseslist.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.purchaseslist.R
import com.example.purchaseslist.dao.PurchasesDao
import com.example.purchaseslist.model.Purchase

class RegisterNewPurchaseActivity : AppCompatActivity() {
    private lateinit var btnCancel: Button
    private lateinit var btnSave: Button
    private lateinit var inputName: EditText
    private lateinit var inputDescription: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_new_purchase)

        btnCancel = findViewById(R.id.btn_cancel)
        btnSave = findViewById(R.id.btn_save)
        inputName = findViewById(R.id.purchase_name_input)
        inputDescription = findViewById(R.id.purchase_description_input)

        btnCancel.setOnClickListener {
            val mainActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(mainActivityIntent)
        }

        btnSave.setOnClickListener {
            if(inputName.text.isBlank()) {
                Toast.makeText(this, "Você precisa adicionar o nome do produto", Toast.LENGTH_SHORT).show()
            } else {
                val newPurchase = Purchase(inputName.text.toString(), inputDescription.text.toString())
                val purchasesDao = PurchasesDao()
                purchasesDao.registerPurchase(newPurchase)

                finish()
            }
        }
    }
}