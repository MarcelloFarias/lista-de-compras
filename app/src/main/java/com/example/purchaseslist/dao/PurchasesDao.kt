package com.example.purchaseslist.dao

import com.example.purchaseslist.model.Purchase

class PurchasesDao {
    companion object {
        private val purchases = mutableListOf<Purchase>()
    }

    fun registerPurchase(purchase: Purchase) {
        purchases.add(purchase)
    }

    fun getAll(): List<Purchase> {
        return purchases.toList()
    }
}