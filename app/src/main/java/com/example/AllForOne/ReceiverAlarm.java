package com.example.AllForOne;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class ReceiverAlarm  extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //start activity

        Intent i = new Intent();


        i.setClassName("com.example.AllForOne", "com.example.AllForOne.RunAlarm");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}