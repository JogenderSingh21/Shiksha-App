package com.example.exmpl

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.Toast
import android.widget.VideoView

class VideoActivity : AppCompatActivity() {

    private lateinit var vid:VideoView
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler
    private lateinit var seekbar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

    // Getting video ResourceId by intent
        val videoResourceId = intent.getIntExtra("video", 0) // 0 is the default value if "video" is not found
        if (videoResourceId == 0) {
            // Now, you can use the videoResourceId to play the video
            Toast.makeText(this, "Video resource not provided", Toast.LENGTH_SHORT).show()
        }

    // Video Player
        vid = findViewById(R.id.vid)
        vid.setVideoPath("android.resource://$packageName/$videoResourceId")
        vid.start()

        seekbar = findViewById(R.id.vidSeekBar)
        handler = Handler(Looper.getMainLooper())
        seekbar.progress = 0

        vid.setOnPreparedListener{
            seekbar.max = vid.duration
            vid.start()
            seekbar.progress = vid.currentPosition
            changeSeekbar(vid)
        }

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, pos: Int, changed: Boolean) {
                if(changed){
                    vid.seekTo(pos)
                }
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {}
            override fun onStopTrackingTouch(p0: SeekBar?) {}
        })

        val playPause = findViewById<ImageButton>(R.id.playPause)
        playPause.setOnClickListener{
            if(vid.isPlaying){
                vid.pause()
                playPause.setImageResource(R.drawable.baseline_play_arrow_24)
            } else{
                vid.start()
                playPause.setImageResource(R.drawable.baseline_pause_24)
                changeSeekbar(vid)
            }
        }

        vid.setOnCompletionListener {
            playPause.setImageResource(R.drawable.baseline_play_arrow_24)
        }


    // PDF File Open
        val showHandout = findViewById<Button>(R.id.showHandout)
        showHandout.setOnClickListener {
            val intent = Intent(this, PdfViewerActivity::class.java)
            startActivity(intent)
        }

    }

    private fun changeSeekbar(videoView: VideoView) {
        seekbar.progress = videoView.currentPosition
        if (videoView.isPlaying) {
            runnable = Runnable {
                changeSeekbar(videoView)
            }
            handler.postDelayed(runnable, 100)
        }
    }
}