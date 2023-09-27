package com.example.mad_practical_8_22172012007

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class AlarmBroadcastReciver : BroadcastReceiver() {
companion object{
    val ALRAMKEY = "Key"
    val ALRAMSTART = "Start"
    val ALRAMSTOP = "Stop"

}
    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val data = intent.getStringExtra(ALRAMKEY)
        val intentsrevice = Intent(context,AlarmService::class.java)
        if (data == ALRAMSTART){
            context.startService(intentsrevice)
            }
        else
        {
            context.stopService(intentsrevice)
        }
    }

}