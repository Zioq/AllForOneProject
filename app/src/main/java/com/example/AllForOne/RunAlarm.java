package com.example.AllForOne;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


import android.os.Bundle;

public class RunAlarm extends AppCompatActivity {

    //Alarm sound
    private Uri ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

    private AudioManager audioManager;
    private MediaPlayer mp;

    private ImageButton mAlarm;
    private int status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_alarm);

        mAlarm = findViewById(R.id.custom_button);

        Toast.makeText(RunAlarm.this, "Time is done!!", Toast.LENGTH_SHORT).show();
        mAlarm.setBackgroundResource(R.drawable.button_default);

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume (AudioManager.STREAM_MUSIC,audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC),0);

        float count=100*.01f;
        mp=new MediaPlayer();
        mp.setLooping(false);
        mp = MediaPlayer.create(RunAlarm.this, ringtoneUri);
        mp.setVolume(count,count);


        status = 1;
        if (mp != null) {
            mp.start();
        }
        mAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(status==1){
                    mp.pause();
                    mAlarm.setBackgroundResource(R.drawable.button_disabled);
                    status =0;
                }else if(status==0){
                    Toast.makeText(RunAlarm.this, "Set a new alarm", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}