package dev.cancio.listmaker.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.listmaker.R

class TodoListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var positionTextView = itemView.findViewById<TextView>(R.id.itemNumber)
    var titleTextView = itemView.findViewById<TextView>(R.id.itemString)
}