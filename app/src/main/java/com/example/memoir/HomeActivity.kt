package com.example.memoir // CHANGE THIS TO YOUR PACKAGE NAME

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 1. Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewMemories)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 2. Create Dummy Data (Test Data)
        val memoryList = listOf(
            MemoryModel("Project Kickoff", "Nov 19, 2025", "Started the Memoir app with the team."),
            MemoryModel("Design Phase", "Nov 20, 2025", "Chose the color palette: Slate, Cream, and Olive."),
            MemoryModel("Coding Sprint", "Nov 21, 2025", "Fixed the RecyclerView errors and finished the Home page.")
        )

        // 3. Set Adapter
        val adapter = MemoryAdapter(memoryList)
        recyclerView.adapter = adapter

        // 4. Add Button Logic
        val fabAdd: FloatingActionButton = findViewById(R.id.fabAdd)
        fabAdd.setOnClickListener {
            Toast.makeText(this, "Navigating to Add Memory...", Toast.LENGTH_SHORT).show()
            // Future Code: startActivity(Intent(this, AddMemoryActivity::class.java))
        }
    }
}