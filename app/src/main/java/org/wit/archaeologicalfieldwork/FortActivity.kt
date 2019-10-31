package org.wit.archaeologicalfieldwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_fort.*

class FortActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fort)

        registration.setOnClickListener {
            showRegistration()
        }
        login.setOnClickListener {
            showLogin()
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
