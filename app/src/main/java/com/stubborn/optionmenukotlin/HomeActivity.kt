package com.stubborn.optionmenukotlin

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.custom_toast.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.show();

        setContentView(R.layout.activity_home)

        //setting text to text view

        //custom Toast
        val layout = layoutInflater.inflate(R.layout.custom_toast, linearLayout)
        val myToast = Toast(applicationContext)
        myToast.duration = Toast.LENGTH_LONG
        myToast.setGravity(
            Gravity.CENTER_VERTICAL, 0, 0
        )
        myToast.view = layout
        myToast.show()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> Toast.makeText(this, "HTML", Toast.LENGTH_LONG).show()
            // R.id.css -> Toast.makeText(this, "CSS", Toast.LENGTH_LONG).show()
            // R.id.boot -> Toast.makeText(this, "Bootstrap", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    fun openGoogle(view: View) {
        val intent = Intent(this, GoogleWebPageActivity::class.java)
        startActivity(intent)
    }

    fun openShowUserData(view: View) {
        val intent = Intent(this, UserDataActivity::class.java)

        var s_show_name: String = intent.getStringExtra("email")
        var s_show_pass: String = intent.getStringExtra("password")

        intent.putExtra("Email", s_show_name)
        intent.putExtra("Password", s_show_pass)
        startActivity(intent)
    }

    fun openShowContextMenu(view: View) {
        val intent = Intent(this, ContextMenuActivity::class.java)
        startActivity(intent)
    }

    fun openShowListView(view: View) {
        val intent = Intent(this, ListActivity::class.java)
        startActivity(intent)
    }

    fun openPopup(view: View) {
        val intent = Intent(this, PopUpActivity::class.java)
        startActivity(intent)
    }

    fun openMap(view: View) {
        val intent = Intent(this, MapActivity::class.java)
        startActivity(intent)
    }

}

