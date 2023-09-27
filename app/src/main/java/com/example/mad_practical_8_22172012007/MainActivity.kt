package com.example.mad_practical_8_22172012007

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun setAlarm(militime:Long,action:String)
    {
        val intentalrm = Intent(applicationContext,AlarmBroadcastReciver::class.java)
        intentalrm.putExtra(AlarmBroadcastReciver.ALRAMKEY,action)
        val pendingintent = PendingIntent.getBroadcast(applicationContext,4345,intentalrm,PendingIntent.FLAG_UPDATE_CURRENT)
        val manager= getSystemService(ALARM_SERVICE) as AlarmManager
        if (action==AlarmBroadcastReciver.ALRAMSTART)
        {
            manager.setExact(AlarmManager.RTC_WAKEUP,militime,pendingintent)
        }
        else
        {
            manager.cancel(pendingintent)
            sendBroadcast(intentalrm)
        }
    }
}