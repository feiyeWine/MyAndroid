package com.testmedia;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * 测试播放音乐
 */
public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private MediaPlayer player;
    private Button btnStart,btnPause,btnStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = MediaPlayer.create(this,R.raw.lanhuanzhi);

        btnStart = (Button) findViewById(R.id.btn_main_start);
        btnPause = (Button) findViewById(R.id.btn_main_pause);
        btnStop = (Button) findViewById(R.id.btn_main_stop);
        btnStart.setOnClickListener(this);
        btnPause.setOnClickListener(this);
        btnStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_main_start:
                    if (!player.isPlaying()) {
                        if(player==null){
                            player = MediaPlayer.create(this,R.raw.lanhuanzhi);
                        }
                        player.start();
                    } else {
                        player.reset();
                        player.start();
                    }
                break;
            case R.id.btn_main_pause:
                if(player.isPlaying()){
                    player.pause();
                }
            case R.id.btn_main_stop:
                if(player.isPlaying()){
                    player.stop();
                  //player.release();
                }
        }
    }
}
