package com.example.purchaseslist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterNewPurchaseActivity : AppCompatActivity() {
    private lateinit var btnCancel: Button
    private lateinit var btnSave: Button
    private lateinit var inputTitle: EditText
    private lateinit var inputDescription: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register_new_purchase)

        btnCancel = findViewById(R.id.btn_cancel)
        btnSave = findViewById(R.id.btn_save)
        inputTitle = findViewById(R.id.purchase_title_input)
        inputDescription = findViewById(R.id.purchase_description_input)

        btnCancel.setOnClickListener {
            val mainActivityIntent = Intent(this, MainActivity::class.java)
            startActivity(mainActivityIntent)
        }
    }
}