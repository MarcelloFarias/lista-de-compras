package com.example.purchaseslist.dao

import com.example.purchaseslist.model.Purchase

class PurchasesDao {

    fun registerPurchase(purchase: Purchase) {
        purchases.add(purchase)
    }

    fun getAll(): List<Purchase> {
        return purchases.toList()
    }

    companion object {
        private val purchases = mutableListOf<Purchase>()
    }
}