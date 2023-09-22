package com.matalex.appmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.matalex.appmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listItems = ArrayList<String>()
        listItems.add("Alex")



        val adapter = ArrayAdapter(this,R.layout.list_item,listItems)
        binding.listView.adapter = adapter


    }
}