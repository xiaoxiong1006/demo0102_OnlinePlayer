package com.example.demo0102_onlineplayer

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mp: MediaPlayer? = null
    private var playUri = Uri.parse("http://www.gproom.tech/static/html/chapter01/audios/darktown_strutters_ball.mp3")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab_play.setOnClickListener {
            // 1.如果MediaPlayer对象mp为空，则实例化MediaPlayer对象
            if (mp == null) {
                mp = MediaPlayer.create(this, playUri)
                // 提示正在缓冲
                Toast.makeText(this,"正在缓冲", Toast.LENGTH_SHORT).show()
            }
            // 2.播放
            mp!!.start()
        }

        fab_pause.setOnClickListener {
            mp?.pause()
        }

        fab_stop.setOnClickListener {
            mp?.stop()
            mp?.reset()
            mp?.release()
            mp=null
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        mp?.stop()
        mp?.reset()
        mp?.release()
        mp=null
    }

}
