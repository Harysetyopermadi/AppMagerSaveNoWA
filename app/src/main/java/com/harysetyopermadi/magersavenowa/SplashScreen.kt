package com.harysetyopermadi.magersavenowa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.core.content.ContextCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val window=this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor= ContextCompat.getColor(this,R.color.white)

        Handler().postDelayed({
            val i= Intent(this,MainActivity::class.java)
            startActivity(i)
            finish()
        },3000

        )

    }
}