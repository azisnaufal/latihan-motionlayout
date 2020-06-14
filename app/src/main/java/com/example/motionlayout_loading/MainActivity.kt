package com.example.motionlayout_loading

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.transition.AutoTransition
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mScene1: Scene
    private lateinit var mScene2: Scene
    private lateinit var mScene3: Scene
    private lateinit var transition: AutoTransition
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mScene1 = Scene.getSceneForLayout(scene_root, R.layout.scene1, this)
        mScene2 = Scene.getSceneForLayout(scene_root, R.layout.scene2, this)
        mScene3 = Scene.getSceneForLayout(scene_root, R.layout.scene3, this)

        transition = AutoTransition().apply {
            duration = 500L
        }

    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        if (hasFocus){
            val timer = Timer()
            var i = 1
            val timerTask = object  : TimerTask(){
                override fun run() {
                    runOnUiThread {
                        if (i == 1){
                            TransitionManager.go(mScene2, transition)
                            i = 2
                        }
                        else if (i == 2){
                            TransitionManager.go(mScene3, transition)
                            i = 1
                        }
                    }
                }
            }

            timer.schedule(timerTask, 0, 500)

        }
    }
}