package com.example.a23012011072_mad_prac6

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), Animation.AnimationListener {
    lateinit var alarmAnimation: AnimationDrawable
    lateinit var heartAnimation: AnimationDrawable
    lateinit var alarmImage: ImageView
    lateinit var heartImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            alarmImage=findViewById(R.id.img1)
            alarmImage.setBackgroundResource(R.drawable.alarm_animation_list)
            alarmAnimation=alarmImage.background as AnimationDrawable
            heartImage=findViewById<ImageView>(R.id.img2)
            heartImage.setBackgroundResource(R.drawable.heart_animation_list)
            heartAnimation=heartImage.background as AnimationDrawable
            alarmAnimation.start()
            heartAnimation.start()
        }
        else{
            alarmAnimation.stop()
            heartAnimation.stop()
        }
    }

    override fun onAnimationEnd(animation: Animation?) {
        Intent(this, MainActivity::class.java).also { startActivity(it) }
    }

    override fun onAnimationRepeat(animation: Animation?) {

    }

    override fun onAnimationStart(animation: Animation?) {

    }
}