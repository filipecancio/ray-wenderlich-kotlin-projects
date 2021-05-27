package dev.cancio.listmaker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.listmaker.R
import dev.cancio.listmaker.viewholder.TodoListViewHolder

class TodoListAdapter : RecyclerView.Adapter<TodoListViewHolder>() {
    val lista = mutableListOf("joao", "pedro", "carlos")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.viewhold_viewlist, parent, false)
        return TodoListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.positionTextView.text = (position + 1).toString()
        holder.titleTextView.text = lista[position]
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun addNewItem(message: String){
        lista.add(message)
        notifyDataSetChanged()
    }
}