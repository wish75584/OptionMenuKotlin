package com.stubborn.optionmenukotlin

import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_context_menu.*

class ContextMenuActivity : AppCompatActivity() {
    private val strings = arrayOf<String>("John", "Doe", "Andy", "Sandra", "Felix", "Anam")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)


        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1, strings
        )
        listView.adapter = arrayAdapter
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.call -> Toast.makeText(this, "Call", Toast.LENGTH_LONG).show()
            R.id.sms -> Toast.makeText(this, "SMS", Toast.LENGTH_LONG).show()
            R.id.email -> Toast.makeText(this, "Email", Toast.LENGTH_LONG).show()
        }
        return super.onContextItemSelected(item)
    }
}
