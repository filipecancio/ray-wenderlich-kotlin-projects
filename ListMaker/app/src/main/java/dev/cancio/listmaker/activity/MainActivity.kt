package dev.cancio.listmaker.activity

import android.os.Bundle
import android.text.InputType
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.cancio.listmaker.R
import dev.cancio.listmaker.adapter.TodoListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var todoListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        //Set the RecyclerView
        todoListRecyclerView = findViewById(R.id.list_recyclerview)
        todoListRecyclerView.layoutManager = LinearLayoutManager(this)
        todoListRecyclerView.adapter = TodoListAdapter()

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            var adapter = todoListRecyclerView.adapter as TodoListAdapter
            showDialog(adapter)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showDialog(todoListAdapter: TodoListAdapter) {
        val todoListEditText = EditText(this)
        todoListEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_CAP_WORDS

        val dialog = AlertDialog.Builder(this)
            .setTitle("What's the name of your todo?")
            .setView(todoListEditText)
            .setPositiveButton("Create"){ dialog,_->
                todoListAdapter.addNewItem(todoListEditText.text.toString())
                dialog.dismiss()
            }
        dialog.create().show()
    }
}