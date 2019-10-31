package org.wit.archaeologicalfieldwork

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import org.wit.archaeologicalfieldwork.MainActivity as M

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        //4 second splash time
        Handler().postDelayed({
            //start main activity
            startActivity(Intent( this@MainActivity, FortActivity::class.java))
            //finish this activity
            finish()
        },4000)
    }
}
