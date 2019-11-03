package org.wit.archaeologicalfieldwork

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_login.*
import kotlinx.android.synthetic.main.user_registration.*
import kotlinx.android.synthetic.main.activity_main.login_layout as login_layout1
import kotlinx.android.synthetic.main.user_registration.register_layout as register_layout1


class MainActivity : AppCompatActivity() {

    lateinit var handler: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setting toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        //home navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        handler = DatabaseHelper(this)

        showHome()

        registration.setOnClickListener {
            showRegistration()
        }
        login.setOnClickListener {
            showLogin()
        }

        save.setOnClickListener {
            handler.insertUserData(
                reg_name.text.toString(),
                reg_email.text.toString(),
                reg_password.text.toString()
            )
            showHome()
        }
        login_button.setOnClickListener{
            if( handler.userPresent(login_email.text.toString(),login_password.text.toString()))
                Toast.makeText(this,"login success", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Username or password is incorrect", Toast.LENGTH_SHORT).show()
        }
    }

        //setting menu in action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.navigation,menu)
            return super.onCreateOptionsMenu(menu)
        }

        // actions on click menu items

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
            R.id.logout -> {
                // User chose the "Logout" item
                Toast.makeText(this,"Logout action",Toast.LENGTH_LONG).show()
                true
            }
            R.id.navigation_hillforts -> {
                // User chose the "Logout" item
                Toast.makeText(this,"Navigation action",Toast.LENGTH_LONG).show()
                true
            }
            R.id.add_hillfort -> {
                // User chose the "Logout" item
                Toast.makeText(this,"Add action",Toast.LENGTH_LONG).show()
                true
            }
            R.id.delete_hillfort -> {
                // User chose the "Logout" item
                Toast.makeText(this,"Delete action",Toast.LENGTH_LONG).show()
                true
            }
            android.R.id.home ->{
                Toast.makeText(this,"Home action",Toast.LENGTH_LONG).show()
                true
            }

            else -> {
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                super.onOptionsItemSelected(item)
            }
        }
    private fun showRegistration(){
        register_layout.visibility=View.VISIBLE
        login_layout.visibility=View.GONE
        home_11.visibility=View.GONE
    }
    private fun showLogin(){
        register_layout.visibility=View.GONE
        login_layout.visibility=View.VISIBLE
        home_11.visibility=View.GONE
    }
    private fun showHome(){
        register_layout.visibility=View.GONE
        login_layout.visibility=View.GONE
        home_11.visibility=View.VISIBLE
    }
}
