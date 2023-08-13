package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val toDoList = mutableListOf(
            ToDo("Clean the Room", false),
            ToDo("Learn Kotlin for android Dev", false),
            ToDo("Learn how to use RecyclerView", true),
            ToDo("Become a millionaire", true)
        )

        val adapter = ToDoAdapter(toDoList)

        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val title = binding.etToDo.text.toString()
            val todo = ToDo(title, false)
            toDoList.add(todo)
            adapter.notifyItemInserted(toDoList.size - 1)
        }
    }
}