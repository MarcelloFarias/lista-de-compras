package com.example.purchaseslist.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.purchaseslist.R

class PurchaseListAdapter(private val purchases: List<Purchase>, private val context: Context): Adapter<PurchaseListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.purchase_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return purchases.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val purchase = purchases[position]
        holder.purchaseName.text = purchase.name
        holder.purchaseDescription.text = purchase.description
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val purchaseName: TextView = itemView.findViewById(R.id.purchase_name)
        val purchaseDescription: TextView = itemView.findViewById(R.id.purchase_description)
    }
}