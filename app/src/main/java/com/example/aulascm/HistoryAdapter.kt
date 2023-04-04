package com.example.aulascm

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aulascm.databinding.ItemExpressionBinding

class HistoryAdapter(private val onOperationClick: (String)->Unit , private var items: List<Operation> = listOf()) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(val binding: ItemExpressionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemExpressionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.itemView.setOnClickListener{ onOperationClick(items[position].toString())}
        holder.binding.textExpression.text = items[position].expression
        holder.binding.textResult.text = items[position].result
    }

    override fun getItemCount() = items.size


    @SuppressLint("NotifyDataSetChanged")
    fun updateItems(items: List<Operation>) {
        this.items = items
        notifyDataSetChanged()
    }


}
