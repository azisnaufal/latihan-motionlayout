package com.example.motionlayout_loading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus){
            val timer = Timer()
            var i = 0
            val timerTask = object  : TimerTask(){
                override fun run() {
                    runOnUiThread {
                        if (i == 0){
                            root_layout.setTransition(R.id.transition_first)
                            root_layout.transitionToStart()
                            root_layout.transitionToEnd()
                            i = 1
                        }
                        else if (i == 1){
                            root_layout.setTransition(R.id.transition_second)
                            root_layout.transitionToStart()
                            root_layout.transitionToEnd()
                            i = 2
                        }
                        else if (i == 2){
                            root_layout.setTransition(R.id.transition_third)
                            root_layout.transitionToStart()
                            root_layout.transitionToEnd()
                            i = 1
                        }
                    }
                }
            }

            timer.schedule(timerTask, 0, 500)

        }
    }
}